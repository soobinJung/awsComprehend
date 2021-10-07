package com.rsn.def.job;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.rsn.common.excutor.ExcutorAbstract;
import com.rsn.def.dao.DefaultDao;

public class DefaultJob extends ExcutorAbstract {
	
	private static final Logger log = Logger.getRootLogger();
	
	private DefaultDao dao;
	public DefaultJob() throws RuntimeException {
		try {
			dao = new DefaultDao();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void run() throws Exception {
		log.info("실행 클래스의 로그~!~!~!");
		System.out.println("Hello~");
	}
	
	public static void main(String[] args) {
		DefaultJob job = new DefaultJob();
		job.execute("010-8854-0558");
	}

}
