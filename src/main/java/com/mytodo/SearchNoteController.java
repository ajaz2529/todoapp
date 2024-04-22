package com.mytodo;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.Note;

import helpers.FactoryHelper;

@WebServlet("/searchNote")
public class SearchNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		Session session = FactoryHelper.GetFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Note where title = :notetitle";
		Query<Note> query = session.createQuery(hql,Note.class);
		query.setParameter("notetitle", search);
		List<Note> resultList = query.getResultList();
		tx.commit();
		session.close();
		request.setAttribute("result", resultList);
		RequestDispatcher rd = request.getRequestDispatcher("SearchResult.jsp");
		rd.forward(request, response);
	}

}
