package com.test.factory;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class DataSourceFactory
{
public static DataSource getDataSource()
{
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/mybatisdemo";
String username = "root";
String password = "admin";
PooledDataSource dataSource = new PooledDataSource(driver, url,
username, password);

return dataSource;
}
}
