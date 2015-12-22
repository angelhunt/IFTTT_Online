package Model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import weibo4j.Status;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;
import weibo4j.org.json.HTTP;
import weibo4j.util.BareBonesBrowserLaunch;

public class SendWeibo extends That{
	protected String ID;
	protected String passWord;
	protected String message;
	
	public static void main()
	{

	
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SendWeibo(String ID, String passWord, String message){
		this.ID = ID;
		this.passWord = passWord;
		this.message = message;
	}
	
	public SendWeibo(String s){
		System.out.println(s+"!!!!!!!!!!!!!!!!!");
		System.out.println("ni sha bi");
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
		char[] temp_passWord = new char[length];
		copy(temp_passWord, test);
		passWord = new String(temp_passWord);
		length = 0;i++;
		
		while (temp[i] != '%'){
			test[length] = temp[i];
			length++;i++;
		}
		char[] temp_message = new char[length];
		copy(temp_message, test);
		message = new String(temp_message);
		length = 0;i++;
		
		
	}
	
	public void DoThat() {
        try {
        	System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
        	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
        	System.out.println( Weibo.CONSUMER_KEY+"  "+Weibo.CONSUMER_SECRET);
        	
            Weibo weibo = new Weibo();
            // set callback url, desktop app please set to null
            //  http://callback_url?oauth_token=xxx&oauth_verifier=xxx
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
                    .getToken(),ID,passWord);
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

            Status status = weibo.updateStatus(message);
            System.out.println("Successfully updated the status to ["
            		+ status.getText() + "].");
             
             try {
            	Thread.sleep(3000);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            System.exit(0);
        } catch (WeiboException te) {
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit( -1);
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
}




//
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




//
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

	public String toString() {
		return new String ("1%" + ID + "%" + passWord + "%" + message +"%");
	}
	
	private static void copy(char[] a, char[] b){
		for(int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}
	
	public static void main(String args[]){
		SendWeibo s = new SendWeibo("380261005@qq.com", "7225436", "hello world!");
		SendWeibo ss = new SendWeibo(s.toString());
		System.out.println(s.toString());
		System.out.println(ss.toString());
		ss.DoThat();
	}
	
}