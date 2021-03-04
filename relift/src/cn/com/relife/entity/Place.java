package cn.com.relife.entity;
/**
 * @remark ����ʵ����
 * @author ���
 * @createTime 09��16��
 * @version 1.0
 */
public class Place {
	private int id;//����id
	private String number;//����id
	private String state;//����״̬
	private String remark;//��ע
	private String money;//���ʽ
	private String pick;//�����ʽ
	private String days;//�µ�����
	private String insuredPrice;//�����ֵ
	private String type;//��������
	private String weight;//��������
	private String cargo;//��������
	private String pl_money;//�����ֵ
	private String a_address_block;//�ռ���ַ
	private String a_phone;//�ռ��绰
	private String a_name;//�ռ�����
	private String m_address_block;//������ַ
	private String m_phone;//�ļ��绰
	private String m_name;//�ļ�����
	private String piece;//����
	
	public Place() {
		// TODO Auto-generated constructor stub
	}
	public Place(String state,String number) {
		this.state = state;
		this.number = number;
	}
	public Place(String state,String m_address_block,String m_phone, String m_name) {
		this.state = state;
		this.m_address_block = m_address_block;
		this.m_phone = m_phone;
		this.m_name = m_name;
	}
	public Place(int id,String number,String m_name,String m_address_block,String a_name,String a_address_block) {
		this.id=id;
		this.number = number;
		this.m_name = m_name;
		this.m_address_block=m_address_block;
		this.a_name=a_name;
		this.a_address_block=a_address_block;
	}
	public Place(int id,String number,String pick,String money) {
		this.id=id;
		this.number = number;
		this.pick = pick;
		this.money=money;
	}
	public Place(int id,String number,String pick,String pl_money,String remark) {
		this.id=id;
		this.number = number;
		this.pick = pick;
		this.pl_money=pl_money;
		this.remark=remark;
	}
	public Place(int id,String number,String state) {
		this.id=id;
		this.number = number;
		this.state = state;
	}
	public Place(String number, String a_address_block, String a_phone, String a_name,
			String m_address_block, String m_phone, String m_name,String piece,
			String weight
			) {
		this.number = number;
		this.a_address_block = a_address_block;
		this.a_phone = a_phone;
		this.a_name = a_name;
		this.m_address_block = m_address_block;
		this.m_phone = m_phone;
		this.m_name = m_name;
		this.piece=piece;
		this.weight=weight;
		
	}
	public Place(String number, String state, String remark, String money, String pick, String days,
			String type, String weight, String cargo, String a_address_block, String a_phone, String a_name,
			String m_address_block, String m_phone, String m_name,String piece) {
		this.number = number;
		this.state = state;
		this.remark = remark;
		this.money = money;
		this.pick = pick;
		this.days = days;
		this.type = type;
		this.weight = weight;
		this.cargo = cargo;
		this.a_address_block = a_address_block;
		this.a_phone = a_phone;
		this.a_name = a_name;
		this.m_address_block = m_address_block;
		this.m_phone = m_phone;
		this.m_name = m_name;
		this.piece=piece;
	}
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	public Place(int id, String number, String state, String remark, String money, String pick, String days,
			String type, String weight, String cargo, String a_address_block, String a_phone, String a_name,
			String m_address_block, String m_phone, String m_name) {
		this.id = id;
		this.number = number;
		this.state = state;
		this.remark = remark;
		this.money = money;
		this.pick = pick;
		this.days = days;
		this.type = type;
		this.weight = weight;
		this.cargo = cargo;
		this.a_address_block = a_address_block;
		this.a_phone = a_phone;
		this.a_name = a_name;
		this.m_address_block = m_address_block;
		this.m_phone = m_phone;
		this.m_name = m_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPick() {
		return pick;
	}
	public void setPick(String pick) {
		this.pick = pick;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getA_address_block() {
		return a_address_block;
	}
	public void setA_address_block(String a_address_block) {
		this.a_address_block = a_address_block;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getM_address_block() {
		return m_address_block;
	}
	public void setM_address_block(String m_address_block) {
		this.m_address_block = m_address_block;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getInsuredPrice() {
		return insuredPrice;
	}
	public void setInsuredPrice(String insuredPrice) {
		this.insuredPrice = insuredPrice;
	}
	public String getPl_money() {
		return pl_money;
	}
	public void setPl_money(String pl_money) {
		this.pl_money = pl_money;
	}
}
