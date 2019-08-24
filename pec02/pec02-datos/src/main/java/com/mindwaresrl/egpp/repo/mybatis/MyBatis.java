package com.mindwaresrl.egpp.repo.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {

	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory()  {
		 if(sqlSessionFactory==null) {
		       InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {

			}
		 }
		 return sqlSessionFactory;
	}
	
}
