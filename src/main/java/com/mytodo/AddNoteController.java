package com.mytodo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/addNote")
public class AddNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddNoteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String descrip = request.getParameter("description");
		DTOtodoImpl obj = new DTOtodoImpl();
		obj.addNote(title,descrip);
		request.setAttribute("mess", "Note Added Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("addNotes.jsp");
		rd.forward(request, response);
	}

}
