package common;

import java.util.Vector;
import common.dataType;

public class ResponseData {
//	private String responseType;
	private dataType responseType;
	private Vector<String> response = new Vector<String>();
	
	public dataType getResponseType(){
		return this.responseType;
	}
	
	public Vector<String> getResponse(){
		return this.response;
	}
	
	public void setType(dataType type){
		this.responseType=type;
	}
	
	public void setResponse(Vector<String> data){
		this.response = data;
	}
}
