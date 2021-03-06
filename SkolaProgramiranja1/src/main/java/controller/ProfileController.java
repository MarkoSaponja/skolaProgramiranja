package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDetails;
import service.ProfileService;

@WebServlet(description = "view profile", urlPatterns = { "/ProfileController" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfileService service = new ProfileService();
	
		String idUser = request.getParameter("idUser");
		System.out.println("Id user: " + idUser);
		
		UserDetails details = service.vratiUserDetailsZaUsera(idUser);
		
		request.setAttribute("details", details);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/profile.jsp");
		dispatcher.forward(request, response);
	}

}
