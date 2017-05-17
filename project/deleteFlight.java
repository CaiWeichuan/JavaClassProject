package javaproject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class deleteFlight {

		public static void delete() {
			int n = 0;
			Connection conn = null;
			try{
	            //调用Class.forName()方法加载驱动程序
	            Class.forName("com.mysql.jdbc.Driver");
	           
	        }catch(ClassNotFoundException e1){
	          
	            e1.printStackTrace();
	        }
			

			PreparedStatement pst;
			ResultSet rs;
			ResultSet rs2;
			String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
			try {
	            conn = DriverManager.getConnection(url, "root","635241xx");
	            Statement st = conn.createStatement(); //创建Statement对象
	            Statement st2 = conn.createStatement();
	            Scanner input = new Scanner(System.in);
	            System.out.println("Enter the FlightID you want to delete(only in UNPUBLISHED or TERMINATE)");
	            String FlightID = input.nextLine();
	            
	            rs = st.executeQuery("Select flightStatus,ID,startTime,departureDate From flight where FlightID='"+FlightID+"'");
	            while (rs.next()) {
					System.out.printf("ID of this flightID (different date): %s\t",rs.getString(2));
					System.out.printf("Status: %s\t",rs.getString(1));
					System.out.printf("start Time: %tT\t",rs.getTime(3));
					System.out.printf("departure Date: %tF\t",rs.getDate(4));
				}
	            System.out.println();
	            System.out.println("Enter the ID number to delete:");
	            int a = input.nextInt();
	            String str2 = "delete from flight where id="+a+" and (flightStatus='UNPUBLISHED' or flightStatus = 'TERMINATE')";
	            n = st2.executeUpdate(str2);
	            if (n>0) {
					System.out.println("Deleted successfully!");
				}else {
					System.out.println("Delete failed");
				}
	            
	            
	            
	            
	            
	            }catch (Exception e) {
					e.printStackTrace();
				}
		}
}
