package javaproject_1;
import java.sql.*;
import java.util.Scanner;

public class LoginAdmin {
	//Admin��½��֤
	static String Admin_id;
	static String Admin_password;
	public LoginAdmin (String Admin_id, String Admin_password) {
		this.Admin_id = Admin_id;
		this.Admin_password = Admin_password;
	}
	public static boolean checkAdmin() {
		Connection conn = null;
		try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
           
        }catch(ClassNotFoundException e1){
        	System.out.println("�Ҳ���MySQL����!");
            e1.printStackTrace();
        }
		

		PreparedStatement pst;
		ResultSet rs;
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC��URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");
            System.out.println("�ɹ����ӵ����ݿ⣡");
            Statement stmt = conn.createStatement(); //����Statement����
            	String strSQL = "select UserName, password from admin where UserName=? and password=? ";
            pst = conn.prepareStatement(strSQL);
            pst.setString(1, Admin_id);
            pst.setString(2, Admin_password);
            rs = pst.executeQuery();
            if(rs.next()){
            	return true;
            		}
            
            }catch (Exception e) {
				System.out.println("��½ʧ��");
			}finally {
				try{
					conn.close();
				}catch (Exception e) {
					System.out.println("�ر����ݿ�ʧ��");
				}
				
			}
		return false;
		}

}
