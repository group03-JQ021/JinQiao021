package com.jxdedu.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	//声明session工厂
	public static SqlSessionFactory sf = null;
	static{
		//先加载主配置文件到内存中
		try {
			Reader config = Resources.getResourceAsReader("mybatis.cfg.xml");
			//用读取内存中的配置文件创建一个session工厂
			sf = new SqlSessionFactoryBuilder().build(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打开一个session会话
	 * @Description:@return
	 */
	public static SqlSession openSession(){
		return sf.openSession();
	}

}
