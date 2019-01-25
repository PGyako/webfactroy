package j11ewb06;

public class NewsCategory {
	private int ncid;
	private String ncname;
	private String createDate;
	public int getNcid() {
		return ncid;
	}
	public void setNcid(int ncid) {
		this.ncid = ncid;
	}
	public String getNcname() {
		return ncname;
	}
	public NewsCategory() {
		super();
	}
	public NewsCategory(int ncid, String ncname, String createDate) {
		super();
		this.ncid = ncid;
		this.ncname = ncname;
		this.createDate = createDate;
	}
	public void setNcname(String ncname) {
		this.ncname = ncname;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
