/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package user_controller;

import data.BlogRepository;
import data.TopicRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Blog;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "Blogs", urlPatterns = {"/blogs"})
public class Blogs extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("user_id" )!= null){
            List<String> topics = new TopicRepository().getAllTopic();
            
            String q = request.getParameter("q");
            System.out.println(q);
            List<Blog> blogs = new BlogRepository().getAllBlogs();
            List<Blog> SearchBlogs = new ArrayList<>();
            if(q!= null){
                for(Blog blog : blogs){
                    if(blog.getTitle().toLowerCase().contains(q.toLowerCase())){
                        SearchBlogs.add(blog);
                    }
                }
                request.setAttribute("listBlog", SearchBlogs);
            }
            else{
                request.setAttribute("listBlog", blogs);
            }
            request.setAttribute("listTopic", topics);
            request.getServletContext().getRequestDispatcher("/blogs.jsp").forward(request, response);
        }
        else{
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

}
