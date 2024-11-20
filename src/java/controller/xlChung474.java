/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nguye
 */
public class xlChung474 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        boolean ok = true;
//        String name = null, startingPoint = null, destination = null, description = null, priceS = null;
//        double price = 0;
//            
//        name = request.getParameter("name");
//        startingPoint = request.getParameter("startingPoint");
//        destination = request.getParameter("destination");
//        description = request.getParameter("description");
//        priceS = request.getParameter("price");
//
//        
//        if(name.equals("") || startingPoint.equals("") || 
//                destination.equals("") || description.equals("") || priceS.equals("")){
//            if(name.equals("")) request.setAttribute("nameError", "Please fill out this field!");
//            if(startingPoint.equals("")) request.setAttribute("startingPointError", "Please fill out this field!");
//            if(destination.equals("")) request.setAttribute("destinationError", "Please fill out this field!");
//            if(description.equals("")) request.setAttribute("descriptionError", "Please fill out this field!");
//            if(priceS.equals("")) request.setAttribute("priceError", "Please fill out this field!");
//            ok = false;
//        }
//        
//        if(!name.equals("")){
//            boolean checkName = TourDB.checkName(name);
//
//            if(checkName == true){
//                request.setAttribute("nameError", "This name was taken!");
//                ok = false;
//            }
//        }
//        
//        if(!priceS.equals("")){
//            Pattern pattern = Pattern.compile("^\\d*\\.?\\d+$");
//            Matcher matcherPrice = pattern.matcher(priceS);
//
//            if(!matcherPrice.matches()){
//                request.setAttribute("priceError", "Invalid number!");
//                ok = false;
//            }else{
//                price = Double.parseDouble(priceS);
//            }
//        }
//        
//        
//        Tour tour = new Tour(name, startingPoint, destination, description, price);
//        
//        if(ok == true){
//            TourDB.insert(tour);
//            request.setAttribute("message", "Successfully added!");
//        }else{
//            request.setAttribute("tour", tour);
//        }
//        getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        
//        HttpSession session = request.getSession();
//        if(session.getAttribute("auth") != null){
//            getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
//        }else{
//            response.sendRedirect("login.jsp");
//        }
        
        request.getRequestDispatcher("gdChinh474.jsp").forward(request, response);
    }

}
