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
import java.util.UUID;
import model.Department;
import model.Personnel;
import model.Role;

/**
 *
 * @author admin
 */
public class UpdatePerson extends HttpServlet {

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
            out.println("<title>Servlet UpdatePerson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdatePerson at " + request.getContextPath() + "</h1>");
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
        String otherid = (String) request.getAttribute("id");
        String id = request.getParameter("id");
        DepartDAO dp = new DepartDAO();
        PersonDAO pd = new PersonDAO();
        RoleDAO rd = new RoleDAO();
        List<Personnel> listp = pd.getAll();
        List<Department> listd = dp.getAllDepart();
        List<Role> listr = rd.getAllRole();
        if (otherid != null) {
            Personnel person = pd.getPersonByID(otherid);
            Personnel checkperson = person;
            request.setAttribute("listp", listp);
            request.setAttribute("listd", listd);
            request.setAttribute("listr", listr);
            request.setAttribute("personnel", person);
            request.setAttribute("checkperson", checkperson);
            request.getRequestDispatcher("updateperson.jsp").forward(request, response);
        } else {
            Personnel person = pd.getPersonByID(id);
            Personnel checkperson = person;
            request.setAttribute("listp", listp);
            request.setAttribute("listd", listd);
            request.setAttribute("listr", listr);
            request.setAttribute("personnel", person);
            request.setAttribute("checkperson", checkperson);
            request.getRequestDispatcher("updateperson.jsp").forward(request, response);

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
        PersonDAO pd = new PersonDAO();
        DepartDAO dd = new DepartDAO();
        List<Personnel> listp = pd.getAll();
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String formatName = capitalizeFirstLetter(name);
        String codedepart = request.getParameter("department");
        String sex = request.getParameter("sex");
        String sta = request.getParameter("status");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");

        // check departcode and phone number
        String checkcdp = request.getParameter("checkdepart");
        String checkpn = request.getParameter("checkphone");

//        if (!phone.equalsIgnoreCase(checkpn)) {
//            for (int i = 0; i < listp.size(); i++) {
//                if (phone.equalsIgnoreCase(listp.get(i).getPhonenum())) {
//                    request.setAttribute("id", code);
//                    request.setAttribute("err", "Phone Number Is Existed!");
//                    doGet(request, response);
//
//                }
//            }
//        }
//        if (phone.length() != 10) {
//
//            request.setAttribute("err", "Phone Number must == 10 number!");
//            request.setAttribute("id", code);
//            doGet(request, response);
//
//        }
        boolean gender;
        boolean status;
        gender = Boolean.parseBoolean(sex);
        status = Boolean.parseBoolean(sta);
        Department depart = dd.getDepartCodeDepart(codedepart);

        UUID checkcdpp = UUID.fromString(checkcdp);
        Department departcheck = dd.getDepartByID(checkcdpp);

        if (!depart.getId().equals(checkcdpp)) {
            // fix old person from old depart
            List<Personnel> u = pd.getAllFromDepartid(departcheck.getCodedepart());

            int getCodeu = 0;
            String udCodePart = departcheck.getCodedepart();
            int getCode = 0;
            Personnel checkCode = pd.getPersonByDepartName(codedepart);
            if (checkCode != null) {
                getCode = checkDepartCode(checkCode.getCodepersonnel());
            }

            getCode++;
            codedepart += getCode;
            Personnel checkCodePerson = pd.getPersonByDepartName(code);
            UUID roleid = UUID.fromString(role);
            Personnel p = new Personnel(formatName, phone, dob, codedepart, status, gender, checkCodePerson.getId(), roleid, depart.getId());
            pd.update(p);
            for (int i = 0; i < u.size(); i++) {
                if (!u.get(i).getCodepersonnel().equalsIgnoreCase(code)) {
                    int check = u.get(i).getCodepersonnel().compareToIgnoreCase(code);
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

            // change this person to new depart
            response.sendRedirect("personnel");

        } else {
            Personnel checkCodePerson = pd.getPersonByDepartName(code);
            UUID roleid = UUID.fromString(role);

            Personnel p = new Personnel(formatName, phone, dob, code, status, gender, checkCodePerson.getId(), roleid, depart.getId());

            pd.update(p);
            response.sendRedirect("personnel");
        }
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
