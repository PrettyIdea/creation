package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductPictureDao {

    public void save(Long productId, String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql= "insert into product_picture (name, product_id) values (?, ?) ";
            ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setLong(2, productId);
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }

    public List<String> findByProductId(Long productId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<String> result = new ArrayList<>();
        try{
            conn = DbUtil.getConnection();
            String sql="select  name from product_picture where product_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, productId);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                result.add(resultSet.getString("name"));
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return result;
    }

}
