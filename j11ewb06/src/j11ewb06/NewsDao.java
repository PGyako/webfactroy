package j11ewb06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDao {
	// 获取数据库连接
	private Connection conn;
	private PreparedStatement ppst;
	private ResultSet rs;

	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/kgcnews";
			conn = DriverManager.getConnection(url, "root", "1234");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void select() {
		try {
			ppst = getConn().prepareStatement("select * from news_detail");

			rs = ppst.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("title") + "--" + rs.getString("author"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	// 根据id查询
		public void selectById(int id) {
			try {
				// 预编译sql语句
				ppst = getConn().prepareStatement("select * from news_detail where id=?");
				ppst.setInt(1, id);
				// 执行sql返回结果
				rs = ppst.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("title") + "--" + rs.getString("author"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
		}



	//添加
	public void addNews(Detail d) {
		String sql = "insert into news_detail values(?,?,?,?,?,?,?,?,?)";
		try {
			ppst = getConn().prepareStatement(sql);
			ppst.setInt(1, d.getId());
			ppst.setInt(2, d.getCategory().getNcid());
			ppst.setString(3, d.getTitle());
			ppst.setString(4, d.getSummary());
			ppst.setString(5, d.getContent());
			ppst.setString(6, d.getPicPath());
			ppst.setString(7, d.getAuthor());
			ppst.setString(8, d.getCreateDate());
			ppst.setString(9, d.getModifyDate());
			
			ppst.executeUpdate();//返回受影响的行数
			//ppst.execute();//返回布尔值，有结果集返回true，没有返回false；
			
			System.out.println("新闻添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("新闻添加失败"+e.getMessage());
		}finally{
			close2();
		}
	}
	
	//修改
	/*思路：
	 * 1.修改单个字段
	 * 2。传个新的完成的对象

*/	
	public void UpdateTitle(int id,String title) {
		try {
			String sql="update news_detail set title=? where id=?";
			ppst = getConn().prepareStatement(sql);
			ppst.setString(1, title);
			ppst.setInt(2, id);
			ppst.executeUpdate();
			
			System.out.println("修改成功");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close2();
		}
	}

	//删除
	public void deleteById(int id) {
		try {
			ppst = getConn().prepareStatement("delete from news_detail where id=?");
			ppst.setInt(1, id);
			ppst.executeUpdate();
			
			System.out.println("删除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close2();
		}
	}
	//关闭
	public void close() {
		try {
			rs.close();
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void close2() {
		try {
			
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
