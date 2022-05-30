/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package user_controller;

import data.AccountRepository;
import data.BlogRepository;
import data.TopicRepository;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Blog;
import model.User;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "PostBlog", urlPatterns = {"/postBlog"})
@MultipartConfig
public class PostBlog extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TopicRepository topicRepo = new TopicRepository();
        List<String> listTopic = topicRepo.getAllTopic();
        HttpSession session = request.getSession();
        if (session.getAttribute("user_id") != null) {
            request.setAttribute("listTopic", listTopic);
            request.getServletContext().getRequestDispatcher("/postBlog.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        AccountRepository accRepo = new AccountRepository();
        BlogRepository blogRepo = new BlogRepository();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int topic = Integer.parseInt(request.getParameter("topic"));
        Part filePart = request.getPart("file");
        String fileName = extractFileName(filePart);
        String savePath = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\BTLWeb\\web\\assets\\img\\" + File.separator + fileName;
       
        File fileSaveDir = new File(savePath);
        filePart.write(savePath + File.separator);
      
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("user_id");
        Blog blog = new Blog(accRepo.getUserByID(id), title, content, new SimpleDateFormat("dd-MM-yyyy").format(new Date()), fileName, null, topic);
        System.out.println(blogRepo.addBlog(blog));
        System.out.println(blog);
        response.sendRedirect("/postBlog");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String extractFileName(Part part) {
        String content = part.getHeader("content-disposition");
        String[] items = content.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
