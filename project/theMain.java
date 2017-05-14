package javaproject_1;

import java.text.ParseException;
import java.util.Scanner;

public class theMain {

	public static void main(String[] args) {
		//主界面
		
		
		LoginAdmin.Admin_id=null;
		LoginAdmin.Admin_password=null;
		
		LoginPassenger.pa_id=null;
		LoginPassenger.pa_password=null;
		
		
		
		//首页的选择
		System.out.println("Enter the number");
		System.out.println("1.login for Admin, 2.Query Flight Information, 3.login for passenger"
				+ " 4.register an account");
		Scanner input = new Scanner(System.in);
		int First_num = input.nextInt();
		
		
		switch (First_num) {
		case 1:
			
			//管理员选项
			
			System.out.println("Admin ID:");
			LoginAdmin.Admin_id = input.nextLine();
			System.out.println("password:");
			LoginAdmin.Admin_password = input.nextLine();
			
			if (LoginAdmin.checkAdmin() ==true) {
				try {
					//目前只添加了创建航班功能
					
					Admin.createFlight();
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			}
			
			
			break;

		case 2:
			
			//无账号普通查询选项
			queryFlight.query();
			break;
		
		case 3:
			
			//普通账户选项
			
			System.out.println("identity ID: ");
			LoginPassenger.pa_id = input.nextLine();
			System.out.println("password: ");
			LoginPassenger.pa_password = input.nextLine();
			if (LoginPassenger.checkPassenger()==true) {
				try {
					
					//待建
					
					Admin.createFlight();//此行代码暂时用来凑数。。
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			}
			
			break;
			
		case 4:
			
			//注册普通账号
			
		}
		
		
		

	}

}
