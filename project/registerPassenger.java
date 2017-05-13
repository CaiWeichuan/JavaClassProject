package javaproject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class registerPassenger {
//注册普通乘客账号
	static int n =0;
	
	public static void AddPassenger() {
		Connection conn = null;
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
           
        }catch(ClassNotFoundException e1){
          
            e1.printStackTrace();
        }
		

		PreparedStatement pst;
		ResultSet rs;
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");
            Statement st = conn.createStatement(); //创建Statement对象
            
            Scanner input = new Scanner(System.in);
            System.out.println("your real name:");
            String realName = input.nextLine();
            System.out.println("identity ID:");
            String identityID = input.nextLine();
            System.out.println("password:");
            String password = input.nextLine();
            
            String strSQL2 = "Insert Into passenger (realName,identityID,password)"
            		+ " Values('"+realName+"',"+identityID+",'"+password+"')";
            n = st.executeUpdate(strSQL2);
            if (n>0) {
				System.out.println("成功创建账号！");
			}else {
				System.out.println("创建账号失败！");
			}
            conn.close();
		}catch (SQLException e){
            e.printStackTrace();
        }
	}
	
	
}
