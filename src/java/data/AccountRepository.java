/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author LENOVO
 */
public class AccountRepository {
    private Connection accRepo;

    public AccountRepository(){
        accRepo = connectDB.getConnection();
    }
    
    public User login(String username, String password){
        try {
            String sql = "select * from users where username=? and password=?";
            
            PreparedStatement st = accRepo.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                return new User(rs.getInt("id"),rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        return null;
    }
    
    public User getUserByUsername(String username){
        try {
            String sql = "select * from users where username=?";
          
            PreparedStatement ps = accRepo.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new User(rs.getInt("id"),rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public User getUserByID(int id){
        try {
            String sql = "select * from users where id=?";
            
            PreparedStatement ps = accRepo.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new User(rs.getInt("id"),rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public int register(User user){
        try {
            String sql = "insert into users (username, password, name, role) values (?,?,?,?)" ;
            PreparedStatement ps = accRepo.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getRole());
            return ps.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }
}
