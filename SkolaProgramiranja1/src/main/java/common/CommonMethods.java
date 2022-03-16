package common;

import model.Address;
import model.Administrator;
import model.Contact;
import model.Predmet;
import model.Profesor;
import model.Smer;
import model.Student;
import model.User;
import model.UserType;

public class CommonMethods {

	public User popuniUsera(String userName, String password, UserType userType) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserType(userType);
		return user;
	}

	public Student popuniStudent(String firstName, String lastName, String email, String mobilePhone,
			String country, String city, String street, User user, String indexNo ) {
		
		Student student = new Student();
		Address adresa = new Address();
		Contact contact = new Contact();
		
		adresa.setCountry(country);
		adresa.setCity(city);
		adresa.setStreet(street);
		
		contact.setEmail(email);
		contact.setMobilePhone(mobilePhone);
		
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setUser(user);
		student.setContact(contact);
		student.setAddress(adresa);
		student.setIndexNo(indexNo);
		return student;
	}

	public Profesor popuniProfesor(String firstName, String lastName, String email, String mobilePhone, String country,
			String city, String street, User user, String identificationNo) {
		
		
		Profesor profesor = new Profesor();
		Address adresa = new Address();
		Contact contact = new Contact();
		
		adresa.setCountry(country);
		adresa.setCity(city);
		adresa.setStreet(street);
		
		contact.setEmail(email);
		contact.setMobilePhone(mobilePhone);
		
		profesor.setFirstName(firstName);
		profesor.setLastName(lastName);
		profesor.setUser(user);
		profesor.setContact(contact);
		profesor.setAddress(adresa);
		profesor.setIdentificationNo(identificationNo);
		return profesor;
	}

	public Administrator popuniAdministrator(String firstName, String lastName, String email, String mobilePhone,
			String country, String city, String street, User user, String identificationNumber) {
		
		Administrator admin = new Administrator();
		Address adresa = new Address();
		Contact contact = new Contact();
		
		adresa.setCountry(country);
		adresa.setCity(city);
		adresa.setStreet(street);
		
		contact.setEmail(email);
		contact.setMobilePhone(mobilePhone);
		
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setAddress(adresa);
		admin.setContact(contact);
		admin.setIdentificationNumber(identificationNumber);
		admin.setUser(user);
		
		return admin;
	}

	public Predmet popuniPredmet(String nazivPredmeta, String sifraPredmeta) {
		
		Predmet predmet = new Predmet();
		predmet.setNazivPredmeta(nazivPredmeta);
		predmet.setSifraPredmeta(sifraPredmeta);
		return predmet;
	}

	public Smer popuniSmer(String nazivSmera, String sifraSmera) {
		Smer smer = new Smer();
		smer.setNazivSmera(nazivSmera);
		smer.setSifraSmera(sifraSmera);
		return smer;
	}

}
