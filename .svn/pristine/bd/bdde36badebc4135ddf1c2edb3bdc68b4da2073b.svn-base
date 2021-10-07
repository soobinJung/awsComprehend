package com.rsn.common.preferences;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
public class ManagerMybatisConncetion {
	
	private static final String RESOURCE_PATH = "com/rsn/common/config/myBatisConfig.xml";
	
	private static final String SQL_BASE = "classpath*:com/rsn/common/dbsql/**/*.xml";
    
	private final static Map<String, SqlSession> SESSION_MAP = new HashMap<>();
	
	/**
	 * 기본 Base Mapper 포함한 SqlSession
	 * @param env
	 * @return
	 * @throws IOException
	 */
    public static SqlSession getSqlSession(String env) throws IOException {
    	return getSqlSession(env, SQL_BASE);
    }
    
    /**
     * 지정한 Base Mapper 포함한 SqlSession
     * @param env
     * @param mapperPathPattern -> Mapper 폴더 Pattern
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession(String env, String mapperPathPattern) throws IOException {
    	
    	Reader mbConfigReader = Resources.getResourceAsReader(RESOURCE_PATH);
    	
    	SqlSession session = SESSION_MAP.get("env");
    	if(session == null) {
    		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(mbConfigReader, env);
    		session = sf.openSession(true);
    		
    		Configuration configuration = session.getConfiguration();
    		
    		Resource[] xmlResouces = getPatternToResources(mapperPathPattern);
    		
    		int idx = 0;
    		
    		for(Resource resource : xmlResouces) {
    			
    			InputStream in = resource.getInputStream();
    			
    			try {
    				XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(in, configuration, String.valueOf(idx), configuration.getSqlFragments());
    				xmlMapperBuilder.parse();
    			} finally {
    				in.close();
    			}
    			
    			idx++;
    		}
    		
    		SESSION_MAP.put(env, session);
    	}
    	return session;
    }
    
    /**
     * dirPath의 하위에 Mapper 파일 Stream 가져오기
     * @param pattern
     * @return
     */
    public static Resource[] getPatternToResources(String pattern) {
    	ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
    	try {
			return patternResolver.getResources(pattern);
		} catch (IOException e) {
			return null;
		}
    }
    
}

