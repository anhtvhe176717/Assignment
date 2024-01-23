/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controrller;

import dal.DepartDAO;
import dal.PersonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import model.Department;
import model.Personnel;

/**
 *
 * @author admin
 */
public class DeletePerson extends HttpServlet {

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
            out.println("<title>Servlet DeletePerson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeletePerson at " + request.getContextPath() + "</h1>");
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
        PersonDAO pd = new PersonDAO();
        DepartDAO dd = new DepartDAO();
        String id = request.getParameter("id");
        Personnel p = pd.getPersonByID(id);
        Department d = dd.getDepartByID(p.getDepartid());
        List<Personnel> u = pd.getAllFromDepartid(d.getCodedepart());
        int getCodeu = 0;
        String udCodePart = d.getCodedepart();
        for (int i = 0; i < u.size(); i++) {
            if (!u.get(i).getCodepersonnel().equalsIgnoreCase(p.getCodepersonnel())) {
                int check = u.get(i).getCodepersonnel().compareToIgnoreCase(p.getCodepersonnel());
                if (check == 1) {
                    Personnel checkCodeu = pd.getPersonByDepartName(u.get(i).getCodepersonnel());

                    if (checkCodeu != null) {
                        getCodeu = checkDepartCode(checkCodeu.getCodepersonnel());
                    }

                    getCodeu--;
                    udCodePart += getCodeu;

                    Personnel ud = new Personnel(u.get(i).getPsname(), u.get(i).getPhonenum(), u.get(i).getDob(), udCodePart, u.get(i).isStatus(), u.get(i).isSex(), u.get(i).getId(), u.get(i).getRoleid(), u.get(i).getDepartid());
                    pd.update(ud);

                }
            }
        }
        pd.delete(p.getId());
        response.sendRedirect("personnel");
    }

    public int checkDepartCode(String input) {

        int index = -1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                index = i;
                break;
            }
        }
        int numberPart = 0;
        if (index != -1) {
            // Tách chuỗi và số
            String textPart = input.substring(0, index);
            numberPart = Integer.parseInt(input.substring(index));

        }
        return numberPart;

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
        processRequest(request, response);
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
