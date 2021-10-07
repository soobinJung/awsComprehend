package com.rsn;

public class test {
	public static void main(String[] args) {
		try {
			
//			new ApplicationRun().setLogProp("com.rsn.def.job.DefaultJob");
			new ApplicationRun().main(new String[]{"010-8854-0558", "com.rsn.def.job.DefaultJob"});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
