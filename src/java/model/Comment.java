/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Comment {
    private User user;
    private int blog_id;
    private String content;
    
    public Comment() {
    }

    public Comment(User user, int blog_id, String content) {
        this.user = user;
        this.blog_id = blog_id;
        this.content = content;
    }

    

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override

    public String toString() {
        return "Comment{" + "user=" + user + ", blog=" + blog_id + ", content=" + content + '}';
    }
    
    
    
}
