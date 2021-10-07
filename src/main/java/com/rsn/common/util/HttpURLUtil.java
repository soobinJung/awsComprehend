package com.rsn.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class HttpURLUtil {

	// 특정 URI의 응답을 체크한다.
	public static boolean checkHttpURL(String strURL, String strURI)  {
		return checkHttpURL(strURL + strURI);
	}
	public static boolean checkHttpURL(String strURL) {
		URL url;
		URLConnection conn;
		HttpURLConnection httpConn = null;
		int responseCode;

		try {
			url = new URL(strURL);
			conn = url.openConnection();
			httpConn = (HttpURLConnection) conn;
			responseCode = httpConn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return true;
			} else {
				return false;
			}
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}
	}
	
	// 특정 URI 연결 (단순 parameter 전달)
	public static boolean callHttpURL(String strURL, String strURI)  {
		return callHttpURL(strURL + strURI);
	}
	public static boolean callHttpURL(String strURL)  {
		URL url;
		try {
			url = new URL(strURL);
			url.openStream();
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	// 특정 URI 연결 ( 리턴 parameter를 얻는다)
	public static String getParameter2HttpURL(String strURL, String strURI) {
		return getParameter2HttpURL(strURL + strURI);
	}
	public static String getParameter2HttpURL(String strURL) {
		URL url;
		URLConnection conn;
		BufferedReader in = null;
		String msg = new String();
		try {
			url = new URL(strURL);
			conn = url.openConnection();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			msg = in.readLine();
		} catch (MalformedURLException e) {
			msg = "";
		} catch (IOException e) {
			msg = "";
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return msg;
	}
	

	
	// 특정 URI 연결 ( 리턴 html를 얻는다)
	public static String getHtml2HttpURL(String strURL, String strURI) {
		return getHtml2HttpURL(strURL + strURI);
	}
	public static String getHtml2HttpURL(String strURL) {
		URL url;
		URLConnection conn;
		BufferedReader in = null;
		String line = null;
    	StringBuffer result = new StringBuffer();
		try {
			url = new URL(strURL);
			conn = url.openConnection();
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
	public static String getHtml2HttpURLPost(String strURL, String param) {
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
	
	
	
	/**
	 * @param strURL
	 * @param gsonData
	 * @return String be made of Json
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String getHTMLToHttpPost(String strURL, String param) throws UnsupportedEncodingException, IOException {
		
		System.out.println("###connectionURL : " + strURL + "?" + param);
		
        URL url = new URL(strURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		
		OutputStream os = conn.getOutputStream();
		os.write(param.getBytes("UTF-8"));
		os.close();
		InputStream in = new BufferedInputStream(conn.getInputStream());
		
		return IOUtils.toString(in, "UTF-8");
	}
	
	
}
