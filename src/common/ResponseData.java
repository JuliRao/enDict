package common;

import java.io.Serializable;
import java.util.Vector;

import common.dataType;

/*<<<<<<< HEAD
public class ResponseData implements Serializable{
=======*/
/**
 * 服务端向客户端的返回数据类
 * @author 周心萌
 *
 */
public class ResponseData implements Serializable {

//	private String responseType;
	private dataType responseType;
	private Vector<String> response = new Vector<String>();
//	private byte[] responsePic = new byte[8192];
	
	public dataType getResponseType(){
		return this.responseType;
	}
	
	public Vector<String> getResponse(){
		return this.response;
	}
	
/*	public byte[] getPicture(){
		return this.responsePic;
	}*/
	
	public void setType(dataType type){
		this.responseType=type;
	}
	
	public void setResponse(Vector<String> data){
		this.response = data;
	}

/*	public void setPicture(byte[] pic){
		this.responsePic = pic;
	}*/
}
