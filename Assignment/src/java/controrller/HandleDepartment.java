/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controrller;

import dal.DepartDAO;
import dal.PersonDAO;
import dal.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Department;
import model.Personnel;
import model.Role;

/**
 *
 * @author admin
 */
public class HandleDepartment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HandleDepartment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HandleDepartment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        if (session.getAttribute("account") == null) {
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Home</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>" + "Access Denied" + "</h1>");
                out.println("<h1><a href=login>" + "Click here to Login" + "</a></h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            DepartDAO dp = new DepartDAO();
            PersonDAO pd = new PersonDAO();
            RoleDAO rd = new RoleDAO();
            List<Department> listd = dp.getAllDepart();
            Department d = null;
            request.setAttribute("listd", listd);
            request.setAttribute("depart", d);

            request.getRequestDispatcher("department.jsp").forward(request, response);
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
        DepartDAO dp = new DepartDAO();
        PersonDAO pd = new PersonDAO();
        String code = request.getParameter("department");
        RoleDAO rd = new RoleDAO();
        List<Role> listr = rd.getAllRole();
        List<Department> listd = dp.getAllDepart();
        List<Personnel> listp = pd.getAllFromDepartid(code);
        Department d = dp.getDepartCodeDepart(code);

        request.setAttribute("listd", listd);
        request.setAttribute("listr", listr);
        request.setAttribute("listp", listp);
        request.setAttribute("depart", d);
        request.getRequestDispatcher("department.jsp").forward(request, response);

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
