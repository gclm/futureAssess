package WebAssess.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    /*
    static {
        DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
    }
    */
    private Properties daoConfig = new Properties();

    private DaoFactory() {
        InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
        try {
            daoConfig.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static DaoFactory instance = new DaoFactory();
    public static DaoFactory getInstance() {
        return instance;
    }

    //                      UserDao.class(接口类型)
    //                      DepartmentDao.class(接口类型)   
    public <T> T createDao(Class<T> clazz) {

        // clazz.getName(); // 返回UserDao接口的完整名称：cn.itcast.dao.UserDao
        String name = clazz.getSimpleName(); // 返回UserDao接口的简单名称：UserDao

        // DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");

        String className = daoConfig.getProperty(name);
        try {
            T dao = (T) Class.forName(className).newInstance(); // 创建实例对象
            return dao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
