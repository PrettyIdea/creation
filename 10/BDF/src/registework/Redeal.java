package registework;

import java.util.HashMap ;
import java.util.Map ;

public class Redeal {
	
	private String name ;
	private String password ;	
	private String real_name ;
	private String email;
	private String question;
	private String answer;
	
	
	private Map<String,String> errors = null ;
	public Redeal(){
		
		this.name = "" ;
		this.password = "" ;
		this.real_name = "" ;
		this.email = "" ;
		this.question = "" ;
		this.answer = "" ;
		
		this.errors = new HashMap<String,String>() ;
	}
	public boolean isValidate(){
		boolean flag = true ;
		if(!this.password.matches("\\d+")){
			flag = false ;
			this.password = "" ;	// 娓呯┖鍘熸湰鐨刵ame鍐呭
			this.errors.put("errage","骞撮緞鍙兘鏄暟瀛椼��") ;
		}
		
		if(!this.email.matches("\\w+@\\w+\\.\\w+\\.?\\w*")){
			flag = false ;
			this.email = "" ;	// 娓呯┖鍘熸湰鐨刵ame鍐呭
			this.errors.put("erremail","杈撳叆鐨別mail鍦板潃涓嶅悎娉曘��") ;
		}
		
		return flag ;
	}
	public String getErrorMsg(String key){
		String value = this.errors.get(key) ;
		return value==null?"":value ;
	}
	
	
	public void setName(String name){
		this.name = name ;
	}
	public void setPasswod(String password){
		this.password = password ;	
	}
	public void setReal_name(String real_name){
		this.real_name= real_name ;	
	}
	
	
	public void setEmail(String email){
		this.email = email ;
	}
	public void setQuestion(String question){
		this.question = question ;
	}
	public void setAnswer(String answer){
		this.answer = answer ;
	}
	
	public String getName(){
		return this.name ;
	}
	public String getpassword(){
		return this.password ;
		
	}
	public String getReal_name(){
		return this.real_name ;
	}
	
	
	public String getEmail(){
		return this.email ;
	}
	public String getQuestion(){
		return this.question ;
	}
	public String getanswer(){
		return this.answer ;
	}
	
	
	
}