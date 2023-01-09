package com.ERP.mange.genric;


public interface IAutoConstants {
	/*
	 *In this interface we will store all file paths 
	 *In interface every variable is PUBLIC ,STATIC & FINAL by default
	 *In interface every method is abstract by default
	 */
	String USERDIR=System.getProperty("user.dir");
	String CREDNTIALSPATH=USERDIR+"/Data/Credentails.Properties";
	String EXCELPATH= "./Data/TestData.xlsx";
}
