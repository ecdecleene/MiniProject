package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrganizerEvents;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrganizerEventsHelper oeh = new OrganizerEventsHelper();
		String act = request.getParameter("doThisToList");
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewOrganizerEventsServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				OrganizerEvents listToDelete = oeh.searchForOrganizerEventsById(tempId);
				oeh.deleteList(listToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewOrganizerEventsServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				OrganizerEvents listToEdit = oeh.searchForOrganizerEventsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				EventsHelper ehForEvents = new EventsHelper();
				request.setAttribute("allEvents", ehForEvents.showAllEvents());
				if(ehForEvents.showAllEvents().isEmpty()) {
					request.setAttribute("allEvents", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewOrganizerEventsServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
