package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Note;
import dao.NoteDAO;


@WebServlet("/")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoteDAO noteDAO;
	
	
    public void init() {
        noteDAO = new NoteDAO();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertNote(request, response);
				break;
			case "/delete":
				deleteNote(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateNote(request, response);
				break;
			default:
				listNote(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listNote(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Note> listNote = noteDAO.selectAllNotes();
		request.setAttribute("listNote", listNote);
		RequestDispatcher dispatcher = request.getRequestDispatcher("note-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("note-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Note existingNote = noteDAO.selectNote(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("note-form.jsp");
		request.setAttribute("note", existingNote);
		dispatcher.forward(request, response);

	}

	private void insertNote(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String despt = request.getParameter("despt");
		Note newNote = new Note(title, despt);
		noteDAO.insertNote(newNote);
		response.sendRedirect("list");
	}

	private void updateNote(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String despt = request.getParameter("despt");

		Note book = new Note(id, title, despt);
		noteDAO.updateNote(book);
		response.sendRedirect("list");
	}

	private void deleteNote(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		noteDAO.deleteNote(id);
		response.sendRedirect("list");

	}
}
