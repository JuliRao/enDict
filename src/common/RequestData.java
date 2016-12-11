package common;

import java.util.Vector;

public class RequestData {
	private String requestType;
	private Vector<String> request = new Vector<String>();
	
	public String getRequestType(){
		return this.requestType;
	}
	
	public Vector<String> getRequest(){
		return this.request;
	}
	
	public void setType(String type){
		this.requestType = type;
	}
	
	public void setRequest(Vector<String> data){
		this.request = data;
	}
	
}
