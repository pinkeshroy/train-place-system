/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import trandpl.dbutil.DBConnection;
import trandpl.pojo.CurrentUser;
import trandpl.pojo.UserPojo;

/**
 *
 * @author HP
 */
public class UserDao {
    public static boolean validateUser(UserPojo user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and type=?");
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getType());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            CurrentUser.setUserid(rs.getString(1));
            CurrentUser.setId(rs.getString(2));
            CurrentUser.setName(rs.getString(3));
            CurrentUser.setType(rs.getString(5));
            return true;
        }
        return false;
    }
}
