package customerwork;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import dao.DbUtil;

/**
 * Servlet implementation class sendTextMail
 */
@WebServlet("/sendMail")
public class sendTextMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendTextMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Properties prop=new Properties();
		prop.setProperty("mail.smtp.host", "smtp.126.com");
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.smtp.socketFactory.fallback", "false");
		prop.setProperty("mail.smtp.port","25");
		prop.setProperty("mail.smtp.socketFactory.port", "25");
		prop.setProperty("mail.smtp.auth", "true");
		Session session=Session.getDefaultInstance(prop,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("zpf12345678910@126.com","zpf123456789");
			}
		});
		
		
		
		String name = (String) request.getSession().getAttribute("name");
		PreparedStatement pstat = null;
	ResultSet rs = null;
    String email=null;
		String sql = null;
		try {
		
		Connection conn = DbUtil.getConnection();
		
		
			//从商品库中取出所选购商品的数据  
			
			sql = "SELECT email FROM customer where name=?";
			
				pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, name);
			rs = pstat.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				email=rs.getString("email");
				conn.close();
			}
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			
			
		Message message=new MimeMessage(session);
		try {
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
			message.setFrom(new InternetAddress(setParameter("zpf12345678910@126.com")));
			message.setSubject("订单成功");
			message.setText("购物愉快");
			message.setSentDate(new Date());
			
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String setParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
