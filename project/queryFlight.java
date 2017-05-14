package javaproject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class queryFlight {
	//查询航班
	
	public static void query() {
		
		Connection conn = null;
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
           
        }catch(ClassNotFoundException e1){
          
            e1.printStackTrace();
        }
		

		PreparedStatement pst;
		
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
		try {
			
			
            conn = DriverManager.getConnection(url, "root","635241xx");
            Statement st = conn.createStatement(); //创建Statement对象
            
            Scanner input = new Scanner(System.in);
    		System.out.println("Enter the number: ");
    		System.out.println("1.通过起飞城市、到达城市、起飞日期查询航班"
    				+ "2.通过航班号查询航班 3.通过起飞城市、到达城市查询航班");
    		int chose = input.nextInt();
    		switch (chose) {
    		case 1:
    			
    			ResultSet rs;
    			Scanner aaa = new Scanner(System.in);
    			System.out.println("The start city:");
    			String startC =  aaa.nextLine();
    			System.out.println("The arrival city:");
    			String arrivalC = aaa.nextLine();
    			String deparD =null;
    			System.out.println("Departure date(yyyy-MM-dd):");
    			deparD = aaa.nextLine();
    			java.sql.Date departureD = java.sql.Date.valueOf(deparD);
    			
    			rs = st.executeQuery("Select * From flight where startCity='"+startC+"',"
    					+ "arrrivalCity='"+arrivalC+"',depatureDate='"+departureD+"' ");
    			while (rs.next()) {
					System.out.printf("Flight ID: %s\t",rs.getString(1));
					System.out.printf("start Time: %tT\t",rs.getTime(2));
					System.out.printf("arrival Time: %tT\t",rs.getTime(3));
					System.out.printf("start city: %s\t",rs.getString(4));
					System.out.printf("arrival city: %s\t",rs.getString(5));
					System.out.printf("departure Date: %tF\t",rs.getDate(6));
					System.out.printf("price: %d\t",rs.getInt(7));
					System.out.printf("current passengers: %d\t", rs.getInt(8));
					System.out.printf("seat capacity: %d\t", rs.getInt(9));
					System.out.printf("flight status: %s\t", rs.getString(10));
					System.out.printf("passengers ID: %s\t", rs.getString(11));
				}
    			break;
    		
    		case 2:
    			
    			ResultSet rs2=null;
    			Scanner bbb = new Scanner(System.in);
    			System.out.println("The flight ID:");
    			String fID =  bbb.nextLine();
    			rs2 = st.executeQuery("Select * From flight where FlightID='"+fID+"'");
    			
    			while (rs2.next()) {
					System.out.printf("Flight ID: %s\t",rs2.getString(1));
					System.out.printf("start Time: %tT\t",rs2.getTime(2));
					System.out.printf("arrival Time: %tT\t",rs2.getTime(3));
					System.out.printf("start city: %s\t",rs2.getString(4));
					System.out.printf("arrival city: %s\t",rs2.getString(5));
					System.out.printf("departure Date: %tF\t",rs2.getDate(6));
					System.out.printf("price: %d\t",rs2.getInt(7));
					System.out.printf("current passengers: %d\t", rs2.getInt(8));
					System.out.printf("seat capacity: %d\t", rs2.getInt(9));
					System.out.printf("flight status: %s\t", rs2.getString(10));
					System.out.printf("passengers ID: %s\t", rs2.getString(11));
				}
    			
    			break;
    			
    		case 3:
    			ResultSet rs3;
    			Scanner ccc = new Scanner(System.in);
    			System.out.println("The start city:");
    			String startC2 =  ccc.nextLine();
    			System.out.println("The arrival city:");
    			String arrivalC2 = ccc.nextLine();
    			
    			
    			rs3 = st.executeQuery("Select * From flight where startCity='"+startC2+"',"
    					+ "arrrivalCity='"+arrivalC2+"' ");
    			while (rs3.next()) {
					System.out.printf("Flight ID: %s\t",rs3.getString(1));
					System.out.printf("start Time: %tT\t",rs3.getTime(2));
					System.out.printf("arrival Time: %tT\t",rs3.getTime(3));
					System.out.printf("start city: %s\t",rs3.getString(4));
					System.out.printf("arrival city: %s\t",rs3.getString(5));
					System.out.printf("departure Date: %tF\t",rs3.getDate(6));
					System.out.printf("price: %d\t",rs3.getInt(7));
					System.out.printf("current passengers: %d\t", rs3.getInt(8));
					System.out.printf("seat capacity: %d\t", rs3.getInt(9));
					System.out.printf("flight status: %s\t", rs3.getString(10));
					System.out.printf("passengers ID: %s\t", rs3.getString(11));
				}
    			break;
    		default:
    			break;
    		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
