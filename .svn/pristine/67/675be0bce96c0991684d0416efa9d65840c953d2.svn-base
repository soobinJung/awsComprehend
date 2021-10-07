package com.rsn.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TelegramUtil {
	
	/**
	 * <p>개별 메세지를 발송한다. <br>
	 * - 전화번호 1개만 등록가능<br>
	 * - 010-0000-0000 식으로 등록</p> 
	*/
	public static String sendMessege(String messege, String PhoneNumber){
		return  getMessegeResponse("http://telegramapi.realsn.com/rsnTelegramAPI.php", "type=sendRequest&key=08bf020fc865c5e1&m_phon="+PhoneNumber+"&message="+messege);
	}
	
	public static String getMessegeResponse(String strURL, String param) {
		URL url;
		URLConnection conn;
		BufferedReader in = null;
		OutputStreamWriter wr = null;
		String line = null;
    	StringBuffer result = new StringBuffer();
		try {
			url = new URL(strURL);
			conn = url.openConnection();
			((HttpURLConnection)conn).setRequestMethod("POST");
			conn.setDoOutput(true);

			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(param);
			wr.flush();
	           
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			while((line = in.readLine()) != null){
    			result.append( line+"\n");
    		}
		} catch (MalformedURLException e) {

		} catch (IOException e) {

		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
    	return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(TelegramUtil.sendMessege("테스트 발송2 개별", "010-8854-0558"));
	}
}
