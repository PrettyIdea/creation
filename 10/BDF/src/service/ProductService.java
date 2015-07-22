package service;

import java.sql.SQLException;
import java.util.List;


import java.util.Set;
import java.util.stream.Collectors;

import dao.ProductDao;
import dao.ProductPictureDao;
import entity.Product;
import entity.ProductPicture;
import surpport.PageBean;

public class ProductService {
    private ProductDao dao = new ProductDao();
    private ProductPictureDao productPictruedao = new ProductPictureDao();

    public PageBean<Product> list(PageBean<Product> pageBean) {
        int pageNum = pageBean.getNumPerPage();
        int offset = pageBean.getOffset();
        String[] queryParams = pageBean.getQueryParam().get("name");
        String name = queryParams != null && queryParams.length > 0 ? queryParams[0].trim() : null;
        int totalCount;
        List<Product> list;
        try {
            totalCount = this.dao.findCount(name);
            list = dao.list(pageNum, offset, name);
            pageBean.setTotalCount(totalCount);
            pageBean.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageBean;
    }

    public Product findById(Long id) {
        try {
            Product product = this.dao.findById(id);
            if(product != null) {
                List<String> pics = this.productPictruedao.findByProductId(product.getId());
                //ÃÓ≥‰Õº∆¨–≈œ¢
                Set<ProductPicture> pictureSet = pics.stream()
                    .map(name -> {
                            ProductPicture p = new ProductPicture(); p.setName(name); return p;
                            })
                     .collect(Collectors.toSet());
                product.setProductPictureSet(pictureSet);
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }

    public Product findByName(String name) {
        try {
            return this.dao.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveOrUpdate(Product product) throws SQLException{
        if(product.getId() == null) {
            this.dao.insert(product);
        }else{
            this.dao.update(product);
        }
    }

    public void delete(Long id) throws SQLException{
        this.dao.deleteById(id);
    }

    public PageBean<Product> findPage(PageBean<Product> pageBean) throws SQLException{
        int pageNum = pageBean.getNumPerPage();
        int offset = pageBean.getOffset();
        String[] queryParams = pageBean.getQueryParam().get("categoryId");
        String categoryIdStr = queryParams != null && queryParams.length > 0 ? queryParams[0].trim() : null;
        Long categoryId = categoryIdStr == null ? null : Long.valueOf(categoryIdStr);
        int totalCount;
        List<Product> list;
        try {
            totalCount = this.dao.findCount(categoryId);
            list = dao.list(pageNum, offset, categoryId);
            pageBean.setTotalCount(totalCount);
            pageBean.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageBean;
    }
}
