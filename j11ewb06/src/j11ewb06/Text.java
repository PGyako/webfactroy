package j11ewb06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Text {
	//PreparedStatement和Statement的区别
		public static void main(String[] args) {
			try {
				String name = "李四 " ;
				//1、加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//2、获取数据库连接
				String url="jdbc:mysql://localhost:3306/school";
				Connection conn = DriverManager.getConnection(url, "root", "1234");
				
			/*	//3.创建sql语句对象
				Statement stat = conn.createStatement();
				//4.执行sql语句并且返回结果集
				ResultSet rs = stat
						.executeQuery("select * from student where studentName ='"+name+"'");
				*/
				
				PreparedStatement ppst = conn
						.prepareStatement("select * from student where studentName = ?");
				ppst.setString(1, name);//给占位符赋值
				ResultSet rs = ppst.executeQuery();
				
				//5、从结果集里面拿出数据
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
