package com.rsn.common.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Hashtable;

/**
 * 
 * Created on 2009. 4. 30.
 * @author Ryu Seung Wan
 */
public class FileNameFilterImpl implements FilenameFilter {

	private Hashtable filters = new Hashtable();//확장자 검색
	private String filter = null;//파일명 검사.

	public FileNameFilterImpl() {
		super();
		
	}
	
	public FileNameFilterImpl(String filter) {
		this(null, filter);
	}
	
	public FileNameFilterImpl(String[] extensions) {
		this(extensions, null);
	}
	
	public FileNameFilterImpl(String[] extensions, String filter) {
		this();
		if(extensions != null)
			for(int i=0; i < extensions.length; i++)
				addExtension(extensions[i]);
		if(filter != null)
			this.filter = filter;
	}

	public boolean accept(File dir, String name) {
		boolean result = true;
		if(filters.size()>0)
			result = filters.containsKey(getExtension(name));
		
		if(filter != null){
			result =  result && (name.indexOf(filter) > 0);
		}
		//System.out.println(name);
	    return result;
	}
	
	public String getExtension(String filename) {
		if(filename != null) {

		    int i = filename.lastIndexOf('.');
		    if(i>0 && i<filename.length()-1) {
		    	return filename.substring(i+1).toLowerCase();
		    };
		}
		return "";
	}
	    
	public void addExtension(String extension) {
		if(filters == null) {
		    filters = new Hashtable();
		}
		filters.put(extension.toLowerCase(), "");
	}
}
