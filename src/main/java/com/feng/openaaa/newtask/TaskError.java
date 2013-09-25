package com.feng.openaaa.newtask;


/**
 * 
 * @author fengyouchao
 *
 */
public class TaskError {
	
	private int number = 0;
	private String message = "";
	
	public TaskError(){
		
	}
	
	public TaskError(int number,String message ){
		this.number = number;
	}
	
	public TaskError(String message){
		this.message = message;
	}
	
	public TaskError(int number){
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
