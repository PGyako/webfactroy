package j11ewb06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Text {
	//PreparedStatement��Statement������
		public static void main(String[] args) {
			try {
				String name = "���� " ;
				//1����������
				Class.forName("com.mysql.jdbc.Driver");
				//2����ȡ���ݿ�����
				String url="jdbc:mysql://localhost:3306/school";
				Connection conn = DriverManager.getConnection(url, "root", "1234");
				
			/*	//3.����sql������
				Statement stat = conn.createStatement();
				//4.ִ��sql��䲢�ҷ��ؽ����
				ResultSet rs = stat
						.executeQuery("select * from student where studentName ='"+name+"'");
				*/
				
				PreparedStatement ppst = conn
						.prepareStatement("select * from student where studentName = ?");
				ppst.setString(1, name);//��ռλ����ֵ
				ResultSet rs = ppst.executeQuery();
				
				//5���ӽ���������ó�����
				while(rs.next()) {
					System.out.println(rs.getString("StudentName")+"--"+ rs.getString("StudentNo"));
				}
				
				rs.close();
				ppst.close();
				conn.close();			
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
}
