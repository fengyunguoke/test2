package jdbcconnection;

/**
 * 以下实例显示了Date类和Time类如何格式化为标准的Java日期和时间值以匹配SQL数据类型要求
 * @author baofengWu
 * @version 1.0
 *
 */

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class SqlDateTime {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//Get standard date and time
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();
		System.out.println("The Java Date is: " + javaDate.toString());
		
		//Get and display SQL DATE
		java.sql.Date sqlDate = new java.sql.Date(javaTime);
		System.out.println("The SQL DATE is: " + sqlDate.toString());
		
		//Get and display SQL TIME
		java.sql.Time sqlTime = new java.sql.Time(javaTime);
		System.out.println("The SQL TIME is: " + sqlTime.toString());
		
		//Get and display SQL TIMESTAMP
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
		System.out.println("The SQL TIMESTAMP is: " + sqlTimestamp.toString());
		
	}

}
