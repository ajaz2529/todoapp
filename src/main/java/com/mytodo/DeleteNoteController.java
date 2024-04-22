package com.mytodo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;

import helpers.FactoryHelper;

@WebServlet("/deleteNote")
public class DeleteNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteNoteController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Session session = FactoryHelper.GetFactory().openSession();
		Transaction tx = session.beginTransaction();
		Note note = session.get(Note.class, id);
		session.delete(note);
		tx.commit();
		session.close();
		RequestDispatcher rd = request.getRequestDispatcher("DisplayNotes.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
