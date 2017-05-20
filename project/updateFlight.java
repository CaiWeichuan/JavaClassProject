package javaproject_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class updateFlight {

	public static void updateflight() {
		String flightid;
    	Time starttime;
    	Time arrivaltime;
    	String startcity;
    	String arrivalcity;
    	Date dep;
    	int price;
    	int passengers;
    	int seat;
    	int currentPassengers;
    	String status;
		ResultSet rs;
		int n =0;
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
          
        }catch(ClassNotFoundException e1){
        
            e1.printStackTrace();
        }
		
		Connection conn;
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");           
            Statement st = conn.createStatement(); //创建Statement对象
            
            System.out.println("如果航班在发布前，可以任意修改；如果航班已发布，起飞城市、到达城市、起飞时间、起飞日期等重要信息不可修改，当前价格、容量可修改");
            
            System.out.println("Enter the flightID you want to update");
            Scanner input1 = new Scanner(System.in);
            String flight_id = input1.nextLine();
            rs = st.executeQuery("Select * From flight where FlightID='"+flight_id+"'");
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
			
				System.out.println();
          
      	  
          if (rs.getString(10).equals("UNPUBLISHED")) {
        	  System.out.println("当前航班在未发布，可以任意修改");
        	  
        	  Scanner input = new Scanner(System.in);
              System.out.println("Enter the FlightID (Enter '-1' :no change)");
              flightid = input.nextLine();
              System.out.println(" start time (HH:mm:ss) (at least two hours later) (Enter '-1' :no change)");
              String starttime2 = input.nextLine();
              System.out.println(" arrival time(HH-mm-ss) (Enter '-1' :no change)");
              String arrivaltime2 = input.nextLine();
              System.out.println("start city (Enter '-1' :no change)");
              startcity = input.nextLine();
              System.out.println("arrival city (Enter '-1' :no change)");
              arrivalcity = input.nextLine();
              System.out.println( " departure date(yyyy-MM-dd) (Enter '-1' :no change)");
              String dep2 = input.nextLine();
              System.out.println(" price (Enter '-1' :no change)");
              price = input.nextInt();
              System.out.println("the number of current passengers (Enter '-1' :no change)");
              currentPassengers = input.nextInt();
              System.out.println("seat capacity (Enter '-1' :no change)");
              seat = input.nextInt();
              System.out.println( "flight status: (Enter '-1' :no change)");
              status = input.next();
              
              
              SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
              
              
              
              SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
              
        	  
        	  
        	  if (!starttime2.equals("-1")) {
        		
                  java.util.Date starTime = format.parse(starttime2);
        		  String sql ="Update flight set startTime='"+starTime+"' where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (!arrivaltime2.equals("-1")) {
        		  java.util.Date arrivalTime = format.parse(arrivaltime2);
        		  String sql ="Update flight set arrivalTime='"+arrivalTime+"' where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (!startcity.equals("-1")) {
        		  String sql ="Update flight set startCity='"+startcity+"' where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (!arrivalcity.equals("-1")) {
        		  String sql ="Update flight set arrivalCity='"+arrivalcity+"' where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (!dep2.equals("-1")) {
        		  java.util.Date departureDate = format2.parse(dep2);
        		  String sql ="Update flight set departureDate ='"+dep2+"' where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (price != -1) {
        		  String sql ="Update flight set price= "+price+" where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (currentPassengers != -1) {
        		  String sql ="Update flight set currentPassengers= "+currentPassengers+" where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
        	  if (seat != -1) {
          		  String sql ="Update flight set seatCapacity= "+seat+" where FlightID='"+flight_id+"'";
          		  PreparedStatement ptmt = conn.prepareStatement(sql);
          		  ptmt.execute();
    			}
        	  if (!status.equals("-1")) {
          		  String sql ="Update flight set flightStatus ='"+status+"' where FlightID='"+flight_id+"'";
          		  PreparedStatement ptmt = conn.prepareStatement(sql);
          		  ptmt.execute();
    			}
        	  if (!flightid.equals("-1")) {
        		  String sql ="Update flight set Flightid='"+flightid+"' where FlightID='"+flight_id+"'";
        		  PreparedStatement ptmt = conn.prepareStatement(sql);
        		  ptmt.execute();
			}
			
		}  
          else if (rs.getString(10).equals("AVAILABLE") | rs.getString(10).equals("FULL")) {
        	  System.out.println("该航班已发布，起飞城市、到达城市、起飞时间、起飞日期等重要信息不可修改，当前价格、容量等可修改");
        	  
        	  Scanner input = new Scanner(System.in);
        	  System.out.println(" price (Enter '-1' :no change)");
              price = input.nextInt();
              System.out.println("the number of current passengers (Enter '-1' :no change)");
              currentPassengers = input.nextInt();
              System.out.println("seat capacity (Enter '-1' :no change)");
              seat = input.nextInt();
              System.out.println( "flight status: (Enter '-1' :no change)");
              status = input.next();
              
              if (price != -1) {
          		  String sql ="Update flight set price= "+price+" where FlightID='"+flight_id+"'";
          		  PreparedStatement ptmt = conn.prepareStatement(sql);
          		  ptmt.execute();
    			}
            	  if (currentPassengers != -1) {
          		  String sql ="Update flight set currentPassengers= "+currentPassengers+" where FlightID='"+flight_id+"'";
          		  PreparedStatement ptmt = conn.prepareStatement(sql);
          		  ptmt.execute();
    			}
            	  if (seat != -1) {
              		  String sql ="Update flight set seatCapacity= "+seat+" where FlightID='"+flight_id+"'";
              		  PreparedStatement ptmt = conn.prepareStatement(sql);
              		  ptmt.execute();
        			}
            	  if (!status.equals("-1")) {
              		  String sql ="Update flight set flightStatus ='"+status+"' where FlightID='"+flight_id+"'";
              		  PreparedStatement ptmt = conn.prepareStatement(sql);
              		  ptmt.execute();
        			}
              
		}
          System.out.println("修改航班成功");
            }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
