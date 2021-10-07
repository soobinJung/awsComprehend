package com.rsn.common.util;

import java.util.ArrayList;

public class SearchText {
	
	
	public static boolean nearSearch(String strHtml, String[] key, int iNearByte){
		int tempIndex1 = 0;
		int lastIndex = 0;
		int nextIndex = 1;
		boolean bFindKey = false;
		String[] tempKey = null;
		String searchHtml = "";
		String frontHtml = "";
		String backHtml = "";
		
		tempIndex1 = nextIndexOf(strHtml, key[0], nextIndex);
		lastIndex = lastIndexOf(strHtml, key[0]);

		if(tempIndex1 != -1){	   
			tempKey = new String[key.length-1];

			
			for(int j=1;j<key.length;j++){
				tempKey[j-1] = key[j];
			}

			findKeyLoop:while (tempIndex1 <= lastIndex){
				tempIndex1 = nextIndexOf(strHtml, key[0], nextIndex);
				++nextIndex;
				if(tempIndex1 != -1){

					// 키의 위치가 첫글짜 이면 (tempIndex1 == 0) 앞쪽은 자르지 않는다.

					// 키의 위치로 부터 앞쪽으로 iNearByte 만큼 자른다.
					frontHtml = (tempIndex1 - iNearByte) > 0 ? 
							strHtml.substring(tempIndex1 - iNearByte, tempIndex1) : 
								strHtml.substring(0, tempIndex1); 


							// 키의 위치로 부터 뒷쪽으로 (키.length + iNearByte) 만큼 자른다.
							backHtml = strHtml.length() - (key[0].length() + iNearByte + 1) > tempIndex1 ? 
									strHtml.substring(tempIndex1, tempIndex1 + key[0].length() + iNearByte) : 
										strHtml.substring(tempIndex1, strHtml.length());


									searchHtml = frontHtml + backHtml;

									bFindKey = indexOfAll(searchHtml, tempKey);					

									if(bFindKey) break findKeyLoop;

				}else{
					break findKeyLoop;
				}				
			}
		}
		return bFindKey;
	}

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

	public static int lastIndexOf(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return -1;
		}
		return str.lastIndexOf(searchStr);
	}
	
	   /**
     * <p> key[0] 이 nextIndex번째로  노출된 지점에서 뒤로 iNearByte(byte) 이내에 key[1~n]이 모두 존재 하는지 검사하고<br> 
     *     전체 문서에서 키워드의 시작값과 끝값을 반환.</p>
     * @param strHtml
     * @param key
     * @param iNearByte
     * @param nextIndex
     * @return
     */
    public static int nearSearchPosition(String strHtml, String[] key, int iNearByte, int nextIndex){
    	String[] tempKey = null;
    	String searchHtml = ""; 	
    	int keyIdx;
    	int ekeyIdx = -1;
    	int textStart = 0;
    	ArrayList<Integer> arrPosition = new ArrayList<Integer>();
    	int start = -1;
    	int end = -1;
    	
    	// 첫번째 키를 제외한 키 목록을 만든다.
		tempKey = new String[key.length-1];
		for(int j=1;j<key.length;j++){
			tempKey[j-1] = key[j];
		}
		
		if((keyIdx = StringUtil.nextIndexOf(strHtml, key[0], nextIndex)) != -1){
//			System.out.println("keyIdx : " + keyIdx);
			textStart = keyIdx -  iNearByte < 0 ? 0 : keyIdx -  iNearByte;
//			textStart = keyIdx;
//			System.out.println("textStart : " + textStart + " : textEnd : " + (keyIdx + key[0].length() + iNearByte));
			
    		// 키의 위치로 부터 뒷쪽으로 (키.length + iNearByte) 만큼 자른다.
			searchHtml = strHtml.length() - (key[0].length() + iNearByte + 1) > keyIdx ? 
						strHtml.substring(textStart, keyIdx + key[0].length() + iNearByte) :
						strHtml.substring(textStart, strHtml.length());
			
			// 첫번째 키를 제외한 키 목록이 모두 존재하는지 판단한다.
						
			arrPosition = StringUtil.lastIndexOfAllPosition(searchHtml, tempKey)	;
//			System.out.println("## : " + keyIdx + " : "+(ekeyIdx+textStart));
			ekeyIdx = arrPosition.get(0);
			
			//키워드 노출 여부 판단
			if(ekeyIdx > -1){//키워드가 2개인경우
				if(arrPosition.size() == 1){
					if(keyIdx < (ekeyIdx + textStart)){//키워드[0]가 앞에 노출되고 마지막 키워드가 뒤에 노출
						start = keyIdx;
						end  = ekeyIdx+textStart + key[key.length - 1].length();
					}else if(keyIdx > (ekeyIdx + textStart)){//키워드[0]이 뒤에 노출되고 마지막키워드가 앞에 노출
						start = ekeyIdx + textStart ;
						end  = keyIdx + key[0].length();
					}else{//그외
						start = keyIdx;
						end  = ekeyIdx+textStart + key[key.length - 1].length();
					}
				}else{//키워드가 2개 이상인경우
					start = keyIdx;
					end = keyIdx;
					int num = 1;
					for(int pos : arrPosition ){
						
						if(pos == -1){
							start = -1;
							end = -1;
							break;
						}
						
						if(start > (pos+textStart)){//첫번쨰 키워드가 노출된 위치보다 작을경우 스타트값 변경
							start = pos+textStart;
						}
						if(end < (pos+textStart + key[num].length())){//마지막 노출 위치 확인
							end = pos+textStart + key[num].length();
						}
						num++;
					}
					if(end == keyIdx){//마지막 노출위치가 첫번째 키워드라면 키워드의 길이만큼 길이 +
						end =  keyIdx + key[0].length();
					}
					
//					System.out.println("## start : " + start);
//					System.out.println("## end : " + end);
					
				}
			}
		} 
		
		if(start == -1 && end == -1) {
			return 0;
		} else {
			return 1;
		}
    }
	
	public static int nearSearchMatchCount(String text, String keywords[], int range) {
		
		
		int keywordCnt = StringUtil.countMatches(text, keywords[0], -1);
		int result = 0;
		
		if(keywords.length > 1) {
			
			for(int i = 0 ; i < keywordCnt ; i++) {
				result += SearchText.nearSearchPosition(text, keywords, range, i + 1);
			}
			
			return result;
		} else {
			return keywordCnt;
		}
    	
	}
	
}
