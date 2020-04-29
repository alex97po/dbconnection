package com.pogorelov.dbconnection.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogorelov.dbconnection.domain.Department;
import com.pogorelov.dbconnection.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/departments")
public class DepartmentController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameterMap().containsKey("id")){
            Long departmentId = Long.parseLong(req.getParameter("id"));
            Department department = serviceFactory.getDepartmentService().findDepartmentById(departmentId);
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            writer.println(objectMapper.writeValueAsString(department));
        } else {
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            List<Department> departments = serviceFactory.getDepartmentService().getAllDepartments();
            writer.println(objectMapper.writeValueAsString(departments));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department =
                objectMapper.readValue(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())), Department.class);
        serviceFactory.getDepartmentService().createDepartment(department);
        resp.setStatus(204);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long departmentId = Long.parseLong(req.getParameter("id"));
        serviceFactory.getDepartmentService().deleteDepartment(departmentId);
        resp.setStatus(204);
    }
}
