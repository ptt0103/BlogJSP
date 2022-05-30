/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Blog {
    private int id, topic_id;
    private User user;
    private String title,content,date, img,topic_name;
    private ArrayList<Comment> comments;

    public Blog() {
    }

    public Blog(int id, User user, String title, String content, String date, String img, int topic_id) {
        this.id = id;
        this.topic_id = topic_id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = date;
        this.img = img;
    }
    
    

    public Blog(User user, String title, String content, String date, String img, ArrayList<Comment> comments,int topic_id) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = date;
        this.img = img;
        this.comments = comments;
        this.topic_id = topic_id;
    }

    
    
    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    
    
    public Blog(int id, User user, String title, String content, String date, String img, ArrayList<Comment> comments, int topic_id) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = date;
        this.img = img;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", topic_id=" + topic_id + ", user=" + user + ", title=" + title + ", content=" + content + ", date=" + date + ", img=" + img + ", comments=" + comments + '}';
    }

    
    
    
}
