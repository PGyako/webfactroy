package j11ewb06;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextDao {
	public static void main(String[] args) {
		NewsDao n  = new NewsDao();
//		System.out.println(n.getConn());
//		n.select();
//		Detail d = new Detail();
//		d.setId(3);
//		d.setCategory(new NewsCategory(1,"",""));
//		d.setTitle("重庆新闻");
//		d.setSummary("这是新闻概要");
//		d.setContent("wosdjshfshfggfdhhsshdfshfhgsg");
//		d.setPicPath("F://img");
//		d.setAuthor("PG");
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
//		d.setCreateDate(df.format(new Date()));
//		d.setModifyDate(df.format(new Date()));
//		n.addNews(d);
		
		n.UpdateTitle(3, "只能");
	}
}
