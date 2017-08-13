package WebAssess.dao;

import java.util.List;

import WebAssess.domain.Apply;
import WebAssess.domain.Info;
import WebAssess.domain.Results;
import WebAssess.domain.User;

public interface IUserDao {
    
	/**
	 * 添加用户
	 * @param user
	 */
	void add(User user);
	
	//查找所有用户信息
    List findAll();
    
	/**
	 * 根据用户名和密码来查找用户
	 * @param username
	 * @param userpass
	 * @return 查到到的用户
	 */
	User find(String username, String userpass);

	

	/**根据用户名来查找用户
	 * @param username
	 * @return 查到到的用户
	 */

    User  find(String username);
     
    /**根据方向来查找用户
	 * @param direction
	 * @return 查找到的用户
	 */
    List find1(String direction);
    List find2(String useridentity);
     
    /**根据用户名来修改用户
	 * @param username
	 * @return 修改后的用户
	 */
    
    
   void update(String username,String usernick,String age,String sex,String grade,String direction,String phone,String email);
   
   /**根据用户名来设置用户身份
	 * @param username
	 * @return 修改后的用户
	 */
    void  update1(String username ,String useridentity);
    /**根据用户名来删除用户
   	 * @param username
   	 */
    void update2(String username,String userpass);
    void delete(String username);
    void add(Apply apply);
    List Applyall();
    void add(Info info);
    List Infoall();
    void add(Results results);
}
