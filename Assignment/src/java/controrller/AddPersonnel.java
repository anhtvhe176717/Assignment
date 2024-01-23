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
import java.util.UUID;
import model.Department;
import model.Personnel;
import model.Role;

/**
 *
 * @author admin
 */
public class AddPersonnel extends HttpServlet {

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
            out.println("<title>Servlet AddPersonnel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPersonnel at " + request.getContextPath() + "</h1>");
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
        DepartDAO dp = new DepartDAO();
        PersonDAO pd = new PersonDAO();
        RoleDAO rd = new RoleDAO();
        List<Personnel> listp = pd.getAll();
        List<Department> listd = dp.getAllDepart();
        List<Role> listr = rd.getAllRole();
        request.setAttribute("listp", listp);
        request.setAttribute("listd", listd);
        request.setAttribute("listr", listr);
        request.getRequestDispatcher("addperson.jsp").forward(request, response);

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
        DepartDAO dd = new DepartDAO();
                RoleDAO rd = new RoleDAO();

        List<Personnel> listp = pd.getAll();
        String name = request.getParameter("name");
        String formatName = capitalizeFirstLetter(name);
        String codedepart = request.getParameter("department");
        String sex = request.getParameter("sex");
        String dob = request.getParameter("birthdate");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
//        for (int i = 0; i < listp.size(); i++) {
//            if (phone.equalsIgnoreCase(listp.get(i).getPhonenum())) {
//                request.setAttribute("err", "Phone Number Is Existed!");
//                List<Department> listd = dd.getAllDepart();
//                List<Role> listr = rd.getAllRole();
//                request.setAttribute("listp", listp);
//                request.setAttribute("listd", listd);
//                request.setAttribute("listr", listr);
//                request.getRequestDispatcher("addperson.jsp").forward(request, response);
//            }
//        }
//        if (phone.length() != 10) {
//            request.setAttribute("err", "Phone Number must == 10 number!");
//            doGet(request, response);
//        }
        boolean status = true;
        boolean gender;
        int getCode = 0;
        gender = Boolean.parseBoolean(sex);

        Department depart = dd.getDepartCodeDepart(codedepart);

        Personnel checkCodePerson = pd.getPersonByDepartName(codedepart);
        if (checkCodePerson != null) {
            getCode = checkDepartCode(checkCodePerson.getCodepersonnel());
        }

        getCode++;
        codedepart += getCode;
        UUID pid = UUID.randomUUID();
        UUID roleid = UUID.fromString(role);
        Personnel newperson = new Personnel(formatName, phone, dob, codedepart, status, gender, pid, roleid, depart.getId());
        pd.insert(newperson);
        response.sendRedirect("personnel");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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

    public String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                result.append(firstChar).append(word.substring(1)).append(" ");
            }
        }

        return result.toString().trim(); // Loại bỏ dấu cách cuối chuỗi (nếu có)
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
