package service;

import java.util.List;

import model.Profesor;
import dao.PrikaziProfesoreDao;
import model.Predmet;
import wrapper.ProfesorWrapper;

public class PrikaziProfesoreService {
	
	PrikaziProfesoreDao dao = new PrikaziProfesoreDao();

	public List<ProfesorWrapper> vratiSveProfesore() {
		return dao.vratiSveProfesore();
	}

	public List<Predmet> vratiSvePredmete() {
		return dao.vratiSvePredmete();
	}

	public Profesor vratiProfesoraPoId(String idProfesor) {
		return dao.vratiProfesoraPoId(idProfesor);
	}

	public void dodajPredmetProfesoru(String idProfesor, String idPredmet) {
		
		dao.dodajPredmetProfesoru(idProfesor,idPredmet);
	}

	public void obrisiPredmetProfesora(String idProfesor, String idPredmet) {

		dao.obrisiPredmetProfesora(idProfesor, idPredmet);
		
	}
}
