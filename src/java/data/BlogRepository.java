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

/**
 *
 * @author LENOVO
 */
public class BlogRepository {
    private Connection blogRepo;
    
    public BlogRepository() {
        this.blogRepo = connectDB.getConnection();
    }
    
    public List<Blog> getAllBlogs(){
        List<Blog> list = new ArrayList<>();
        try {
            String sql = "select * from blog";
            PreparedStatement ps = blogRepo.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Blog(rs.getInt("id"),new AccountRepository().getUserByID(rs.getInt("user_id")) ,rs.getString("title"), rs.getString("content"), 
                        rs.getString("date"), rs.getString("img"), rs.getInt("topic_id")));
            }
            
        } catch (Exception e) {
        }
        
        
        
        return list;
    }
    
    public Blog addBlog(Blog blog){
        try {
            String sql = "insert into blog(title, content, user_id, date, img, topic_id) values (?,?,?,?,?,?)";
            
            PreparedStatement ps = blogRepo.prepareStatement(sql);
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getContent());
            ps.setInt(3, blog.getUser().getId());
            ps.setString(4, blog.getDate());
            ps.setString(5, blog.getImg());
            ps.setInt(6, blog.getTopic_id());
            ps.executeUpdate();
            return blog;
        } catch (Exception e) {
        }
        return null;
             
    }
    
    public Blog getBlogByID(int id){
        ArrayList<Comment> list =(ArrayList<Comment>) new CommentRepository().getAllComment(id);
        
        try {
            String sql = "select * from blog where id=?";
            PreparedStatement ps = blogRepo.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Blog(id,new AccountRepository().getUserByID(rs.getInt("user_id")) ,rs.getString("title"), rs.getString("content"), 
                        rs.getString("date"), rs.getString("img"),list, rs.getInt("topic_id"));
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
