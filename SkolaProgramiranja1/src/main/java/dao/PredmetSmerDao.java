package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.jsp.jstl.core.Config;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Predmet;
import model.Smer;

public class PredmetSmerDao {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public boolean snimiPredmet(Predmet predmet) {
		Session session = sf.openSession();
		session.beginTransaction();

		try {
			session.save(predmet);
			session.getTransaction().commit();
			System.out.println("Uspesno upisan predmet u bazu..");
			return true;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nije upisan predmet u bazu!");
			return false;
		} finally {
			session.close();
		}
	}

	public boolean snimiSmer(Smer smer) {
		Session session = sf.openSession();
		session.beginTransaction();

		try {
			session.save(smer);
			session.getTransaction().commit();
			System.out.println("Uspesno upisan smer u bazu..");
			return true;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nije upisan smer u bazu!");
			return false;
		} finally {
			session.close();
		}

	}

	public List<Predmet> vratiSvePredmete() {

		List<Predmet> sviPredmeti = new ArrayList<Predmet>();

		Session session = sf.openSession();
		session.beginTransaction();

		try {
			String hql = "from Predmet";
			Query query = session.createQuery(hql);
			sviPredmeti = query.getResultList();

			session.getTransaction().commit();
			System.out.println("Uspesno preuzeti predmeti..");
			return sviPredmeti;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Neuspresno preuzeti predmeti u vratiSvePredmete!");
			return null;
		} finally {
			session.close();
		}
	}

	public List<Smer> vratiSveSmerove() {
		List<Smer> sviSmerovi = new ArrayList<Smer>();

		Session session = sf.openSession();
		session.beginTransaction();

		try {
			String hql = "from Smer";
			Query query = session.createQuery(hql);
			sviSmerovi = query.getResultList();
			for(Smer s: sviSmerovi) {
				Hibernate.initialize(s.getPredmetiNaSmeru());
			}

			session.getTransaction().commit();
			System.out.println("Uspesno preuzeti smerovi..");
			return sviSmerovi;

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Neuspresno preuzeti smerovi u vratiSvePredmete!");
			return null;
		} finally {
			session.close();
		}
	}

	public void poveziPredmetIsmer(String idPredmet, String idSmer) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			Predmet predmet = session.get(Predmet.class, Integer.parseInt(idPredmet));
			Smer smer = session.get(Smer.class, Integer.parseInt(idSmer));
			
			//mappedBy odredjuje koju cemo listu da update-jemo
			//na listi predmeta dodajemo smer
			Hibernate.initialize(predmet.getSmeroviNaKojimaJePredmet());
			predmet.getSmeroviNaKojimaJePredmet().add(smer);
			
			session.update(predmet);
			session.getTransaction().commit();
			System.out.println("Uspesno povezani smerovi i predmeti..");

		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto je puklo u poveziPredmetIsmer!");
		} finally {
			session.close();
		}
		
	}
}
