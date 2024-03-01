package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import model.Events;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/addEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		LocalDate date;
		try {
			date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException e){
			date = LocalDate.now();
		}
		if (name.isEmpty() || name == null || date == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Events e = new Events(name, date);
			EventsHelper eh = new EventsHelper();
			eh.insertEvent(e);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
