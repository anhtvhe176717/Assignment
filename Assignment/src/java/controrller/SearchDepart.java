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
import java.util.List;
import model.Department;
import model.Personnel;
import model.Role;

/**
 *
 * @author admin
 */
public class SearchDepart extends HttpServlet {

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
            out.println("<title>Servlet SearchDepart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchDepart at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        PersonDAO pd = new PersonDAO();
        DepartDAO dp = new DepartDAO();
        RoleDAO rd = new RoleDAO();

        String s = request.getParameter("search");
        String code = request.getParameter("code");
        List<Department> listd = dp.getAllDepart();
        List<Role> listr = rd.getAllRole();
        Department d = dp.getDepartCodeDepart(code);
        if (d != null) {
            List<Personnel> listp = pd.searchPersonByDepart(s, d.getId());
            if (!listp.isEmpty()) {
                request.setAttribute("listp", listp);
                request.setAttribute("listd", listd);
                request.setAttribute("listr", listr);
                request.setAttribute("depart", d);

                request.getRequestDispatcher("department.jsp").forward(request, response);

            } else {

                request.setAttribute("listd", listd);
                request.setAttribute("listr", listr);
                request.getRequestDispatcher("department.jsp").forward(request, response);

            }
        } else {

            List<Personnel> listp = pd.searchPerson("null");
            if (!listp.isEmpty()) {
                request.setAttribute("listp", listp);
                request.setAttribute("listd", listd);
                request.setAttribute("listr", listr);
                request.setAttribute("depart", d);
                request.getRequestDispatcher("department.jsp").forward(request, response);

            } else {
                request.setAttribute("listd", listd);
                request.getRequestDispatcher("department.jsp").forward(request, response);

            }
        }

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
