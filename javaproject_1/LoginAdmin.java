package javaproject_1;
import java.sql.*;
import java.util.Scanner;

public class LoginAdmin {
	//Admin登陆验证
	static String Admin_id;
	static String Admin_password;
	public LoginAdmin (String Admin_id, String Admin_password) {
		this.Admin_id = Admin_id;
		this.Admin_password = Admin_password;
	}
	public static boolean checkAdmin() {
		Connection conn = null;
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
           
        }catch(ClassNotFoundException e1){
        	System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
		

		PreparedStatement pst;
		ResultSet rs;
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC的URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");
            System.out.println("成功连接到数据库！");
            Statement stmt = conn.createStatement(); //创建Statement对象
            	String strSQL = "select UserName, password from admin where UserName=? and password=? ";
            pst = conn.prepareStatement(strSQL);
            pst.setString(1, Admin_id);
            pst.setString(2, Admin_password);
            rs = pst.executeQuery();
            if(rs.next()){
            	return true;
            		}
            
            }catch (Exception e) {
				System.out.println("登陆失败");
			}finally {
				try{
					conn.close();
				}catch (Exception e) {
					System.out.println("关闭数据库失败");
				}
				
			}
		return false;
		}

}
