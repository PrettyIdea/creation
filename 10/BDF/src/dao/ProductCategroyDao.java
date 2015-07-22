package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.ProductCategory;

public class ProductCategroyDao {

    public int findCount(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int count = 0;
        try{
            conn = DbUtil.getConnection();
            String sql="select count(id) from product_category ";
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

    public List<ProductCategory> list(int pageNum, int offset, String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<ProductCategory> result = new ArrayList<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select pc.id, pc.name, pc.level, pcs.name "
                    + "from product_category pc left join product_category pcs "
                    + "on (pc.product_category_id = pcs.id) ";
            if(name != null && !name.isEmpty()) {
                name = "%" + name + "%";
                sql +=  "where pc.name like ? ";
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
                ProductCategory productCategory = new ProductCategory();
                productCategory.setId(resultSet.getLong(1));
                productCategory.setName(resultSet.getString(2));
                productCategory.setLevel(resultSet.getInt(3));
                productCategory.setSuperName(resultSet.getString(4));
                result.add(productCategory);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

    public ProductCategory findById(Long id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ProductCategory result = null;
        try{
            conn = DbUtil.getConnection();
            String sql="select id, name, level, product_category_id from product_category where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                result = new ProductCategory();
                result.setId(resultSet.getLong("id"));
                result.setName(resultSet.getString("name"));
                result.setLevel(resultSet.getInt("level"));
                result.setProductCategoryId(resultSet.getLong("product_category_id"));
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

    public Map<Long, String> findAllMap() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Map<Long, String> result = new HashMap<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select pc.id, pc.name, pc.level "
                    + "from product_category pc where level < 3";
          
            ps=conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                result.put(resultSet.getLong("id"), resultSet.getString("name")+ "--" + resultSet.getInt("level"));
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

    public ProductCategory findByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ProductCategory result = null;
        try{
            conn = DbUtil.getConnection();
            String sql="select id, name, level, product_category_id from product_category where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                result = new ProductCategory();
                result.setId(resultSet.getLong("id"));
                result.setName(resultSet.getString("name"));
                result.setLevel(resultSet.getInt("level"));
                result.setProductCategoryId(resultSet.getLong("product_category_id"));
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

    public void insert(String name, Integer level, Long superId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql=null;
            if(superId != null){
                sql =  "insert into product_category (name, level, product_category_id) values(?, ?, ?) ";
            }else {
                sql =  "insert into product_category (name, level) values(?, ?) ";
            }
            ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, level);
            if (superId != null) {
                ps.setLong(3, superId);
            }
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }

    public void update(Long id, String name, Integer level, Long superId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql="update product_category set name = ?, level = ?, product_category_id = ? where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, level);
            ps.setLong(3, superId);
            ps.setLong(4, id);
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
            String sql="delete from product_category where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }

    public List<ProductCategory> findThreeLevel() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<ProductCategory> result = new ArrayList<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select id, name, level, product_category_id from product_category where level = 3";
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                ProductCategory productCategory = new ProductCategory();
                productCategory.setId(resultSet.getLong("id"));
                productCategory.setName(resultSet.getString("name"));
                productCategory.setLevel(resultSet.getInt("level"));
                productCategory.setProductCategoryId(resultSet.getLong("product_category_id"));
                result.add(productCategory);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

    public List<ProductCategory> findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<ProductCategory> result = new ArrayList<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select pc.id, pc.name, pc.level, product_category_id "
                    + "from product_category pc ";
          
            ps=conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                ProductCategory p = new ProductCategory();
                p.setId(resultSet.getLong("id"));
                p.setName(resultSet.getString("name"));
                p.setLevel(resultSet.getInt("level"));
                p.setProductCategoryId(resultSet.getLong("product_category_id"));
                result.add(p);
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

}
