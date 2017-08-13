package WebAssess.service;

import WebAssess.domain.User;
import WebAssess.exception.UserExistException;

public interface IUserService {

	/**
	 * 提供注册服务
	 * @param user
	 * @throws UserExistException
	 */
	void registerUser(User user) throws UserExistException;
    
	/**
	 * 提供登录服务
	 * @param username
	 * @param userpass
	 * @return
	 */ 
	/*void loginUser(User user) throws UserExistException;*/
	
	User loginUser(String username, String userpass);
	/*User findAllUser();
	void updateUser(String username);
	void deleteUser(String username);
    void setidentity(String username,String useridentity);*/
}
