package org.example.tphopitalj2ee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.tphopitalj2ee.service.DoctorService;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "DoctorServlet", value = "/doctor/*")
public class DoctorServlet extends HttpServlet {

    DoctorService doctorService;

    @Override
    public void init() {
        doctorService = new DoctorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/signup-page":
                request.getRequestDispatcher("/WEB-INF/pages/signup-page.jsp").forward(request, response);
                break;
            case "/signin-page":
                request.getRequestDispatcher("/WEB-INF/pages/signin-page.jsp").forward(request, response);
                break;
            case "/signup":
                signup(request, response);
                break;
            case "/signin":
                signin(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String uploadPath = getServletContext().getRealPath("/")+"assets";
        File file = new File(uploadPath);

        if(!file.exists()){
            file.mkdir();
        }

        Part picture = request.getPart("picture");
        String fileName = null;
        if (picture != null) {
            fileName = picture.getSubmittedFileName();
            picture.write(uploadPath+File.separator+fileName);
        }
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/assets/"+fileName;

        doctorService.signUp(lastName, firstName, email, password, url);

        response.sendRedirect("signin-page");
    }

    private void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        doctorService.signIn(email, password);
        response.sendRedirect("index.jsp");
    }



}
