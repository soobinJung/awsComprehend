package com.rsn.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CharEncodingUtil {
	
	/**
	 * <p>ISO-8859-1의 str을 EUC-KR로 인코딩한 결과값을 반환한다.</p>
	 * @param str
	 * @return String 인코딩 결과
	 */
	public static final String toEUC_KR(String str) {
        return changeCharset(str, "ISO-8859-1", "EUC-KR");
    }

	/**
	 * <p>EUC-KR의 str을 ISO-8859-1로 인코딩한 결과값을 반환한다.</p>
	 * @param str
	 * @return String 인코딩 결과
	 */
	public static final String toKR_EUC(String str){
		return changeCharset(str, "EUC-KR", "ISO-8859-1");
	}

	/**
	 * <p>UTF-8의 str을 EUC-KR로 인코딩한 결과값을 반환한다.</p>
	 * @param str
	 * @return String 인코딩 결과
	 */
	public static final String toUTF8_EUC(String str){
		return changeCharset(str, "UTF-8", "EUC-KR");
	}
	public static final String toEUC_KR2(String str){
		return changeCharset(str, "EUC-KR","UTF-8");
	}
	/**
	 * <p>String 인코딩 변환.</p>
	 * 
	 * @param str
	 * @param to_code
	 * @param form_code
	 * @return String 인코딩 결과
	 */
    public static final String changeCharset(String str, String to_code, String form_code){
        if(str == null) return null;
        try{
            return new String(str.getBytes(to_code), form_code);
        }catch(UnsupportedEncodingException e){
            return str;
        }
    }
    
    /**
	 * <p>str을 URLIncoding 하여 반환한다</p>
	 * @param str code
	 * @return String 인코딩 결과
	 */
    public static final String changeEncode(String str, String code){
		try {
			return  URLEncoder.encode(str, code);
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}


    /**
     * 
     * @param unicode
     * @return
     * @throws Exception
     */
    public static String unicodeDecode(String unicode)throws Exception {
		StringBuffer str = new StringBuffer();

		char ch = 0;
		for( int i= unicode.indexOf("\\u"); i > -1; i = unicode.indexOf("\\u") ){
			ch = (char)Integer.parseInt( unicode.substring( i + 2, i + 6 ) ,16);
			str.append( unicode.substring(0, i) );
			str.append( String.valueOf(ch) );
			unicode = unicode.substring(i + 6);
		}
		str.append( unicode );

		return str.toString();
	}
    
    /**
     *  
     * @param unicode
     * @return
     * @throws Exception
     */
	public static String unicodeEncode(String unicode)throws Exception {
		StringBuffer str = new StringBuffer();

		for (int i = 0; i < unicode.length(); i++) {
			if(((int) unicode.charAt(i) == 32)) {
				str.append(" ");
				continue;
			}
			str.append("\\u");
			str.append(Integer.toHexString((int) unicode.charAt(i)));

		}

		return str.toString();

	}
}
