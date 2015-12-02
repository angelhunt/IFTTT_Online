package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time extends This{
	protected String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Time(Date time){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = formatter.format(time);
	}
	
	public Time(String s){
		System.out.println("开始创建时间判定");
		char[] temp = s.toCharArray();
		char[] test_time = new char[100];
		int length = 0;
		int i = 0;
		
		while(temp[i] != '%')
			i++;
		i++;
		while(temp[i] != '%'){
			test_time[length] = temp[i];
			length++;i++;
		}
		char[] temp_time = new char[length];
		copy(temp_time, test_time);
		time = new String(temp_time);
	}
	
	public boolean ReturnThis() {
		while (true){
			String now = getCurrentTime();
			if (time.equals(now))
			{
				System.out.println("time is got.");
				return true;
			}
		}
	}

	public String toString() {
		return new String("1%" + time + "%");
	}
	
	public static String getCurrentTime(){   
        Date currentTime = new Date();   
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);   
        return dateString;   
    }
	
	private static void copy(char[] a, char[] b){
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static void main(String args[]){
		Time t = new Time("1%adsf%");
		System.out.print(t.toString());
	}
}
