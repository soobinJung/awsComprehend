package com.rsn.def.aws;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.rsn.common.excutor.ExcutorAbstract;
import com.rsn.def.dao.DefaultDao;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;

public class Comprehend extends ExcutorAbstract {
	
	private static final Logger log = Logger.getRootLogger();
	
	private DefaultDao dao;
	public Comprehend() throws RuntimeException {
		try {
			dao = new DefaultDao();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void run() throws Exception {
		
        try {
        	
        	String text = "HAPPY";

            AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
     
            AmazonComprehend comprehendClient =AmazonComprehendClientBuilder.standard()
                                                                            .withCredentials(awsCreds)
                                                                            .withRegion("us-west-2")
                                                                            .build();
                                             
            DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
                                                                                        .withLanguageCode("en");
            
           
            DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
            
            System.out.println("=========================");
            System.out.println(detectSentimentResult);
            System.out.println("=========================");
            
            
            
		} catch (Exception e) {
		
			System.out.println("=========ERROR==========");
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		Comprehend job = new Comprehend();
		job.execute("010-8478-6861");
	}

}
