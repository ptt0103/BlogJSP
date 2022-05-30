/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.Comment;
import model.User;

/**
 *
 * @author LENOVO
 */
public class CommentRepository {
    private Connection commentRepo;
    
    
    public CommentRepository() {
        this.commentRepo = connectDB.getConnection();
    }
    
    public List<Comment> getAllComment(int id){
        List<Comment> list = new ArrayList<>();
 
        try {
            String sql = "select * from comments where blog_id=?";
            PreparedStatement ps = commentRepo.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                User user = new AccountRepository().getUserByID(rs.getInt("user_id"));
                list.add(new Comment(user, id, rs.getString("content")));
            }
            return list;
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public Comment postComment(Comment comment){
        try {
            String sql = "insert into comments(user_id, blog_id, content) values(?, ?, ?)";
            PreparedStatement ps = commentRepo.prepareStatement(sql);
            ps.setInt(1, comment.getUser().getId());
            ps.setInt(2, comment.getBlog_id());
            ps.setString(3, comment.getContent());
            ps.executeUpdate();
            return comment;
        } catch (Exception e) {
        }
        return  null;
    }
}
