package com.rsn.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;


public class LinuxUtil {
	protected Logger log = Logger.getLogger(this.getClass());
	
	public String getHostName(){
		LinuxUtil lu = new LinuxUtil();
		String[] cmd = {"sh","-c","hostname"};
		String result = lu.getlinux(cmd);
		
		return result.split("\n")[1];
	}
	
	public String getlinux(String cmd){
		StringBuffer result = new StringBuffer();
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String cl = null;
		
		log.debug("cmd = " + cmd);
		try {
			p = rt.exec(cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while((cl = in.readLine()) != null){
				log.info(cl);
				result.append( cl + "\n");
			}
			
			cl = result.toString();
			cl = cl.replaceAll(" {1,80}", " ");
			
			in.close();
		} catch (IOException e) {
			 log.error(e);
		}
		return cl;
	}
	
	public String getlinux(String[] cmd){
		StringBuffer result = new StringBuffer();
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String cl = null;
		
		try {
			p = rt.exec(cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while((cl = in.readLine()) != null){
				result.append("\n" + cl);
			}
			
			cl = result.toString();
			cl = cl.replaceAll(" {1,80}", " ");
			
			in.close();
		} catch (IOException e) {
			 log.error(e);
		}
		return cl;
	}
	
	
	public String LinuxExecute(String cmd){
		StringBuffer result = new StringBuffer();
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String cl = null;
		
		log.debug("cmd = " + cmd);
		try {
			p = rt.exec(cmd);
		} catch (IOException e) {
			 log.error(e);
		}
		return cl;
	}

}

