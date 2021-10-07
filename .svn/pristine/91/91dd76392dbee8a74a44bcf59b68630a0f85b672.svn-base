package com.rsn.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private Calendar cldr;
	private int thisYear, today, thisMonth;

	/**
	 * <p>생성자 <br>
	 * 시스템의 오늘 날짜로 Calendar 인스턴스를 생성한다.</p>
	 */
	public DateUtil() {
		cldr = Calendar.getInstance();
		thisYear = cldr.get(Calendar.YEAR);
		today = cldr.get(Calendar.DAY_OF_MONTH);
		thisMonth = cldr.get(Calendar.MONTH)+1;
	}
	
	public DateUtil(String date, String pattern) throws ParseException {
		cldr = Calendar.getInstance();
		thisYear = cldr.get(Calendar.YEAR);
		today = cldr.get(Calendar.DAY_OF_MONTH);
		thisMonth = cldr.get(Calendar.MONTH)+1;
		
		this.setYMD(date, pattern);
	}
	

	/**
	 * <p>생성된 년도를 반환한다.</p>
	 * @return 설정된 년도.
	 */
	public int getYear()
	{
		return cldr.get(Calendar.YEAR);
	}

	/**
	 * <p>생성된 월을 반환한다.</p>
	 * @return 설정된 월.
	 */
	public int getMonth()
	{
		return cldr.get(Calendar.MONTH)+1;
	}

	/**
	 * <p>생성된 일자를 반환한다.</p>
	 * @return 설정된 일자.
	 */
	public int getDay(){
		return cldr.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * <p>주어진 month로 생성된 월을 갱신한다. </p>
	 * @param month
	 */
	public void setMonthVal(int month)
	{
		cldr.add(Calendar.MONTH, month-getMonth());
	}

	/**
	 * <p>주어진 month만큼 월을 더한다. </p>
	 * @param month 
	 */
	public void addMonth(int month){
		cldr.add(Calendar.MONTH, month);

	}

	/**
	 * <p>주어진 year로 생성된 년도를 갱신한다.</p>
	 * @param year
	 */
	public void setYearVal(int year)
	{
		cldr.add(Calendar.YEAR, year-getYear());
	}

	/**
	 * <p>주어진 year만큼 년도를 더한다. </p>
	 * @param year
	 */
	public void addYear(int year){
		cldr.add(Calendar.YEAR, year);
	}

	/**
	 * <p>주어진 day로 생성된 날짜를 갱신한다.</p>
	 * @param day
	 */
	public void setDayVal(int day){
		cldr.add(Calendar.DAY_OF_MONTH, day-getDay());
	}

	/**
	 * <p>주어진 day만큼 일자를 더한다. </p>
	 * @param day
	 */
	public void addDay(int day){
		cldr.add(Calendar.DAY_OF_MONTH, day);
	}
	
	/**
	 * <p>주어진 day만큼 일자를 더한다. </p>
	 * @param day
	 */
	public void addMinute(int minute){
		cldr.add(Calendar.MINUTE, minute);
	}
	
	/**
	 * <p>주어진 day만큼 일자를 더한다. </p>
	 * @param day
	 */
	public void addWeek(int week){
		cldr.add(Calendar.WEEK_OF_YEAR, week);
	}

	/**
	 * <p>주어진 date(문자열)로 날짜를 갱신한다.<br>
	 * parrern은 param date의 날짜 포맷을 지정한다.<br><br>
	 * 
	 * 사용 예 : setYMD("2009-05-15", "yyyy-MM-dd");</p>
	 * 
	 * @param date
	 * @param pattern 
	 * @throws ParseException
	 */
	public void setYMD(String date, String pattern)throws ParseException{
		SimpleDateFormat fommatter = new SimpleDateFormat(pattern);//yyyy-MM-dd
		
		cldr.setTime(fommatter.parse(date));
	}

	/**
	 * <p>첫번째 요일의 날짜를 반환한다. DAY_OF_WEEK</p> 
	 * @return 첫번째 요일의 날짜
	 */
	public int getFirstDay()
	{
		cldr.set(Calendar.DAY_OF_MONTH, 1);
		return cldr.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * <p>현재 월의 마지막 날짜를 반환한다. DAY_OF_MONTH</p> 
	 * @return 월의 마지막 날짜
	 */
	public int getLastDate()
	{
		return cldr.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * <p>현재 일자의 요일을 반환한다. (일요일:1 ~ 토요일:7).</p> 
	 * @return 일요일:1 ~ 토요일:7
	 */
	public int getDayOfWeek(){

		return cldr.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * <p>현재 일자의 요일을 반환한다. </p> 
	 * @return 일요일 ~ 토요일
	 */
	public String getDayOfWeek2(int DayOfWeek){
		String dayofweek = "";
		if(DayOfWeek == 1){
			dayofweek ="일"; 
		}else if(DayOfWeek == 2){
			dayofweek ="월";
		}else if(DayOfWeek == 3){
			dayofweek ="화";
		}else if(DayOfWeek == 4){
			dayofweek ="수";
		}else if(DayOfWeek == 5){
			dayofweek ="목";
		}else if(DayOfWeek == 6){
			dayofweek ="금";
		}else if(DayOfWeek == 7){
			dayofweek ="토";
		}
		return dayofweek;
	}
	/**
	 * <p>현재 월에서 주어진 day의 요일을 반환한다. (일요일:1 ~ 토요일:7).</p>
	 * @param day
	 * @return 일요일:1 ~ 토요일:7
	 */
	public int getDayOfWeek(int day){
		cldr.set(Calendar.DAY_OF_MONTH, day);
		return getDayOfWeek();
	}

	/**
	 * <p>현재 인스턴스의 Calendar객체에 설정된 일자를 yyyy-MM-dd패턴으로 반환한다.</p>
	 * @return
	 */
	public String getString(){
		return getString("yyyy-MM-dd");
	}

	/**
	 * <p>현재 인스턴스의 Calendar객체에 설정된 일자를 주어진 패턴으로 반환한다.</p>
	 * @param pattern
	 * @return
	 */
	public String getString(String pattern){
		SimpleDateFormat fommatter = new SimpleDateFormat(pattern);
		return fommatter.format(cldr.getTime());
	}
	
	/**
	 * 현재 인스턴스의 년도 주차를 반환
	 * @return yearWeek
	 */
	public int getYearWeek() {
		
		return cldr.get(Calendar.WEEK_OF_YEAR);
	}
	

	/**
	 * <p>현재 일자를 yyyy-MM-dd패턴으로 반환한다.</p>
	 * @return
	 */
	public static String getCurrentDate(){
		return getCurrentDate("yyyy-MM-dd");
	}

	/**
	 * <p>현재 일자를 주어진 패턴으로 반환한다.</p>
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern){
		Date d =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}



	/**
	 * <p>오늘일자로 초기화한다.</p>
	 */
	public void initToday(){
		cldr.set(thisYear, thisMonth-1, today);
	}

	/**
	 * <p>현재시간의 millisec을 반환한다.</p>
	 * @return 현재시간 millisec
	 */
	public long getMilliseconds(){
		return cldr.getTimeInMillis();
	}

	/**
	 * <p>현재시간과 주어진 종료시간과의 차이를 반환한다.</p>
	 * @param (DateUtil)endDate
	 * @return 차이에 대한 millisec
	 */
	public long getElapsedTime(DateUtil endDate){
		return endDate.getMilliseconds() - getMilliseconds();
	}

	/**
	 * <p>기준일자(yyyyMMdd)의 1년전 기준일자를 반환한다.</p>
	 * @param yyyyMMdd
	 * @return 1년전 기준일자
	 * @throws ParseException
	 */
	public static final String getLastYearBsl(String yyyyMMdd)throws ParseException{
		DateUtil trdt = new DateUtil();
		trdt.setYMD(yyyyMMdd, "yyyyMMdd");
		trdt.addYear(-1);
		return trdt.getString("yyyyMMdd");
	}

	/**
	 * <p>기준일자(yyyyMMdd)의 주어진 mon월 기준일자를 반환한다.</p>
	 * @param yyyyMMdd
	 * @param mon
	 * @return mon월 기준일자
	 * @throws ParseException
	 */
	public static final String getLastMonthBsl(String yyyyMMdd, int mon)throws ParseException{
		DateUtil trdt = new DateUtil();
		trdt.setYMD(yyyyMMdd, "yyyyMMdd");
		trdt.addMonth(mon);
		return trdt.getString("yyyyMMdd");
	}

	/**
	 * 기준일자(yyyyMMdd)의 주어진 day일 기준일자를 반환한다.</p>
	 * @param yyyyMMdd
	 * @param day
	 * @return day일 기준일자
	 * @throws ParseException
	 */
	public static final String getLastDayBsl(String yyyyMMdd, int day)throws ParseException{
		DateUtil trdt = new DateUtil();
		trdt.setYMD(yyyyMMdd, "yyyyMMdd");
		trdt.addDay(day);
		return trdt.getString("yyyyMMdd");
	}

	/**
	 * pattern1 포멧의 yyyyMMdd를 pattern2 포멧으로 변환하여 반환한다.</p>
	 * 사용 예) <br>
	 * ("2009-05-03", "yyyy-MM-dd", "yyyy/MM/dd") => 2009/05/03<br>
	 * ("20090503123030", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm") => 2009-05-03 12:30
	 * @param yyyyMMdd
	 * @param pattern1
	 * @param pattern2
	 * @return
	 * @throws ParseException
	 */
	public static final String formatDate(String yyyyMMdd, String pattern1, String pattern2) throws ParseException{
		SimpleDateFormat fommatter = new SimpleDateFormat(pattern2);

		return fommatter.format(getDate(yyyyMMdd,pattern1));
	}

	/**
	 * 주어진 yyyyMMdd를 주어진 pattern 으로 포맷을 변경하여 반환한다.</p>
	 * @param yyyyMMdd
	 * @param pattern
	 * @return 포맷이 적용된 날짜 문자열
	 * @throws ParseException
	 */
	public static final String formatDate(Date yyyyMMdd, String pattern) throws ParseException{
		SimpleDateFormat fommatter = new SimpleDateFormat(pattern);

		return fommatter.format(yyyyMMdd);
	}

	/**
	 * <p>주어진 yyyyMMdd를 주어진 pattern 으로 포맷을 변경하여 반환한다.</p>
	 * @param yyyyMMdd
	 * @param pattern
	 * @return 포맷이 적용된 날짜 문자열
	 * @throws ParseException
	 */
	public static final String formatDate(String yyyyMMdd, String pattern) throws ParseException{
		SimpleDateFormat fommatter = new SimpleDateFormat(pattern);

		return fommatter.format(getDate(yyyyMMdd));
	}

	private static final Date getDate(String yyyyMMdd, String pattern) throws ParseException{
		return new SimpleDateFormat(pattern).parse(yyyyMMdd); 
	}

	private static final Date getDate(String yyyyMMdd) throws ParseException{
		return getDate(yyyyMMdd, "yyyyMMdd"); 
	}

	//타임스템프 >> 일반날짜
	public static String TimeStamp(String stime, String type){
		String temp_intime ="";
		String temp_sintime ="";
		long l_instime = 0;
		SimpleDateFormat fommatter = new SimpleDateFormat(type);

		temp_sintime = String.valueOf((stime));
		l_instime    = Long.parseLong(temp_sintime);

		Date in_stime = new Date(l_instime*1000L);

		temp_intime = fommatter.format(in_stime);
		return temp_intime;
	}

	//String date : yyyy-mm-dd
	//일반날짜 >> 타임스템프 00시 00분 00초
	public static String fullSUnixTime(String date){
		String strDate = date.replaceAll("-",""); 
		Calendar cldr = Calendar.getInstance();
		
		
		cldr.set(
				Integer.parseInt(strDate.substring(0, 4)), //년
				Integer.parseInt(strDate.substring(4, 6))-1,  //월
				Integer.parseInt(strDate.substring(6, 8)),    //일
				Integer.parseInt(strDate.substring(8, 10)),   //시 
				Integer.parseInt(strDate.substring(10, 12)),  //분
				Integer.parseInt(strDate.substring(12, 14))   //초
		); 
		strDate = String.valueOf(cldr.getTimeInMillis()).substring(0, 10);
		return strDate;
	}
	
	 public static long fullSUnixTime2(String date){
		  String strDate = date.replaceAll("-",""); 
		  strDate = strDate.replaceAll(":","");
		  strDate = strDate.replaceAll(" ","");
		  
		  Calendar cldr = Calendar.getInstance();
		  cldr.set(
		    Integer.parseInt(strDate.substring(0, 4)), //년
		    Integer.parseInt(strDate.substring(4, 6))-1,  //월
		    Integer.parseInt(strDate.substring(6, 8)),    //일
		    Integer.parseInt(strDate.substring(8, 10)),   //시 
		    Integer.parseInt(strDate.substring(10, 12)),  //분
		    Integer.parseInt(strDate.substring(12, 14))   //초
		  ); 
		  return cldr.getTimeInMillis();
	 }
	 
	 public static long fullSUnixTime3(String date){
		  String strDate = date.replaceAll("-",""); 
		  strDate = strDate.replaceAll(":","");
		  strDate = strDate.replaceAll(" ","");
		  
		  Calendar cldr = Calendar.getInstance();
		  cldr.set(
		    Integer.parseInt(strDate.substring(0, 4)), //년
		    Integer.parseInt(strDate.substring(4, 6))-1,  //월
		    Integer.parseInt(strDate.substring(6, 8))    //일
		  ); 
		  return cldr.getTimeInMillis();
	 }
	 
	 public long getTimeStamp(){
		 String millis = String.valueOf(cldr.getTimeInMillis());
		 return Long.parseLong(millis.substring(0, millis.length() - 3));
	 }

	//String date : yyyy-mm-dd
	//일반날짜 >> 타임스템프 00시 00분 00초
	public static String getSUnixTime(String date){
		String strDate = date.replaceAll("-",""); 
		Calendar cldr = Calendar.getInstance();  
		cldr.set(
				Integer.parseInt(strDate.substring(0, 4)), //년
				Integer.parseInt(strDate.substring(4, 6))-1,  //월
				Integer.parseInt(strDate.substring(6, 8)),    //일
				0,  //시 
				0,  //분
				0); //초
		strDate = String.valueOf(cldr.getTimeInMillis()).substring(0, 10);
		return strDate;
	}

	//String date : yyyy-mm-dd
	//일반날짜 >> 타임스템프 11시 59분 59초
	public static String getEUnixTime(String date){
		String strDate = date.replaceAll("-",""); 
		Calendar cldr = Calendar.getInstance();  
		cldr.set(
				Integer.parseInt(strDate.substring(0, 4)), //년
				Integer.parseInt(strDate.substring(4, 6))-1,  //월
				Integer.parseInt(strDate.substring(6, 8)),    //일
				23,  //시 
				59,  //분
				59); //초
		strDate = String.valueOf(cldr.getTimeInMillis()).substring(0, 10);

		return strDate;
	}

	public String gisDate(String date) throws ParseException{
		setYMD(date, "yyyyMMdd");

		return getString("yy/MM/dd");
	}


	public String gisTime(String time)throws ParseException{
		setYMD(time, "HHmmss");

		return getString("HH:mm");
	}

	/**
	 * 날짜 차이 계산
	 * @return yyyymm
	 * @throws ParseException 
	 */
	public static long DateDiff(String sDate, String eDate, String Pformat) throws ParseException {
		long result ;
		SimpleDateFormat fmt = new SimpleDateFormat(Pformat);

		Date mSdate = fmt.parse(sDate);
		Date mEdate = fmt.parse(eDate);
		result = (mSdate.getTime() - mEdate.getTime()) / (1000 * 60 * 60 * 24);

		return result ;

	}
	
	/**
	 * 주어진 기간의 이전 기간을 반환
	 * @param eDate
	 * @param sDate
	 * @param Pformat
	 * @return
	 * @throws Exception
	 */
	public String DateDiffValue(String eDate, String sDate, String Pformat) throws Exception {
		long result = DateDiff(eDate, sDate, Pformat);
		
		DateUtil du = new DateUtil();
		du.setYMD(sDate, "yyyyMMdd");
		du.addDay(-1);
		String edate = du.getString("yyyyMMdd");
		du.addDay(-(int)result);
		String sdate = du.getString("yyyyMMdd");
		
		return sdate+","+edate;
	}
	
	
	/**
	 * 보내온 dateString에 day만큼 날짜를 더해서 return
	 * @param dateString
	 * @param day
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String addDay(String dateString, int day, String format) throws Exception{
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(fmt.parse(dateString));
		
		dateCal.add(Calendar.DAY_OF_MONTH, day);
		
		return fmt.format(dateCal.getTime());
	}
	
	/**
	 * 보내온 dateString에 Year만큼 날짜를 더해서 return
	 * @param dateString
	 * @param year
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String addYear(String dateString, int year, String format) throws Exception{
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(fmt.parse(dateString));
		
		dateCal.add(Calendar.YEAR, year);
		
		return fmt.format(dateCal.getTime());
	}
	// 시스템 밀리세컨단위 => 시:분:초 
	public static String millisToStringTime(long time){
		int num = (int)(time/1000);
		int hour = num / 3600;
		int minute = num % 3600 / 60;
		int second = num % 3600 % 60;
			 
		String sHour = String.valueOf(hour).length()<2 ? "0"+hour : String.valueOf(hour);
		String sMin = String.valueOf(minute).length()<2 ? "0"+minute : String.valueOf(minute);
		String sSec = String.valueOf(second).length()<2 ? "0"+second : String.valueOf(second);
			 
		return sHour+":"+sMin+":"+sSec;
	 }
	
	 public static String dateToTimeStamp(String date, String format) throws ParseException {
		 Calendar cal = Calendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat(format);
		 cal.setTime(sdf.parse(date));
		 
		 String timestamp = String.valueOf(cal.getTimeInMillis());
		 return timestamp.substring(0, timestamp.length() - 3);
	 }
	
	 /**
	 * 주차의 날짜 범위 yyyy-MM-dd ~ yyyy-MM-dd
	 * @param yearWeek
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ParseException
	 */
	public static String parseYearWeekToDate(String yearWeek) throws ParseException {
		String[] dateInfo = yearWeek.split("_W");
					
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		cal.setTime(sdf.parse(dateInfo[0] + "-01-01"));
		
		int week = Integer.parseInt(dateInfo[1]);
		
		//1일 + 2주차 일요일 Date + (주차 - 2 * 7) 
		int weekDate =  1 + (7 - cal.get(Calendar.DAY_OF_WEEK) + 1) + ((week - 2) * 7);
		
		cal.set(Calendar.DATE, weekDate);
		
		String sdate = sdf.format(cal.getTime()); 
		
		cal.add(Calendar.DATE, 6);
		String edate = sdf.format(cal.getTime()); 
		
		return sdate + " ~ " + edate;
	 }
	 
	 /**
	 * 주차의 날짜 범위 yyyy-MM-dd ~ yyyy-MM-dd
	 * @param yearWeek(yyyy_ww)
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ParseException
	 */
	public static String parseYearWeekToDate(String yearWeek, String sdate, String edate) throws ParseException {
		
		sdate = parseDateFormat(sdate);
		edate = parseDateFormat(edate);
		
		String[] yearWeeks = yearWeek.split("_");
			
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		cal.setTime(sdf.parse(yearWeeks[0] + "-01-01"));
		
		//1일 + 2주차 일요일 Date + (주차 - 2 * 7) 
		int weekDate =  1 + (7 - cal.get(Calendar.DAY_OF_WEEK) + 1) + ((Integer.parseInt(yearWeeks[1]) - 2) * 7);
		
		cal.set(Calendar.DATE, weekDate);
		
		//비교 대상이 작으면 1, 크면  -1
		if(cal.getTime().compareTo(sdf.parse(sdate)) == 1) {
			sdate = sdf.format(cal.getTime()); 
		}
		
		cal.add(Calendar.DATE, 6);
		if(cal.getTime().compareTo(sdf.parse(edate)) == -1) {
			edate = sdf.format(cal.getTime()); 
		}
		
		return sdate + " ~ " + edate;
	}
	
	private static String parseDateFormat(String date) {
		date = date.replaceAll("-", "");
		if(date.length() != 8) {
			throw new RuntimeException("변환이 불가능한 Date");
		}
		
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
	}
		
	/**
	 * 월의 날짜 범위 yyyy-MM-dd ~ yyyy-MM-dd
	 * @param yearMonth
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ParseException
	 */
	public static String parseYearMonthToDate(String yearMonth) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		cal.setTime(sdf.parse(yearMonth + "01"));
		sdf.applyPattern("yyyy-MM-dd");
		
		
		String sdate = sdf.format(cal.getTime()); 
		
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		
		String edate = sdf.format(cal.getTime()); 
		
		return sdate + " ~ " + edate;
	}
	
	/**
	 * 월의 날짜 범위 yyyy-MM-dd ~ yyyy-MM-dd
	 * @param yearMonth
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ParseException
	 */
	public static String parseYearMonthToDate(String yearMonth, String sdate, String edate) throws ParseException {
		
		sdate = parseDateFormat(sdate);
		edate = parseDateFormat(edate);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		cal.setTime(sdf.parse(yearMonth + "01"));
		sdf.applyPattern("yyyy-MM-dd");
		
		
		//비교 대상이 작으면 1, 크면  -1
		if(cal.getTime().compareTo(sdf.parse(sdate)) == 1) {
			sdate = sdf.format(cal.getTime()); 
		}
		
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		
		if(cal.getTime().compareTo(sdf.parse(edate)) == -1) {
			edate = sdf.format(cal.getTime()); 
		}
		
		return sdate + " ~ " + edate;
	}
}