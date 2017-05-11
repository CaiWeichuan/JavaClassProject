package javaproject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Admin {
//管理员功能
	public void createFlight() throws ParseException {
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
            ResultSet rs = st.executeQuery("select*from flight");
            
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the FlightID, start time (HH:mm:ss) (at least two hours later), arrival time(HH-mm-ss), "
            		+ "start city, arrival city, departure date(yyyy-MM-dd), price"
            		+ "the number of current passengers, seat capacity");
            String FlightID = input.nextLine();
            String startTime0 = input.nextLine();
            String arrivalTime0 = input.nextLine();
            String startCity = input.nextLine();
            String arrivalCity = input.nextLine();
            String departureDate0 = input.nextLine();
            int price = input.nextInt();
            int currentPassengers = input.nextInt();
            int seatCapcity = input.nextInt();
            
            //时间格式转换
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date starTime = format.parse(startTime0);
            Date arrivalTime = format.parse(arrivalTime0);
            
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date departureDate = format2.parse(departureDate0);
            
            Date sysTime1 = format.parse(format.format(new Date()));
            Date sysTime2 = format2.parse(format2.format(new Date()));
            
            //未完待续。。。
            if (starTime>sysTime1 & departureDate>=sysTime2) {
				String strSQL = "Insert Into flight Values()";
			}


            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
	}
}
