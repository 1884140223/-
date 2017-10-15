package sys_bs.entity;

public class ClassRoom {
	private String id;//主键	教室编号
	private String code;	//年级
	private String password; //登录密码
	private String lei;//文理科
	private String number;//学生人数
	private String teacher;//班主任
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLei() {
		return lei;
	}
	public void setLei(String lei) {
		this.lei = lei;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTeacher() {
		return teacher;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
}
