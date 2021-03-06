package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Predmet;
import model.Profesor;
import service.PrikaziProfesoreService;

@WebServlet(description = "predmeti i profesori", urlPatterns = { "/PredmetiProfesoriController" })
public class PredmetiProfesoriController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrikaziProfesoreService service = new PrikaziProfesoreService();
		
		String idProfesor = request.getParameter("idProfesor");
		System.out.println("id profesora je " + idProfesor);
		
		Profesor profesor = service.vratiProfesoraPoId(idProfesor);
		List<Predmet> sviPredmeti = service.vratiSvePredmete();
		
		request.setAttribute("profesor", profesor);
		request.setAttribute("sviPredmeti", sviPredmeti);
		
		System.out.println("Svi predmeti, broj redova: " + sviPredmeti.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/predmetiProfesori.jsp");
		dispatcher.forward(request, response);
		
	}

}
