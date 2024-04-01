package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class ConnectTests extends Exception{

    @Test
    public void test1() {

        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void testConnection() throws Exception {

        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3308/webdb",
                "webuser",
                "0806"
        );

        /*정상적으로 연결된다면 Connection타입의 객체는 null이 아니라는 것을 확신한다는 의미*/
        Assertions.assertNotNull(connection);

        /*데이터베이스 연결을 종료함*/
        /*jdbc 프로그래밍에서 제일 중요한 것이 .Connection은 반드시 close 해야 한다는 점
        * 연결이 종료되지 않는다면 새로운 연결을 받을 수 가 없다.*/
        connection.close();

    }

    @Test
    public void testHikariCP() throws Exception{
        HikariConfig config=new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3308/webdb");
        config.setUsername("webuser");
        config.setPassword("0806");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize","250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

        HikariDataSource ds=new HikariDataSource(config);
        Connection connection=ds.getConnection();

        System.out.println(connection);
        connection.close();

    }
}


