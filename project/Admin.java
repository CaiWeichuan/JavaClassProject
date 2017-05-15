package javaproject_1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.mysql.fabric.xmlrpc.base.Data;

public class Admin {

//管理员功能
	
	public static void createAdmin() {
	//创建新的管理员账号	
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
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");
            Statement st = conn.createStatement(); //创建Statement对象
            
            Scanner input = new Scanner(System.in);
            System.out.println("user name:");
            String realName = input.nextLine();
            
            System.out.println("password:");
            String password = input.nextLine();
            
            String strSQL2 = "Insert Into admin (UserName,password)"
            		+ " Values('"+realName+"','"+password+"')";
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
	
	
	public static void createFlight() throws ParseException {
		//创建航班
		
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
          
            
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the FlightID");
            String FlightID = input.nextLine();
            System.out.println(" start time (HH:mm:ss) (at least two hours later)");
            String startTime0 = input.nextLine();
            System.out.println(" arrival time(HH-mm-ss)");
            String arrivalTime0 = input.nextLine();
            System.out.println("start city");
            String startCity = input.nextLine();
            System.out.println("arrival city");
            String arrivalCity = input.nextLine();
            System.out.println( " departure date(yyyy-MM-dd)");
            String departureDate0 = input.nextLine();
            System.out.println(" price");
            int price = input.nextInt();
            System.out.println("the number of current passengers");
            int currentPassengers = input.nextInt();
            System.out.println("seat capacity");
            int seatCapcity = input.nextInt();
            
            //时间格式转换
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date starTime = format.parse(startTime0);
            Date arrivalTime = format.parse(arrivalTime0);
            
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date departureDate = format2.parse(departureDate0);
            
            Date sysTime1 = format.parse(format.format(new Date()));//获取系统当前时间 HH:mm:ss
            Date sysTime2 = format2.parse(format2.format(new Date()));//获取系统当前时间 yyyy-MM-dd
            
            //
			Time starTimeF = Time.valueOf(startTime0);
			Time arrivalTimeF = Time.valueOf(arrivalTime0);
			java.sql.Date departureDateF = java.sql.Date.valueOf(departureDate0);
            
            
            
            //时间验证
            
            long s1=starTime.getTime();
            long a1=arrivalTime.getTime();
            long d1=departureDate.getTime();
            long sys1=sysTime1.getTime();
            long sys2=sysTime2.getTime();
            
            //若设置时间正确，则添加该航班
            if ((s1-sys1)/1000/60/60>=2 & a1>s1 & d1>=sys2) {
				String strSQL = "Insert Into flight (FlightID,startTime,arrivalTime,startCity,arrivalCity,departureDate,price,currentPassengers,seatCapacity) "
						+ "Values('"+FlightID+"','"+starTimeF+"','"+arrivalTimeF+"','"+startCity+"','"+arrivalCity+"','"+departureDateF+"',"+price+","+currentPassengers+","+seatCapcity+")";
	           
				n = st.executeUpdate(strSQL);
				if (n>0) {
					System.out.println("成功创建航班！");
				}else {
					System.out.println("添加航班失败！");
				}
            }


            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
	}
}
