package WebAssess.service.impl;

import WebAssess.dao.IUserDao;
import WebAssess.dao.impl.UserDaoImpl;
import WebAssess.domain.User;
import WebAssess.exception.UserExistException;
import WebAssess.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void registerUser(User user) throws UserExistException {
		if (userDao.find(user.getusername())!=null) {
			//checked exception 
			//unchecked exception
			//这里抛编译时异常的原因：是我想上一层程序处理这个异常，以给用户一个友好提示
			throw new UserExistException("注册的账户已存在！！！");
		}
		userDao.add(user);
	}
	@Override
	public User loginUser(String username, String userpass) {
		return userDao.find(username, userpass);
	}
	

	

}
