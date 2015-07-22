package adminwork;

import java.sql.SQLException;

import dao.AdminDao;
import entity.Admin;

public class AdminService {
    private AdminDao adminDao = new AdminDao();

    public Admin findByName(String name) throws SQLException {
        return this.adminDao.findByName(name);
    }
}
