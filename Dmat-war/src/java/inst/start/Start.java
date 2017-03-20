/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inst.start;

import inst.beans.SessionBeanLocal;
import inst.entities.Kurs;
import inst.entities.Posesh;
import inst.entities.SprStudent;
import inst.entities.TableP;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muzaffar
 */
@WebServlet(name = "Start", urlPatterns = {"/start"})
public class Start extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @EJB
    private SessionBeanLocal sbl;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        List<SprStudent> ls = sbl.getSprStudentFindAll();
        request.setAttribute("ls", ls);
        List<Posesh> lp = sbl.getPoseshFindAll();
        request.setAttribute("lp", lp.get(0));
        System.out.println("" + lp.get(0).getIdSt().getFio());
//        lp.forEach((p) -> {
//            System.out.println("" + p.getIdSt().getId() + " , " + p.getIdSt().getFio() + " , "
//                    + p.getIdSt().getIdGr().getName() + " , " + p.getIdSt().getIdTip().getTip() + " , "
//                    + p.getNedelya() + " , {" + p.getPropusk() + " : " + p.getUvProp() + "} , ");
//        });
//        System.out.println("---------------------------------------------");
//        for (int i = 0; i < ls.size(); i++) {
//            System.out.println(ls.get(i).getId() + " , " + ls.get(i).getFio() + " , " + ls.get(i).getIdGr().getName()
//                    + " , " + ls.get(i).getIdTip().getTip());
//        }
        List<TableP> l = sbl.getTableP();
        System.out.println("l--->>> " + l);
//        for (TableP o : l) {
////            System.out.println(o.getFio() + " , " + o.getGrName() + " , " + o.getNedelya() + " , " + o.getPropusk() + " , " + o.getUvProp());
//            System.out.println(o.getFio());
//        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
