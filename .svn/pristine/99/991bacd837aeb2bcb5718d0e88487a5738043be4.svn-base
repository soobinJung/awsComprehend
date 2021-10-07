package com.rsn.def.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.rsn.common.preferences.ManagerMybatisConncetion;

public class DefaultDao {
	protected Logger log = Logger.getLogger(this.getClass());
	
	private SqlSession sqlSession;
	
	public DefaultDao() throws IOException {
		log.info("###### DBConnection Open");
		
		sqlSession = ManagerMybatisConncetion.getSqlSession("con1");
	}
	
}
