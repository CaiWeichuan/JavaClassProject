package javaproject_1;
import java.sql.*;

public class LoginAdmin {
	//Admin��½
	public static void main(String[] args) {
		
		//�������ݿ�
		
		try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
        }catch(ClassNotFoundException e1){
            System.out.println("�Ҳ���MySQL����!");
            e1.printStackTrace();
        }
		
		Connection conn;
		String url="jdbc:mysql://localhost:3306/mydb2? useUnicode=true&characterEncoding=utf-8&useSSL=false";    //JDBC��URL 
		try {
            conn = DriverManager.getConnection(url, "root","635241xx");
            
            System.out.println("�ɹ����ӵ����ݿ⣡");
            
            
            Statement stmt = conn.createStatement(); //����Statement����
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
