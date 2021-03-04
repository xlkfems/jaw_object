package cn.com.relife.dao;
import java.util.List;

import cn.com.relife.entity.Client;


/**
 * @remark �ͻ��ӿ���
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public interface ClientDao {
	/*
	 * ��ҳ��ѯ
	 * @param pageNo       ��ǰҳ��
	 * @param pageSize   ��ʾ��
	 * @return 			 ���ؼ���
	 * */
	public List<Client> pageClientAll(int page,int pageSize);
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount();
	/**
	 * 	��ѯ�����ͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public Client queryOne(int id);
	/**
	 * 	���ӿͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int addClient(Client client);
	/**
	 * 	ɾ���ͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int delClient(int id);
	/**
	 * 	�޸Ŀͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int updClient(Client client);
	
}
