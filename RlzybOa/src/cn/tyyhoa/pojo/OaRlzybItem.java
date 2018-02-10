package cn.tyyhoa.pojo;

public class OaRlzybItem {
	private Integer id; // ID编号
	private String name; // 录入事项人的姓名
	private String text; // 录入信息
	private String time; // 录入时间
	private Integer del; // 删除
	
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
