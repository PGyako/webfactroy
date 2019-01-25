package j11ewb06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDao {
	// ��ȡ���ݿ�����
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
	// ����id��ѯ
		public void selectById(int id) {
			try {
				// Ԥ����sql���
				ppst = getConn().prepareStatement("select * from news_detail where id=?");
				ppst.setInt(1, id);
				// ִ��sql���ؽ��
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



	//���
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
			
			ppst.executeUpdate();//������Ӱ�������
			//ppst.execute();//���ز���ֵ���н��������true��û�з���false��
			
			System.out.println("������ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ʧ��"+e.getMessage());
		}finally{
			close2();
		}
	}
	
	//�޸�
	/*˼·��
	 * 1.�޸ĵ����ֶ�
	 * 2�������µ���ɵĶ���

*/	
	public void UpdateTitle(int id,String title) {
		try {
			String sql="update news_detail set title=? where id=?";
			ppst = getConn().prepareStatement(sql);
			ppst.setString(1, title);
			ppst.setInt(2, id);
			ppst.executeUpdate();
			
			System.out.println("�޸ĳɹ�");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close2();
		}
	}

	//ɾ��
	public void deleteById(int id) {
		try {
			ppst = getConn().prepareStatement("delete from news_detail where id=?");
			ppst.setInt(1, id);
			ppst.executeUpdate();
			
			System.out.println("ɾ���ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close2();
		}
	}
	//�ر�
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
