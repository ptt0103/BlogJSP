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

/**
 *
 * @author LENOVO
 */
public class TopicRepository {

    private Connection topicRepo;

    public TopicRepository() {
        this.topicRepo = connectDB.getConnection();
    }

    public List<String> getAllTopic() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select * from topic";
            PreparedStatement ps = topicRepo.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
