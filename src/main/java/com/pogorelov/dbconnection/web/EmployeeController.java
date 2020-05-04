package com.pogorelov.dbconnection.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pogorelov.dbconnection.domain.Department;
import com.pogorelov.dbconnection.domain.Employee;
import com.pogorelov.dbconnection.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/employees")
public class EmployeeController extends HttpServlet {

    private final ServiceFactory serviceFactory = new ServiceFactory();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameterMap().containsKey("id")){
            throw new UnsupportedOperationException();
        } else {
            List<Employee> employees = serviceFactory.getEmployeeService().getAllEmployees();
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
        }
    }

}

