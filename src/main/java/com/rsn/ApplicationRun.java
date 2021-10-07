package com.rsn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.xml.sax.SAXException;

import com.rsn.common.excutor.ExcutorAbstract;


public class ApplicationRun {
	
	private static final String APP_PROP_PATH = "/com/rsn/common/config/application.properties";
	
	private static final Logger LOG = Logger.getRootLogger();
	
	private final Properties appConfigProp;
	
	public ApplicationRun() throws IOException {
		appConfigProp = new Properties();
		
		appConfigProp.load(this.getClass().getResourceAsStream(APP_PROP_PATH));
	}
	
	
	public void starter(String[] args) throws IOException {
		if(args.length < 2) {
			LOG.error("다음 변수가 필요합니다. : [phoneNumber, packageAndClass]");
			return;
		}
		
		//입력 변수
		String phoneNumber = args[0];
		String packageAndClass = args[1];
		
		//리눅스일경우 프로세스 1개 실행 체크
		if(!validLiunuxProcessRunning(packageAndClass)) {
			LOG.info("이미 프로세스가 동작 중입니다.");
			return;
		}
		
		try {
			
			//log4j root 로그 appender 추가
			addLog4jRootLogAppender(packageAndClass);
			
			@SuppressWarnings("unchecked")
			Class<ExcutorAbstract> cls = (Class<ExcutorAbstract>) Class.forName(packageAndClass);
			
			//excute 실행
			cls.newInstance().execute(phoneNumber);
		} catch (ClassNotFoundException e) {
			LOG.info("입력한 핸드폰 번호와 packageClass를 확인하세요. : [phoneNumber, packageAndClass] => " + Arrays.toString(args));
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("에러발생! : " + Arrays.toString(args));
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		new ApplicationRun().starter(args);
	}
	
	/**
	 * Root 로그 Appender 추가
	 * @param packageAndClass
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	private void addLog4jRootLogAppender(String packageAndClass) throws SAXException, IOException, ParserConfigurationException {
		
		Logger rootLogger = Logger.getRootLogger();

		Layout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} [%-5p](%-35C:%-3L) %m%n");
		
		String logDirPath = appConfigProp.getProperty("log_dir") + "/";
		String fildPath = logDirPath + packageAndClass + ".log";
		Appender dailyAppender = new DailyRollingFileAppender(layout, fildPath, "'.'yyyy-MM-dd'.log'");
		
		rootLogger.addAppender(dailyAppender);
	}
	
	/**
	 * 리눅스내 프로세스 동작 여부 확인
	 * ps -ef | grep java | grep -v grep | grep 패키지and클래스명
	 * @param packageAndClass
	 * @return
	 * @throws IOException
	 */
	private boolean validLiunuxProcessRunning(String packageAndClass) throws IOException {
		String os = System.getProperty("os.name").toLowerCase();
		if(os.indexOf("nux") > -1) {
			String grepCommand = "ps -ef | grep java | grep -v grep | grep " + packageAndClass;
			
			Process processChecker = Runtime.getRuntime().exec(new String[] {"sh", "-c", grepCommand});
			BufferedReader input = new BufferedReader(new InputStreamReader(processChecker.getInputStream()));
			
			int processCnt = 0;
			while(input.readLine() != null) {
				processCnt++;
			}
			
			if(processCnt > 1) {
				return false;
			}
		}
		
		 return true;
	}
	
	
}



