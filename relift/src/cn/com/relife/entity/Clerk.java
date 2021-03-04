package cn.com.relife.entity;
/**
 * @remark 职员实体对象
 * @author 随便
 * @createTime 15点14分
 * @version 1.0
 */
public class Clerk {
	private int cl_id;//职员id
	private String cl_number;//职员编号
	private String cl_name;//职员姓名
	private String cl_section;//部门
	private String cl_sex;//性别
	private String cl_time;//出生时间
	public Clerk() {
		// TODO Auto-generated constructor stub
	}
	public Clerk(int cl_id,String cl_number,String cl_name, String cl_section,String cl_sex,String cl_time) {
		this.cl_id = cl_id;
		this.cl_name = cl_name;
		this.cl_section = cl_section;
		this.cl_sex = cl_sex;
		this.cl_time = cl_time;
		this.cl_number = cl_number;
	}
	
	public Clerk(String cl_number,String cl_name, String cl_section, String cl_sex, String cl_time) {
		super();
		this.cl_name = cl_name;
		this.cl_section = cl_section;
		this.cl_sex = cl_sex;
		this.cl_time = cl_time;
		this.cl_number = cl_number;
	}
	public Clerk(String cl_name, String cl_section, String cl_sex, String cl_time,int cl_id) {
		super();
		this.cl_id = cl_id;
		this.cl_name = cl_name;
		this.cl_section = cl_section;
		this.cl_sex = cl_sex;
		this.cl_time = cl_time;
	}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public String getCl_section() {
		return cl_section;
	}
	public void setCl_section(String cl_section) {
		this.cl_section = cl_section;
	}
	
	public String getCl_number() {
		return cl_number;
	}
	public void setCl_number(String cl_number) {
		this.cl_number = cl_number;
	}
	public String getCl_sex() {
		return cl_sex;
	}
	public void setCl_sex(String cl_sex) {
		this.cl_sex = cl_sex;
	}
	public String getCl_time() {
		return cl_time;
	}
	public void setCl_time(String cl_time) {
		this.cl_time = cl_time;
	}
	
}
