package com.rsn.common.util;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static final String EMPTY = "";

	public StringUtil() {
		super();
	}
	public static void main(String[] args){
		
		System.out.println(StringUtil.indexMatches("오늘은 정말 오늘의 날인듯 오늘이 아닌듯 오늘이 가득하다", "오늘", -1));
	}
	
    /**
     * escapeFromSurrogateArea
     * 
     * @param val
     * @return
     */
	public static String escapeFromSurrogateArea(String str) {
		
//		log.info("str 1 : " + str);
		
		String returnVal = "";
		
		if (str != null){
			
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (0xD800 <= ch && ch <= 0xDBFF || 0xDC00 <= ch && ch <= 0xDFFF) {
					
//					log.info("0xD800 <= ch && ch <= 0xDBFF || 0xDC00 <= ch && ch <= 0xDFFF");
					
				} else {
					buffer.append(ch);
				}
			}
			returnVal = buffer.toString();
			
		}
//		log.info("str 2 : " + returnVal);
		
		return returnVal;
	}
	
	public static String ChangeString(String sVal){
		String rVal="";
		sVal=sVal.replaceAll("\"", "&quot;");
		sVal=sVal.replaceAll("'", "&#39;");
		sVal=sVal.replaceAll("<", "&lt;");
		sVal=sVal.replaceAll(">","&gt;");
		rVal=sVal;
		return rVal;
	}

	public static String ChangeString2(String sVal){
		String rVal="";
		sVal=sVal.replaceAll("&quot;", "\"" );
		sVal=sVal.replaceAll("&#39;", "'");
		sVal=sVal.replaceAll("&lt;", "<");
		sVal=sVal.replaceAll("&gt;", ">");

		sVal=sVal.replaceAll("&quot", "" );
		sVal=sVal.replaceAll("8#39", "" );
		sVal=sVal.replaceAll("lt", "");
		sVal=sVal.replaceAll("gt", "");
		rVal=sVal;
		return rVal;
	} 

	//특수문자 제거
	public static String stringReplace(String str){
//		\r|\n|\r\n|\n\r|\t
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str =str.replaceAll(match, " ");
		return str;
	}


	/**
	 * <p>str에서 해당 sub의 갯수 반환</p>
	 * 
	 * <pre>
	 *   StringUtil.countMatches("abcda", 'a')   = 2
	 *   StringUtil.countMatches("abcda", 'ab')  = 1
	 * </pre>
	 * 
	 * @param str
	 * @param sub
	 * @return
	 */
	public static int countMatches(String str, char sub) {
		if (isEmpty(str)) {
			return 0;
		}
		int count = 0;

		for( int i = 0; i < str.length(); i++ ) {
			if( str.charAt(i) == sub ) {
				count++;
			}
		}
		return count;
	}

	/**
	 * <p>str에서 해당 sub의 갯수 반환</p>
	 * 
	 * <pre>
	 *   StringUtil.countMatches("abcda", "a")   = 2
	 *   StringUtil.countMatches("abcda", "ab")  = 1
	 * </pre>
	 * 
	 * @param str
	 * @param sub
	 * @return
	 */
	public static int countMatches(String str, String sub) {
		return countMatches(str, sub, -1);
	}
	public static int countMatches(String str, String sub, int max) {
		if (isEmpty(str) || isEmpty(sub)) {
			return 0;
		}
		int count = 0;
		int idx = 0;
		while ((idx = str.indexOf(sub, idx)) != -1) {
			count++;
			idx += sub.length();

			if(max!=-1 && max>0 && count>=max)
				return count;
		}
		return count;
	}
	
	public static ArrayList<Integer> indexMatches(String str, String sub, int max) {
		
		ArrayList<Integer> result = new ArrayList<>();
		
		if (isEmpty(str) || isEmpty(sub)) {
			return result;
		}
		
		int count = 0;
		int idx = 0;
		while ((idx = str.indexOf(sub, idx)) != -1) {
			
			result.add(idx);
			
			idx += sub.length();
			
			if(max!=-1 && max>0 && count>=max)
				return result;
		}
		
		return result;
	}

	/**
	 * <p>
	 * String 값을 원하는 Byte 만큼 잘라서 반환
	 * </p>
	 * 
	 * <pre>
	 *   StringUtil.cutBytes(&quot;abcda&quot;, 2)   = ab
	 *   StringUtil.cutBytes(&quot;abcda&quot;, 10)  = abcda
	 * </pre>
	 * 
	 * @param str 원본 String
	 * @param int 자를 바이트 개수
	 * @return String 절단된 String
	 */
	public static String cutBytes(String str,int bytes) {
		byte[] byt = str.getBytes();
		int len = byt.length;
		int counter = 0;
		if (bytes >= len) { 
			return str; 
		}
		for (int i = bytes - 1; i >= 0; i--) { 
			if (((int)byt[i] & 0x80) != 0) 
				counter++; 
		} 
		return new String(byt,0,bytes-(counter%2));
	}

	/**-----------------------------------------------------------------------------
	 * 기 능 설 명 : 문자열이 원하는 길이 이상이면 자르고 뒤에 '...'을 붙임
	 * 입 력 변 수 : psValue         = 검사할 문자열
	 * 출 력 변 수 : true/false
	 * 비       고 :
	 * 예       제 :
	 */
	public static String cutString(String psValue, int piCutSize , String psAddstr ) throws Exception{
		String rtnValue = "";

		try{

			if ( psValue.length() > piCutSize ) {
				rtnValue = psValue.substring(0,piCutSize) + psAddstr;
			} else {
				rtnValue = psValue;
			}

		}finally{
			//..
		}
		return rtnValue;
	}

	/**
	 * <p>
	 * 스트링이 숫자와 알파벳으로만 이루어져있는지 검사한다.
	 * </p>
	 * 
	 * <pre>
	 *   StringUtil.isAlphaNumeric("")   = true
	 *   StringUtil.isAlphaNumeric("a")   = true
	 *   StringUtil.isAlphaNumeric("a1")   = true
	 *   StringUtil.isAlphaNumeric("a 1")   = false
	 *   StringUtil.isAlphaNumeric("aㄱ1")   = false
	 * </pre>
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isAlphaNumeric(String str) {
		boolean rtnVal = true;
		for (int i = 0; i < str.length(); i++) {
			if (Character.getType(str.charAt(i)) != 1
					&& Character.getType(str.charAt(i)) != 2
					&& Character.getType(str.charAt(i)) != 9) {
				rtnVal = false;
				break;
			}
		}
		return rtnVal;
	}

	/**
	 * <p>str 값이 null 이거나 빈스트링인지 검사.<br>
	 * str값이 null이거나 빈스트링인 경우 true를 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("abc")     = false
	 * </pre>
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}


	/**
	 * <p>str가 null이거나 빈스트링인 경우 replace으로 대체한다.<br>
	 * null이거나 빈스트링이 아니면 원래의 값을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.nvl(null, "abc")      = abc
	 * StringUtils.nvl("", "abc")        = abc
	 * StringUtils.nvl("cba", "abc")     = cba
	 * </pre>
	 * 
	 * @param str
	 * @param replace
	 * @return String
	 */
	public static String nvl(String str, String replace) {
		return (str == null || str.equals("")) ? replace : str;
	}

	/**
	 * <p>str가 null이거나 빈스트링인 경우 빈스트링으로 대체한다.<br>
	 * null이거나 빈스트링이 아니면 원래의 값을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.nvl(null)      = 
	 * StringUtils.nvl("")        = 
	 * StringUtils.nvl("cba")     = cba
	 * </pre>
	 * 
	 * @param value
	 * @return String
	 */
	public static String nvl(String str) {
		return nvl(str, EMPTY);
	}


	public static final String getSysVal(String baseName, String key){
		return getSysVal(baseName, key, null);
	}

	public static final String getSysVal(String baseName, String key, String charset){
		ResourceBundle rb = ResourceBundle.getBundle(baseName);
		if(charset == null){
			return rb.getString(key);
		}else{
			return CharEncodingUtil.changeCharset(rb.getString(key),"ISO-8859-1",charset);
		}
	}

	/**
	 * <p>str 에서 chr으로 split 하여 목록을 반환한다. </p>
	 * @param str
	 * @param chr
	 * @return String[]
	 */
	public static final String[] split(String str, String chr){
		String[] temp = null;

		if(str == null) return new String[0];
		if(str.trim().equals("")) return new String[0];

		Vector<String> buf = new Vector<String>();
		int pos = -1;
		while((pos = str.indexOf(chr))>-1){
			buf.addElement(str.substring(0,pos));
			str = str.substring(pos+1);
		}
		buf.addElement(str);
		temp = new String[buf.size()];
		for(int i = 0; i< buf.size();i++)
			temp[i] = (String)buf.get(i);

		return temp;
	}

	/**
	 * <p>str에서 value를 삭제한 결과값을 반환한다.</p>
	 * @param str
	 * @param value
	 * @return String
	 */
	public static String delChar(String str, String value){
		if(str == null)
			return "";
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(!(c+"").equals(value))
				sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * <p>str에서 searchStrs[]중 어느 하나라도 있으면 위치절대값(indexOf)을 반환한다.<br>
	 * 하나라도 존재하지 않으면 -1을 반환한다.</p>
	 * @param str
	 * @param searchStrs
	 * @return int
	 */
	public static int indexOfAny(String str, String[] searchStrs) {
		if ((str == null) || (searchStrs == null)) {
			return -1;
		}
		int sz = searchStrs.length;

		int ret = Integer.MAX_VALUE;

		int tmp = 0;
		for (int i = 0; i < sz; i++) {
			String search = searchStrs[i];
			if (search == null) {
				continue;
			}
			tmp = str.indexOf(search);
			if (tmp == -1) {
				continue;
			}

			if (tmp < ret) {
				ret = tmp;
			}
		}
		return (ret == Integer.MAX_VALUE) ? -1 : ret;
	}

	/**
	 * <p>str에 searchStrs[]의 모든 값을 포함하고 있는지 판단한다.<br>
	 * 모두포함하고 있으면 true, 하나라도 포함되지 않으면 false를 반환한다.</p>
	 * @param str
	 * @param searchStrs
	 * @return boolean
	 */
	public static boolean indexOfAll(String str, String[] searchStrs) {
		if ((str == null) || (searchStrs == null)) {
			return false;
		}
		int sz = searchStrs.length;
		int tmp = 0;
		boolean btmp = true;

		for (int i = 0; i < sz; i++) {
			String search = searchStrs[i];
			if (search == null) {
				btmp = false;
				continue;
			}
			tmp = str.indexOf(search);
			if (tmp == -1) {
				btmp = false;
				continue;
			}
		}
		return btmp;
	}

	/**
	 * <p>str에 searchStrs이 포함되어 있는 횟수를 반환한다.</p>
	 * @param str
	 * @param searchStr
	 * @param nextIndex
	 * @return int
	 */
	public static int indexOfCount(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return 0;
		}
		if (searchStr.length() == 0) {
			return 0;
		}
		int found = 0;
		int index = -1;
		do {
			index = str.indexOf(searchStr, index + 1);
			if (index < 0) {
				return index;
			}
			found++;
		} while (index > -1);
		return found;
	}

	/**
	 * <p>str에 searchStrs의 위치절대값을 반환한다..<br>
	 * searchStrs가 존재하지 않으면 -1을 반환.</p>
	 * @param str
	 * @param searchStr
	 * @return int
	 */
	public static int indexOf(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return -1;
		}
		return str.indexOf(searchStr);
	}

	/**
	 * <p>str에 nextIndex번째 이후에 위치한 searchStrs의 위치절대값을 반환한다..<br>
	 * nextIndex번째 이후에 searchStrs가 존재하지 않으면 -1을 반환.</p>
	 * @param str
	 * @param searchStr
	 * @param nextIndex
	 * @return int
	 */
	public static int nextIndexOf(String str, String searchStr, int nextIndex) {
		if (str == null || searchStr == null || nextIndex <= 0) {
			return -1;
		}
		if (searchStr.length() == 0) {
			return 0;
		}
		int found = 0;
		int index = -1;
		do {
			index = str.indexOf(searchStr, index + 1);
			if (index < 0) {
				return index;
			}
			found++;
		} while (found < nextIndex);
		return index;
	}


	/**
	 * <p>str에 searchStrs가 마지막으로 나타난 위치절대값을 반환한다..<br>
	 * nextIndex번째 이후에 searchStrs가 존재하지 않으면 -1을 반환.</p>
	 * @param str
	 * @param searchStr
	 * @return int
	 */
	public static int lastIndexOf(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return -1;
		}
		return str.lastIndexOf(searchStr);
	}

	/**
	 * <p>text 에서 searchString에 해당하는 문자를 찾아서 replacement로 변환하여 반환한다. </p>
	 * @param text
	 * @param searchString
	 * @param replacement
	 * @return 변환된 text
	 */
	public static String replace(String text, String searchString, String replacement) {
		return replace(text, searchString, replacement, -1);
	}


	/**
	 * <p>text 에서 searchString에 해당하는 문자를 찾아서 replacement로 변환하여 반환한다. </p>
	 * @param text
	 * @param searchString
	 * @param replacement
	 * @param max
	 * @return 변환된 text
	 */
	public static String replace(String text, String searchString, String replacement, int max) {
		if (isEmpty(text) || isEmpty(searchString) || replacement == null || max == 0) {
			return text;
		}
		int start = 0;
		int end = text.indexOf(searchString, start);
		if (end == -1) {
			return text;
		}
		int replLength = searchString.length();
		int increase = replacement.length() - replLength;
		increase = (increase < 0 ? 0 : increase);
		increase *= (max < 0 ? 16 : (max > 64 ? 64 : max));
		StringBuffer buf = new StringBuffer(text.length() + increase);
		while (end != -1) {
			buf.append(text.substring(start, end)).append(replacement);
			start = end + replLength;
			if (--max == 0) {
				break;
			}
			end = text.indexOf(searchString, start);
		}
		buf.append(text.substring(start));
		return buf.toString();
	}


	/**
	 * <p>str 에서 separator가 나타난 이후의 문자열을 반환한다. </p>
	 * 
	 * @param str
	 * @param separator
	 * @return separator가 나타난 이후의 문자열
	 */
	public static String substringAfter(String str, String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (separator == null) {
			return EMPTY;
		}
		int pos = str.indexOf(separator);
		if (pos == -1) {
			return EMPTY;
		}
		return str.substring(pos + separator.length());
	}


	/**
	 * <p>str 에서 separator가 나타난 이전의 문자열을 반환한다. </p>
	 * 
	 * @param str
	 * @param separator
	 * @return separator가 나타난 이전의 문자열
	 */
	public static String substringBefore(String str, String separator) {
		if (isEmpty(str) || separator == null) {
			return str;
		}
		if (separator.length() == 0) {
			return EMPTY;
		}
		int pos = str.indexOf(separator);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}


	/**
	 * <p>str 에서 주어진 토큰으로 파싱하여 목록을 반환한다. </p>
	 * 
	 * @param str
	 * @param _token
	 * @return 토큰으로 파싱되어진 목록
	 */
	public static String[] getTokenData(String str, char _token){
		String tempbuf = str;

		if (str == null) return null;
		if (str.length() == 0) return null;

		int j=0;
		for(int i=0;i<str.length();i++){
			if(tempbuf.charAt(i) == _token){
				j++;
			}	
		}

		String rtnbuf[] = new String[j+1];

		j=0;
		rtnbuf[0]="";
		for(int i=0;i<str.length();i++){
			if(tempbuf.charAt(i) == _token){
				j++;
				rtnbuf[j]="";
			}	
			else{
				rtnbuf[j] =  rtnbuf[j]+String.valueOf(tempbuf.charAt(i));
			}
		}

		return rtnbuf;
	}

	/**
	 * <p>최대길이가 주어진 최대값을 넘지 않도록 토큰으로 분리한 목록을 반환한다. </p>
	 * 
	 * @param str
	 * @param _token
	 * @return 토큰으로 파싱되어진 목록
	 */
	public static String[] getTokenData(String str, char _token, int maxLen){
		String tempbuf = str;

		if (str == null) return null;
		if (str.length() == 0) return null;

		int j=0;
		for(int i=0;i<str.length();i++){
			if(tempbuf.charAt(i) == _token){
				j++;
			}	
		}

		String rtnbuf[] = new String[j+1];

		j=0;
		rtnbuf[0]="";
		for(int i=0;i<str.length();i++){
			if(tempbuf.charAt(i) == _token){
				j++;
				rtnbuf[j]="";
			}	
			else{
				rtnbuf[j] =  rtnbuf[j]+String.valueOf(tempbuf.charAt(i));
			}
		}

		String[] tempBuf = new String[rtnbuf.length];
		tempBuf = rtnbuf;
		for(int i=0;rtnbuf.length > i+1;){
			rtnbuf = tempBuf;
			if((rtnbuf[i] + rtnbuf[i+1]).length() < maxLen){
				rtnbuf[i] = rtnbuf[i] + String.valueOf(_token) + rtnbuf[i+1];
				for(j=i+1;j<rtnbuf.length-1;j++){
					rtnbuf[j] = rtnbuf[j+1];
				}
				tempBuf = new String[rtnbuf.length-1];
				for(j=0;j<tempBuf.length;j++){
					tempBuf[j] = rtnbuf[j];
				}
				i=0;
			}else{
				i++;
			}
			if(i==rtnbuf.length-1){
				break;
			}
		}

		return rtnbuf;
	}


	/**
	 * <p>text 에서 2byte 단위로 잘라진 문자열 목록을 반환한다. </p>
	 * 
	 * @param text
	 * @return 잘라진 문자열
	 */
	public static ArrayList<String> cut2ByteList(String text){
		ArrayList<String> list = new ArrayList<String>();
		// 바이트로 자르기.
		for (int i = 2; i < text.length(); i++) {
			for (int j = 0; j < text.length(); j++) {
				if(j+(i-1) < text.length())
					list.add(text.substring(j, j+i));
			}			
		}
		return list;
	}

	/**
	 * Target에 source가 포함 되어있는지 여부
	 * @param target
	 * @param source
	 * @return
	 */
	public static boolean Comparison(String[] target, String source){
		boolean result = false;
		if(target != null && target.length != 0){
			for(String targetSeq : target){
				if(targetSeq.equals(source)){
					result = true;
					break;
				}
			}
		}
		return result;
	}

	public static String cleanTag(String content) {
		Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>",Pattern.DOTALL);
		Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>",Pattern.DOTALL); 
		Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>"); 
		//Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s>*"); 
		Pattern ENTITY_REFS = Pattern.compile("&[^;]+;"); 
		Pattern WHITESPACE = Pattern.compile("\\s\\s+"); 

		Matcher m; 

		m = SCRIPTS.matcher(content); 
		content = m.replaceAll(""); 
		m = STYLE.matcher(content); 
		content = m.replaceAll(""); 
		m = TAGS.matcher(content); 
		content = m.replaceAll(""); 
		m = ENTITY_REFS.matcher(content); 
		content = m.replaceAll(""); 
		m = WHITESPACE.matcher(content); 
		content = m.replaceAll(" "); 

		return content; 
	}

	/**
	 * 숫자인지 체크
	 * @param str
	 * @return
	 */
    public static boolean isNumeric(String str) {

        Pattern pattern = Pattern.compile("[+-]?\\d+");
        return pattern.matcher(str).matches();
    }
    
    public static ArrayList<Integer> lastIndexOfAllPosition(String str, String[] searchStrs) {
    	ArrayList<Integer> arrPosition = new ArrayList<Integer>();
    	int position = -1;
        if ((str == null) || (searchStrs == null)) {
        	arrPosition.add(position);
            return arrPosition;
        }
        int sz = searchStrs.length;
        int tmp = 0;
        boolean btmp = true;

        for (int i = 0; i < sz; i++) {
            String search = searchStrs[i];
            if (search == null) {
            	btmp = false;
                continue;
            }
            tmp = str.indexOf(search);
            position = tmp;
            arrPosition.add(position);
            
            if (tmp == -1) {
                btmp = false;
                break;
            }
        }
        
        if(!btmp){
        	arrPosition = new ArrayList<Integer>();
        	arrPosition.add(position);
        }
        return arrPosition;
    }

}
