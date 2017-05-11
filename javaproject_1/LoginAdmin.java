package javaproject_1;
import java.sql.*;

public class LoginAdmin {
	//Admin登陆
	public static void main(String[] args) {
		
		//连接数据库
		
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
		
		Connection conn;
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");
            
            System.out.println("成功连接到数据库！");
            
            
            Statement stmt = conn.createStatement(); //创建Statement对象
            ResultSet rs = stmt.executeQuery("select*from flight");
            while (rs.next()) {
            	for (int i = 1; i <11 ; i++) {
                	System.out.printf(rs.getString(i));
				}
            	System.out.println();
			}
            



            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
	}

	
		

}
