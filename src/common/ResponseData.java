package common;

import java.util.Vector;

public class ResponseData {
	private String responseType;
	private Vector<String> response = new Vector<String>();
	
	public String getResponseType(){
		return this.responseType;
	}
	
	public Vector<String> getResponse(){
		return this.response;
	}
	
	public void setType(String type){
		this.responseType=type;
	}
	
	public void setResponse(Vector<String> data){
		this.response = data;
	}
}
