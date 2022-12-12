package Gameroom.Utility;

import java.io.Serializable;

public class DataDTO<T> implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private T data;
	private Info command;
	private String id;
	
	public DataDTO() {	}
	
	public Info getCommand(){
		return command;
	}
	public T getData(){
		return data;
	}
	public void setCommand(Info command){
		this.command= command;
	}
	public void setData(T data){
		this.data= data; 
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id= id;
	}
	
}