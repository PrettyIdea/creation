package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductPictureDao;

public class ProductPictureService {
    private ProductPictureDao productPictureDao = new ProductPictureDao();

    public void save(Long productId, String name) throws SQLException {
        this.productPictureDao.save(productId, name);
    }

    public List<String> findByProductId(Long productId) throws SQLException {
        return this.productPictureDao.findByProductId(productId);
    }
}
