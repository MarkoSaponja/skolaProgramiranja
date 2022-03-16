package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import common.Validacija;
import dao.LoginDao;
import model.User;
import model.UserDetails;
import model.UserType;
import service.LoginService;

@WebServlet(description = "ovo je servlet za login", urlPatterns = { "/LoginControllerPath" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dobrodosli u doPost");

		LoginService service = new LoginService();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("UN: " + userName);
		System.out.println("Password: " + password);

		// 1. proveriti da li su username i pass prazni ili null
		boolean daLiSuUserIpassPrazni = service.proveriUserIPassPrazni(userName, password);

		if (daLiSuUserIpassPrazni) {
			// 1a. Ako je username ili pass null ili prazan
			// vrati odgovor da mora da popuni polja
			response.sendRedirect("stranice/prazan_unos.html");
		} else {

			// 1b. Ako nisu prazni ili null idemo dalje
			// 2. u bazi proveriti da li postoji user sa tim usernameom i pass- om
			User user = service.vratiAkoPostojiUser(userName, password);
			if (user != null) {
				// 2b. Ako postoji prebaciti ga na njegovu stranu
				HttpSession sesija = request.getSession();
				//u kutiju ubacujemo objekat user i na kutiji pisemo user
				sesija.setAttribute("user", user);
				if (user.getUserType() == UserType.ADMINISTRACIJA) {
					response.sendRedirect("view/admin.jsp");
				} else if (user.getUserType() == UserType.PROFESOR) {
					response.sendRedirect("view/profesor.jsp");
				} else if (user.getUserType() == UserType.STUDENT) {
					response.sendRedirect("view/student.jsp");
				} else {
					response.sendRedirect("stranice.loginError.html");
				}
			} else {
				// 2a Ako ne postoji treba da vratimo odgovor da pokusa ponovo
				response.sendRedirect("stranice/login.html");
			}

		}

	}

}
