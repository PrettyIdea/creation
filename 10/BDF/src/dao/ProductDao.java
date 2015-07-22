package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import entity.ProductCategory;

public class ProductDao {

    public int findCount(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int count = 0;
        try{
            conn = DbUtil.getConnection();
            String sql="select count(id) from product ";
            if(name != null && !name.isEmpty()) {
                name = "%" + name + "%";
                sql +=  "where name like ?";
            }
            ps=conn.prepareStatement(sql);
            if(name != null && !name.isEmpty()) {
                ps.setString(1, name);
            }
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return count;
    }

    public List<Product> list(int pageNum, int offset, String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Product> result = new ArrayList<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select p.id, p.name, p.price, p.quantity, p.description, c.name "
                    + "from product p left join product_category c on (p.product_category_id = c.id)";
            if(name != null && !name.isEmpty()) {
                name = "%" + name + "%";
                sql +=  "where p.name like ? ";
                sql += " limit ? offset ?";
                ps=conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, pageNum);
                ps.setInt(3, offset);
            } else {
                sql += " limit ? offset ?";
                ps=conn.prepareStatement(sql);
                ps.setInt(1, pageNum);
                ps.setInt(2, offset);
            }
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                product.setQuantity(resultSet.getLong(4));
                product.setDescription(resultSet.getString(5));
                ProductCategory pc = new ProductCategory();
                pc.setName(resultSet.getString(6));
                product.setProductCategory(pc);
                result.add(product);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

    public Product findById(Long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Product product = null;
        try{
            conn = DbUtil.getConnection();
            String sql="select p.id, p.name, p.price, p.quantity, p.description, p.product_category_id from product p where p.id = 3";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                product.setQuantity(resultSet.getLong(4));
                product.setDescription(resultSet.getString(5));
                ProductCategory pc = new ProductCategory();
                pc.setId(resultSet.getLong(6));
                product.setProductCategory(pc);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return product;
    }


    public Product findByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Product product = null;
        try{
            conn = DbUtil.getConnection();
            String sql="select p.id, p.name, p.price, p.quantity, p.description, p.product_category_id from product p where p.name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                product.setQuantity(resultSet.getLong(4));
                product.setDescription(resultSet.getString(5));
                ProductCategory pc = new ProductCategory();
                pc.setId(resultSet.getLong(6));
                product.setProductCategory(pc);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return product;
    }

    public void insert(Product product) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql= "insert into product (name, price, quantity, description, product_category_id) values(?, ?, ?, ?, ?) ";
            ps=conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setLong(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            ps.setLong(5, product.getProductCategory().getId());
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }

    public void update(Product product) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql="update product set name=?, price=?, quantity=?, description=?, product_category_id=? where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setLong(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            ps.setLong(5, product.getProductCategory().getId());
            ps.setLong(6, product.getId());
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }

    public void deleteById(Long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql="delete from product where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }

    public int findCount(Long categoryId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int count = 0;
        try{
            conn = DbUtil.getConnection();
            String sql="select count(id) from product ";
            if(categoryId != null) {
                sql +=  "where product_category_id = ?";
            }
            ps=conn.prepareStatement(sql);
            if(categoryId != null) {
                ps.setLong(1, categoryId);
            }
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return count;
    }

    public List<Product> list(int pageNum, int offset, Long categoryId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Product> result = new ArrayList<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select p.id, p.name, p.price, p.quantity, p.description, (select pp.name from product_picture pp where pp.product_id = p.id limit 1) as pic "
                    + "from product p ";
            if(categoryId != null) {
                sql +=  "where p.product_category_id = ? ";
                sql += " limit ? offset ?";
                ps=conn.prepareStatement(sql);
                ps.setLong(1, categoryId);
                ps.setInt(2, pageNum);
                ps.setInt(3, offset);
            } else {
                sql += " limit ? offset ?";
                ps=conn.prepareStatement(sql);
                ps.setInt(1, pageNum);
                ps.setInt(2, offset);
            }
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getFloat(3));
                product.setQuantity(resultSet.getLong(4));
                product.setDescription(resultSet.getString(5));
                product.setDefaultPicture(resultSet.getString("pic"));
                result.add(product);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

}
