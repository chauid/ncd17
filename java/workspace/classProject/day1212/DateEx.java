package day1212;

import java.util.Calendar;
//import java.util.Date;

public class DateEx {
	public static class DateTime {
		public Integer year;
		public Integer month;
		public Integer date;
		public Integer hour;
		public Integer minute;
		public Integer second;
		public Integer millisecond;
		
		public void getCurrentDateTime()
		{
			Calendar calendar = Calendar.getInstance();
			this.year = calendar.get(Calendar.YEAR);
			this.month = calendar.get(Calendar.MONTH);
			this.date = calendar.get(Calendar.DATE);
			this.hour = calendar.get(Calendar.HOUR);
			this.minute = calendar.get(Calendar.MINUTE);
			this.second = calendar.get(Calendar.SECOND);
			this.millisecond = calendar.get(Calendar.MILLISECOND);
		}
	}
	
	public static void main(String[] args) {
//		Date curDate = new Date(); // Deprecated
		DateTime cur = new DateTime();
		while (true) {
			cur.getCurrentDateTime();
			System.out.printf("%d.%d.%d %d:%d:%d:%d\n", cur.year, cur.month, cur.date, cur.hour, cur.minute, cur.second, cur.millisecond);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Thread Error");
			}
		}
	}
}
