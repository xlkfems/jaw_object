package cn.com.relife.entity;
/**
 * @remark ְԱʵ�����
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class Clerk {
	private int cl_id;//ְԱid
	private String cl_number;//ְԱ���
	private String cl_name;//ְԱ����
	private String cl_section;//����
	private String cl_sex;//�Ա�
	private String cl_time;//����ʱ��
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
