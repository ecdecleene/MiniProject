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
 * Servlet implementation class EditOrganizerEventsServlet
 */
@WebServlet("/editOrganizerEventsServlet")
public class EditOrganizerEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrganizerEventsServlet() {
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
		EventsHelper eh = new EventsHelper();
		OrganizerHelper oh = new OrganizerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		OrganizerEvents listToUpdate = oeh.searchForOrganizerEventsById(tempId);
		String newListName = request.getParameter("listName");
		String organizerName = request.getParameter("organizerName");
		Organizer newOrganizer = oh.findOrganizer(organizerName);
		try {
			String[] selectedEvents = request.getParameterValues("allEventsToAdd");
			List<Events> selectedEventsInList = new ArrayList<Events>();
			for(int i=0; i<selectedEvents.length; i++) {
				System.out.println(selectedEvents[i]);
				Events e = eh.searchForEventById(Integer.parseInt(selectedEvents[i]));
				selectedEventsInList.add(e);
			}
			listToUpdate.setEventsList(selectedEventsInList);
		} catch(NullPointerException e) {
			List<Events> selectedEventsInList = new ArrayList<Events>();
			listToUpdate.setEventsList(selectedEventsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setOrganizer(newOrganizer);
		oeh.updateList(listToUpdate);
	}

}
