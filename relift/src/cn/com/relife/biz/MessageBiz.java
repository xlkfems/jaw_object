package cn.com.relife.biz;

import cn.com.relife.entity.Message;
import cn.com.relife.impl.MessageDaoImpl;

public class MessageBiz {
	MessageDaoImpl mdil=new MessageDaoImpl();
	
	public int add_message(Message message) {
		return mdil.add_message(message);
		
	}
}
