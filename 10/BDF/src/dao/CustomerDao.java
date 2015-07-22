package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Customer;

/**
 * 用户dao
 * @author DELL
 *
 */

public class CustomerDao {
    public void update(String password,String real_name,String email) throws SQLException {
        Connection conn = DbUtil.getConnection();
        		PreparedStatement ps = null;
        		try{
        String sql="update customer set passsword = ?,real_name=?,email=? where name=?";
        ps=conn.prepareStatement(sql);

        ps.setString(1, password);
        ps.setString(2, real_name);
        ps.setString(3, email);
        
        ps.executeUpdate();
        conn.close();
        		 } finally {
        		        if(ps != null) ps.close();
        		        if(conn != null) conn.close();
        		    }
    }

    public void save(Customer customer) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql="insert into customer(name,password,real_name,email,question,answer) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps=conn.prepareStatement(sql);

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPassword());
        ps.setString(3, customer.getRealName());
        ps.setString(4, customer.getEmail());
        ps.setString(5, customer.getQuestion());
        ps.setString(6, customer.getAnswer());
        ps.executeUpdate();
        conn.close();
    }

    public Customer findByName(String name) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql = "select  name,password,email,point,phone from customer where name =?";
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, name);
        ResultSet resultSet = prepareStatement.executeQuery();
        Customer customer = null;
        while (resultSet.next()) {
            customer = new Customer();
           
            customer.setName(resultSet.getString("name"));
            customer.setPassword(resultSet.getString("password"));
            
            customer.setEmail(resultSet.getString("email"));
            customer.setPoint(resultSet.getInt("point"));
            customer.setPhone(resultSet.getString("phone"));
            
        }
        resultSet.close();
        conn.close();
        return customer;
    }

    /**
     * 根据问题和答案得到密码
     * @param name 
     * @param question
     * @param answer
     * @return 
     * @throws SQLException
     */
    public String findPassword(String name, String question, String answer) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String sql = "select password from customer where name = ? and question = ? and answer = ?";
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, name);
        prepareStatement.setString(2, question);
        prepareStatement.setString(3, answer);
        ResultSet resultSet = prepareStatement.executeQuery();
        String password = null;
        while (resultSet.next()) {
            password = resultSet.getString("password");
        }
        resultSet.close();
        conn.close();
        return password;
    }
}
