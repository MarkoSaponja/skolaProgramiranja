package common;

public class Validacija {

	public boolean proveriUserIPassPrazni(String userName, String password) {
		
		boolean provera = false;
		if(userName==null || userName.isEmpty()) {
			provera = true;
		}
		
		if(password==null || password.isEmpty()) {
			provera = true;
		}
		
		
		return provera;
	}

}
