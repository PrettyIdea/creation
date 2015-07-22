package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;

public class AdminDao {

    public Admin findByName(String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try{
            conn = DbUtil.getConnection();
            String sql="select id, name, password, real_name from admin where name = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setName(resultSet.getString("name"));
                admin.setPassword(resultSet.getString("password"));
                admin.setRealName(resultSet.getString("real_name"));
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
        return admin;
    }

    public void save(Admin admin) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.getConnection();
            String sql="insert into admin (name, password, real_name) values(?, ?, ?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getRealName());
            ps.executeUpdate();
        } finally {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }
    }
}
