package service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductCategroyDao;
import entity.ProductCategory;
import surpport.PageBean;

/**
 * @author baishuang
 *
 */
/**
 * @author baishuang
 *
 */
/**
 * @author baishuang
 *
 */
public class ProductCategroyService {
    private ProductCategroyDao dao = new ProductCategroyDao();

    public PageBean<ProductCategory> list(PageBean<ProductCategory> pageBean) {
        int pageNum = pageBean.getNumPerPage();
        int offset = pageBean.getOffset();
        String[] queryParams = pageBean.getQueryParam().get("name");
        String name = queryParams != null && queryParams.length > 0 ? queryParams[0].trim() : null;
        int totalCount;
        List<ProductCategory> list;
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

    public ProductCategory findById(Long id) {
        try {
            return this.dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }

    /**
     * 检索所有一级，二级分类,key是id，value是:name+"--"+level
     * @return
     */
    public Map<Long, String> findAll() {
        try {
            return this.dao.findAllMap();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    public ProductCategory findByName(String name) {
        try {
            return this.dao.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveOrUpdate(Long id, String name, Integer level, Long superId) throws SQLException{
        if(id == null) {
            this.dao.insert(name, level, superId);
        }else{
            this.dao.update(id, name, level, superId);
        }
    }

    public void delete(Long id) throws SQLException{
        this.dao.deleteById(id);
    }

    public List<ProductCategory> findThreeLevel() {
        try {
            return this.dao.findThreeLevel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * 检索所有一级分类，一级分类中组装二级分类，二级分类组装三级分类
     * @return
     * @throws SQLException
     */
    public List<ProductCategory> getAll() throws SQLException {
        List<ProductCategory> categorys = this.dao.findAll();
        Map<Long, ProductCategory> map = new HashMap<>();
        for (ProductCategory productCategory : categorys) {
            map.put(productCategory.getId(), productCategory);
        }
        for (ProductCategory productCategory : categorys) {
            if(productCategory.getLevel() != 1) {
                ProductCategory superCategory= map.get(productCategory.getProductCategoryId()); //找到父分类的id
                if(superCategory != null){
                    superCategory.getSubCategorys().add(productCategory);
                }
            }
        }
        categorys.clear();
        for (ProductCategory productCategory : map.values()) {
            if(productCategory.getLevel() == 1) {
                categorys.add(productCategory);
            }
        }
        return categorys;
    }
}
