package javaproject_1;

import java.text.ParseException;

public class theMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginAdmin.Admin_id="Weichuan";
		LoginAdmin.Admin_password="635241xx";
		if (LoginAdmin.checkAdmin() == true) {
			try {
				Admin.createFlight();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
