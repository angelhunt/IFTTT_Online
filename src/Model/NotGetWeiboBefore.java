package Model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import weibo4j.Status;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

public class NotGetWeiboBefore {
	protected String ID;
	protected String password;
	protected Date startTime;
	protected Date endTime;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean ReturnThis() {
		try {
        	System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
        	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
        	System.out.println( Weibo.CONSUMER_KEY+"  "+Weibo.CONSUMER_SECRET);
        	
            Weibo weibo = new Weibo();
            // set callback url, desktop app please set to null
            // http://callback_url?oauth_token=xxx&oauth_verifier=xxx
            RequestToken requestToken = weibo.getOAuthRequestToken();
            
            System.out.println("Got request token.");
            System.out.println("Request token: "+ requestToken.getToken());
            System.out.println("Request token secret: "+ requestToken.getTokenSecret());
            AccessToken accessToken = null;
            
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (null == accessToken) {
                System.out.println("Open the following URL and grant access to your account:");
                System.out.println(requestToken.getAuthorizationURL());
                //BareBonesBrowserLaunch.openURL(requestToken.getAuthorizationURL());
                System.out.print("Hit enter when it's done.[Enter]:");
                
                String pin = getPin(requestToken.getAuthorizationURL(), requestToken
                    .getToken(),ID,password);
                try{
                    accessToken = requestToken.getAccessToken(pin);
                } catch (WeiboException te) {
                    if(401 == te.getStatusCode()){
                        System.out.println("Unable to get the access token.");
                    }else{
                        te.printStackTrace();
                    }
                }
            }
            System.out.println("Got access token.");
            System.out.println("Access token: "+ accessToken.getToken());
            System.out.println("Access token secret: "+ accessToken.getTokenSecret());

            weibo.setToken(accessToken.getToken(), accessToken.getTokenSecret());
            while(true){
            	if (endTime.after(new Date()))
            		return true;
            	System.out.println("开始收消息");
            	List<Status> list = weibo.getUserTimeline();
            	if (list.isEmpty())
            		System.out.println("消息为空");
            	int temp = list.size();
            	for (int i = 0; i < temp; i++){
            		Status status = list.get(i);
            		System.out.println(status.getId() + ":" + status.getText());
            		if (status.getCreatedAt().after(startTime))
            			return false;
            	}
            	try {
            		Thread.sleep(3000);
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            }
        } catch (WeiboException te) {
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit( -1);
            return false;
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(-1);
            return false;
        }
	}
	
	public static String getPin(String url, String token,String ID,String passWord) throws IOException {
        String html = readContentFromPost(url, token,ID,passWord);
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(
        								"<span class=\"fb\">(\\d+)</span>").matcher(html);
        boolean flag = matcher.find();
        String obj = null;
        if (flag) {
            java.lang.String s1 = matcher.group();
            System.out.println("s1:" + s1);
            matcher = java.util.regex.Pattern.compile("[0-9]{6}").matcher(s1);//最终得到PIN码 
            if (matcher.find()) {
                obj = matcher.group();
            }
        }
        System.out.println(obj);
        return obj;
    }
	
	public static String readContentFromPost(String url, String token,String ID,String passWord) throws IOException {
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        // 设置是否向connection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);

        // URLConnection.setInstanceFollowRedirects 是成员函数，仅作用于当前函数
        connection.setInstanceFollowRedirects(true);
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
        String content = "userId=" + ID + "&passwd=" + passWord
                         + "&oauth_callback=none" + "&action=submit" + "&from=" + "null"
                         + "&oauth_token=" + token;
        out.writeBytes(content);

        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection
            .getInputStream()));
        String line = "";
        String str = "";
        System.out.println("Contents of post request");
        while ((line = reader.readLine()) != null) {
            str += line;
        }
        System.out.println("Contents of post request ends");
        reader.close();
        connection.disconnect();
        System.out.println(str);
        return str;
    }
	
	public NotGetWeiboBefore(String ID, String password, String endTime){
		this.ID = ID;
		this.password = password;
		this.startTime = new Date();
		this.endTime = StringToDate(endTime);
	}
	
	public NotGetWeiboBefore(String s){
		char[] temp = s.toCharArray();
		char[] test = new char[100];
		int i = 0, length = 0;
		
		while (temp[i] != '%')
			i++;
		i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_ID = new char[length];
		copy(temp_ID, test);
		ID = new String(temp_ID);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_password = new char[length];
		copy(temp_password, test);
		password = new String(temp_password);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_endtime = new char[length];
		copy(temp_endtime, test);
		String endtime = new String(temp_endtime);
		endTime = StringToDate(endtime);
		length = 0;i++;
		
		this.startTime = new Date();
	}
	
	public String toString() {
		String temp = DateToString(endTime);
		return new String ("4%" + ID + "%" + password + "%" + temp + "%");
	}
	
	private static String DateToString(Date d){     
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(d);   
        return dateString;   
    }
	
	public static Date StringToDate(String s){
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date=sf.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	private static void copy(char[] a, char[] b){
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static void main(String args[]){
		NotGetWeiboBefore n = new NotGetWeiboBefore("380261005@qq.com", "7225436", "2011-12-18 15:00:00");
		NotGetWeiboBefore nn = new NotGetWeiboBefore(n.toString());
		System.out.println(nn.toString());
	}
}
