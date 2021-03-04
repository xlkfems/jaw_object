package cn.com.relife.biz;



import java.util.List;

import cn.com.relife.entity.Client;
import cn.com.relife.impl.ClientDaoImpl;
/**
 * @remark �ͻ��߼���
 * @author ���
 * @createTime 15��14��
 * @version 1.0
 */
public class ClientBiz {
	ClientDaoImpl impl = new ClientDaoImpl();
	/**
	 * 	��ѯȫ������
	 * @param client
	 * @return
	 */
	public List<Client> pageClientAll(int page,int pageSize){
		return impl.pageClientAll(page, pageSize);
	}
	public List<Client> pageClientAll(int page,int pageSize,String number){
		return impl.pageClientAll(page, pageSize,number);
	}
	/**
	 * ��ѯ������
	 * @return int����
	 * */
	public int getTotalCount() {
		return impl.getTotalCount();
	}
	/**
	 * 	��ѯ�����ͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public Client queryOne(int id) {
		return impl.queryOne(id);
	}
	/**
	 * 	���ӿͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int addClient(Client client) {
		return impl.addClient(client);
	}
	/**
	 * 	ɾ���ͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int delClient(int id) {
		return impl.delClient(id);
	}
	/**
	 * 	�޸Ŀͻ���Ϣ����
	 * @param client
	 * @return
	 */
	public int updClient(Client client) {
		return impl.updClient(client);
	}
}
