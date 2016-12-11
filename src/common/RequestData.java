package common;

import java.util.Vector;

import common.dataType;

public class RequestData {
	private  dataType requestType;
	private Vector<String> request = new Vector<String>();
	
	public dataType getRequestType(){
		return this.requestType;
	}
	
	public Vector<String> getRequest(){
		return this.request;
	}
	
	public void setType(dataType type){
		this.requestType = type;
	}
	
	public void setRequest(Vector<String> data){
		this.request = data;
	}
	
}
