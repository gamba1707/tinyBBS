package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Article;
import dao.Dao;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/getname")
public class getname extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public getname() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		List<Article> nameList = dao.getArticleList();

		request.setAttribute("nameList" , nameList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/name.jsp");
		dispatcher.forward(request, response);
	}

}
