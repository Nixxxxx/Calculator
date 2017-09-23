package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


/**
 * 
 * @author JH
 *
 */

public class calendar {
		public static void main(String[] args) throws ParseException {
		System.out.println("请输入日期：（年月日，格式：）");
		Scanner scanner=new Scanner(System.in);
		String temp=scanner.nextLine();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(temp);
		
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		
		int maxDate=calendar.getActualMaximum(Calendar.DATE);
		int day=calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int j=1;j<day;j++){
			System.out.print("\t");
		}
		for(int i=1;i<=maxDate;i++){
			System.out.print(i+"\t");
			if((i+day)%7==1) System.out.println();
		}
		}
}
