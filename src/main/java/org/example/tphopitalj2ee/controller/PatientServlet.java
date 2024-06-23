package org.example.tphopitalj2ee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.tphopitalj2ee.service.PatientService;

import java.io.File;
import java.io.IOException;

@MultipartConfig(maxFileSize = 1024*1024*5)
@WebServlet(name = "PatientServlet", value = "/patient/*")
public class PatientServlet extends HttpServlet {

    PatientService patientService;

    @Override
    public void init() {
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/create-page":
                request.getRequestDispatcher("/WEB-INF/pages/create-page.jsp").forward(request, response);
                break;
            case "/create":
                createPatient(request, response);
                break;
            case "/list-page":
                request.setAttribute("patients", patientService.findAll());
                System.out.println(patientService.findAll());
                request.getRequestDispatcher("/WEB-INF/pages/list-page.jsp").forward(request, response);
                break;
            case "/display-profile":
                displayProfile(request, response);

                break;
            default:
                response.sendRedirect("dashboard.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private void createPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        String birthDate = request.getParameter("birthdate");

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


        boolean isPatientFound = patientService.findSamePatient(lastName, firstName, birthDate);

        if (isPatientFound) {
            request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
        } else {
            patientService.create(lastName, firstName, birthDate, url);
            response.sendRedirect("list-page");
        }

    }

    private void displayProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("patient", patientService.findPatientById(id));
        request.getRequestDispatcher("/WEB-INF/pages/display-profile.jsp").forward(request, response);
    }




}
