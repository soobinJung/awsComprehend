package com.rsn.common.excutor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.rsn.common.util.DateUtil;
import com.rsn.common.util.TelegramUtil;

public abstract class ExcutorAbstract implements ExcutorJobTemplate {
	
	private static final Logger log = Logger.getRootLogger(); 
	
	private long startTime;
	private long firstStartTime;
	
	//시간 체크
	public long runtimeNow(){
		System.out.println("TimeChk : " + (System.currentTimeMillis() - startTime));
		return System.currentTimeMillis() - startTime;
	}
	
	public ExcutorAbstract() {
		//시작 로그
		log.info("##############" + this.getClass().getSimpleName() + " Start##############");
		log.info("###StartTime : " + new DateUtil().getString("yyyy-MM-dd hh:mm:ss"));
		//시작 시간 저장
		firstStartTime = System.currentTimeMillis();
	}
	
	public boolean execute(String phoneNum) {
		try {
			
			//프로세스 실행
			this.run();
			
			return true;
		} catch (Exception e) {
			
			String ipInfo = "none";
			try {
				ipInfo = "[" + InetAddress.getLocalHost().getHostName() + "]_" + InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e1) {
			}
			
			String msg = "[ 프로세스 에러 ]" 
					+ "\n시      간 : " + new DateUtil().getString("yyyy-MM-dd HH:mm:ss")
					+ "\n서      버 : " + ipInfo
					+ "\n프로젝트 : LucyAdmin" 
					+ "\n프로세스 : " + this.getClass().getName();
			TelegramUtil.sendMessege(msg, phoneNum);
			
			//에러 로그
			e.printStackTrace();
			log.error(e);
			log.error("##############" + this.getClass().getSimpleName() + " 예외 발생 작동 중지##############");
			
			return false;
		} finally {
			//종료 로그
			long runTime = System.currentTimeMillis() - firstStartTime;
			String runTimeS = (TimeUnit.MILLISECONDS.toMinutes(runTime) + "min ") + ((TimeUnit.MILLISECONDS.toSeconds(runTime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(runTime))) + "sec");
			log.info("###Runtime : " + runTimeS);
			log.info("###EndTime : " + new DateUtil().getString("yyyy-MM-dd HH:mm:ss"));
			log.info("##############" + this.getClass().getSimpleName() + " End##############");
		}
	}
}




