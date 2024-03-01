package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Events;
import model.Organizer;
import model.OrganizerEvents;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventsHelper eh = new EventsHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String organizerName = request.getParameter("organizerName");
		String[] selectedEvents = request.getParameterValues("allEventsToAdd");
		List<Events> selectedEventsInList = new ArrayList<Events>();
		if(selectedEvents != null && selectedEvents.length > 0) {
			for(int i=0; i<selectedEvents.length; i++) {
				System.out.println(selectedEvents[i]);
				Events e = eh.searchForEventById(Integer.parseInt(selectedEvents[i]));
				selectedEventsInList.add(e);
			}
		}
		Organizer organizer = new Organizer(organizerName);
		OrganizerEvents oe = new OrganizerEvents(listName, organizer);
		oe.setEventsList(selectedEventsInList);
		OrganizerEventsHelper oeh = new OrganizerEventsHelper();
		oeh.insertNewOrganizerEvents(oe);
		System.out.println("done");
		getServletContext().getRequestDispatcher("/viewOrganizerEventsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
