package cn.com.relife.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	/* ��ȡָ���պ� �� dayAddNum ��� ����
	 * @param day  ���ڣ���ʽΪString��"2013-9-3";
	 * @param dayAddNum �������� ��ʽΪint;
	 * @return
	 */
	public static String getDateStr(String day,int dayAddNum) {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = null;
		try {
			nowDate = df.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date newDate2 = new Date(nowDate.getTime() + dayAddNum * 24 * 60 * 60 * 1000);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateOk = simpleDateFormat.format(newDate2);
		return dateOk;
	}

}
