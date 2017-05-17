package javaproject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdataMain {
	//每次打开主界面时对数据库进行更新
	
	public static void updata() throws ParseException {
		
		//获取当前时间
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		 SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		 Date sysTime1 = format.parse(format.format(new Date()));//获取系统当前时间 HH:mm:ss
         Date sysTime2 = format2.parse(format2.format(new Date()));//获取系统当前时间 yyyy-MM-dd
         long sys1=sysTime1.getTime();
         long sys2=sysTime2.getTime();
		
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
			
			ResultSet rs;
			ResultSet rs2;
            conn = DriverManager.getConnection(url, "root","635241xx");
            Statement st = conn.createStatement(); //创建Statement对象
            
            rs = st.executeQuery("Select startTime,departureDate,flightStatus,FlightID From flight");
            while (rs.next()) {
            	
				if (rs.getDate(2).getTime()<sys2) {
					
					String sql ="Update flight set flightStatus='TERMINATE' where FlightID='"+rs.getString(4)+"'";
					PreparedStatement ptmt = conn.prepareStatement(sql);
					ptmt.execute();
					
				}else if (rs.getDate(2).getTime()==sys2&rs.getTime(1).getTime()<sys1) {
					
					String sql ="Update flight set flightStatus='TERMINATE' where FlightID='"+rs.getString(4)+"'";
					PreparedStatement ptmt = conn.prepareStatement(sql);
					ptmt.execute();
					
				
				}
           
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
            
		
            
            
		    
            
	}
}
