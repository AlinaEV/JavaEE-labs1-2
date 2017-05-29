package controller;

import dao.LanguageDAO;
import dao.LanguageDAO;
import entity.Language;
import entity.Language;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LanguageService;

/**
 *
 * @author Алина
 */
public class LanguageController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/language.jsp";
    private static String LIST_LANGUAGE = "/listLanguage.jsp";
    private LanguageDAO dao;
    
    public LanguageController(){
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int languageId = Integer.parseInt(request.getParameter("id"));
            Language language;
            dao = new LanguageService();
            language = dao.getById(languageId);
            dao = new LanguageService();
            dao.remove(language);
            
            forward = LIST_LANGUAGE;
            dao = new LanguageService();
            request.setAttribute("languages", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int languageId = Integer.parseInt(request.getParameter("id"));
            Language language;
            dao = new LanguageService();
            language = dao.getById(languageId);
            request.setAttribute("language", language);
            
        } else if (action.equalsIgnoreCase("listLanguage")){
            forward = LIST_LANGUAGE;
            dao = new LanguageService();
            request.setAttribute("languages", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Language language = new Language();
        language.setName(request.getParameter("name"));
        String languageid = request.getParameter("id");
        if(languageid == null || languageid.isEmpty())
        {
            dao = new LanguageService();
            dao.add(language);
        }
        else
        {
            language.setId(Integer.parseInt(languageid));
            dao = new LanguageService();
            dao.update(language);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_LANGUAGE);
        dao = new LanguageService();
        request.setAttribute("languages", dao.getAll());
        view.forward(request, response);
    }
}
