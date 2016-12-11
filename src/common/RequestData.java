package common;

import java.io.Serializable;
import java.util.Vector;
import java.io.Serializable;

import common.dataType;

/*<<<<<<< HEAD
public class RequestData implements Serializable{
=======*/
public class RequestData implements Serializable {

	private  dataType requestType;
	private Vector<String> request = new Vector<String>();
//	private byte[] requestPic = new byte[8192];
	
	public dataType getRequestType(){
		return this.requestType;
	}
	
	public Vector<String> getRequest(){
		return this.request;
	}
	
/*	public byte[] getRequestPic(){
		return this.requestPic;
	}*/
	
	public void setType(dataType type){
		this.requestType = type;
	}
	
	public void setRequest(Vector<String> data){
		this.request = data;
	}
	
/*	public void setRequestPic(byte[] pic){
		this.requestPic = pic;
	}*/
	
}
