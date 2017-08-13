package WebAssess.domain;

import java.io.Serializable;


/**
 * @author gacl
 * 用户实体类
 */
public class User implements Serializable {

	private static final long seriaVersionUid = 1L;
	private String id;      
	private String username;     //账号
	private String userpass;
	private String usernick;     //昵称
	private String useridentity; //身份 
	private String age;
	private String sex;
	private String grade;
	private String direction;
	private String phone;
	private String email;
    //属性的get和set方法 
	public User(){
		
	}
	public User(String username,String userpass,String usernick,String useridentity,String age,String sex,String grade,String direction,String phone,String email){
		this.username = username;
		this.userpass = userpass;
		this.usernick = usernick;
		this.useridentity = useridentity;
		this.age = age;
		this.sex = sex;
		this.grade = grade;
		this.direction = direction;
		this.phone = phone;
		this.email = email;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
    public String getUsernick(){
    	return usernick;
    }
    public void setUsernick(String nick){
    	this.usernick=nick;
    }
    public String getUseridentity(){
    	return useridentity;
    }
    public void setUseridentity(String useridentity){
    	this.useridentity=useridentity;
    }
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
