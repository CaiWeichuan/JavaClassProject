package javaproject_1;

import java.text.ParseException;
import java.util.Scanner;

public class theMain {

	public static void main(String[] args) {
		//������
		
		
		LoginAdmin.Admin_id=null;
		LoginAdmin.Admin_password=null;
		
		LoginPassenger.pa_id=null;
		LoginPassenger.pa_password=null;
		
		
		
		//��ҳ��ѡ��
		System.out.println("Enter the number");
		System.out.println("1.login for Admin, 2.Query Flight Information, 3.login for passenger"
				+ " 4.register an account");
		Scanner input = new Scanner(System.in);
		int First_num = input.nextInt();
		
		
		switch (First_num) {
		case 1:
			
			//����Աѡ��
			
			System.out.println("Admin ID:");
			LoginAdmin.Admin_id = input.nextLine();
			System.out.println("password:");
			LoginAdmin.Admin_password = input.nextLine();
			
			if (LoginAdmin.checkAdmin() ==true) {
				try {
					//Ŀǰֻ����˴������๦��
					
					Admin.createFlight();
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			}
			
			
			break;

		case 2:
			
			//���˺���ͨ��ѯѡ��
			
			break;
		
		case 3:
			
			//��ͨ�˻�ѡ��
			
			System.out.println("identity ID: ");
			LoginPassenger.pa_id = input.nextLine();
			System.out.println("password: ");
			LoginPassenger.pa_password = input.nextLine();
			if (LoginPassenger.checkPassenger()==true) {
				try {
					
					//����
					
					Admin.createFlight();//���д�����ʱ������������
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			}
			
			break;
			
		case 4:
			
			//ע����ͨ�˺�
			
		}
		
		
		

	}

}
