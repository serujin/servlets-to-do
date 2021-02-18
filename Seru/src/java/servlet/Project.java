package servlet;

import constants.Constants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.ProjectManager;
import manager.TaskManager;

/**
 *
 * @author Seruji
 */
@WebServlet(name = "Project", urlPatterns = {"/Project"})
public class Project extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectManager.getInstance().loadProject(Integer.parseInt(req.getParameter(Constants.FORM_PROJECT_ID)));
        resp.sendRedirect("project.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskName = req.getParameter(Constants.FORM_TASK_NAME);
        String taskDesc = req.getParameter(Constants.FORM_TASK_DESC);
        TaskManager.getInstance().createTask(taskName, taskDesc);
        resp.sendRedirect("project.jsp");
    }
    
}