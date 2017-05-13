package javaproject_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPassenger {
//passenger 登陆验证
	static String pa_id;
	static String pa_password;
	public LoginPassenger (String pa_id, String pa_password) {
		this.pa_id = pa_id;
		this.pa_password = pa_password;
	}
	public static boolean checkPassenger() {
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
           
            Statement stmt = conn.createStatement(); //创建Statement对象
            	String strSQL = "select identityID, password from passenger where identityID=? and password=? ";
            pst = conn.prepareStatement(strSQL);
            pst.setString(1, pa_id);
            pst.setString(2, pa_password);
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
