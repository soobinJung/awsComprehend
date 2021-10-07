package com.rsn.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileUtil {

	private static Logger log = Logger.getLogger(FileUtil.class);
	

	/**
	 * 파일 삭제
	 * @param filePath
	 */
	public static final void deleteFile(String filePath){
		if(log.isDebugEnabled()){
			log.debug("delete file : "+filePath);
		}
		File file = new File(filePath);
		if(file.isFile()){
			if(file.delete()){
				log.info("delete completed :"+filePath);
			}
		}
	}
	/**
	 * 특정 파일 가져오기
	 * @param fileName
	 * @return
	 */
	public static File getFile(String fileName){
		File file = new File(fileName);
		if(file.isFile()){
			return file;
		}else{
			return null;
		}
	}
	/**
	 * 파일 확장자 가져오기 ('.'포함)
	 * @param file_nm
	 * @return String '.'포함한 파일 확장자
	 */
	public static final String getExtsn(String file_nm){
		if(file_nm == null) return "";
		
		return file_nm.substring(file_nm.lastIndexOf("."));
	}
	
	/**
	 * 해당 path 의 하위 요소(디렉토리,파일)를 가져온다.
	 * @param path
	 * @return File집합
	 */
	public static File[] getFileList(String path){
		File dir = null;
		File[] list = null;
		if(path != null){
			dir = new File(path);
			
			if(dir.isDirectory()){
				list = dir.listFiles();
			}
		}
		return list;
	}
	
	/**
	 * 해당 path 의 특정 확장자의 파일목록을 가져온다.
	 * @param path
	 * @param extension
	 * @return File집합
	 */
	public static File[] getFileList(String path, String extension){
		String[] exts = {extension};
		return getFileList(path, exts);
	}
	
	/**
	 * 해당 path 의 특정 확장자들의 파일목록을 가져온다.
	 * @param path
	 * @param extensions
	 * @return File집합
	 */
	public static File[] getFileList(String path, String[] extensions){
		File dir = null;
		File[] list = null;
		if(path != null){
			dir = new File(path);
			
			if(dir.isDirectory()){
				list = dir.listFiles(new FileNameFilterImpl(extensions));
			}
		}
		return list;
	}


	
	/**
	 * 해당 baseDir 하위의 디렉토리 목록을 가져온다. 
	 * @param baseDir
	 * @return File(Directory)집합
	 */
	public static List<File> getFileDirectoryList(File baseDir) {
        final List<File> dirList = new ArrayList<File>();
        
        final File[] fileArray = baseDir.listFiles();
        for (int i = 0; i < fileArray.length; i++) {
	        if (fileArray[i].isDirectory()) {
	        	dirList.add(fileArray[i]);
	        }
        }
        return dirList;
	}
	
	/**
	 * 해당 baseDir 하위의 파일목록을 가져온다. 하위 디렉토리에 있는 파일목록을 재귀호출로 모두 가져온다.
	 * @param baseDir
	 * @return File집합
	 */
	public static List<File> getFileListRecursively(File baseDir) {
        final List<File> fileList = new ArrayList<File>();
        getFileListRecursively(baseDir, fileList);
        return fileList;
    }
    private static void getFileListRecursively(File baseDir, List<File> fileList) {
        if (!baseDir.isDirectory()) {
            return;
        }

        final File[] fileArray = baseDir.listFiles();

        if (fileArray == null || fileArray.length == 0) {
            return;
        }

        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].isDirectory()) {
                getFileListRecursively(fileArray[i], fileList); // recurse
            } else if (fileArray[i].isFile()) {
                fileList.add(fileArray[i]);
            }
        }
    }
    
}
