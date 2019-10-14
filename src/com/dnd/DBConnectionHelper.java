package com.dnd;

import fisglobal.jdbc.pool.ScConnectionPoolDataSource;
import fisglobal.jdbc.pool.ScJDBCConnectionPoolCache;
import fisglobal.jdbc.pool.ScJdbcPool;

import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

public class DBConnectionHelper {

    private static final String HOST = "host";
    private static final String dbPassword = "sofi";
    private static String fisConnectionUrl = "protocol=jdbc:fisglobal/database=" +
            System.getProperty(HOST) + ":19555:SCA$IBS/signOnType=0/fileEncoding=UTF-8";

    /**
     * Note, all mysql connections go through port 3306, this appears to only be operator and activities calls
     *
     * @return Connection
     */
    protected static Connection setupMySqlDBConnection() {
        return buildConnection("mysql", "3306", "sofi", "sofi", "com.mysql.cj.jdbc.Driver");
    }

    /**
     * Note, all postgres 11 connections go through port 5434 with the exception of in school
     *
     * @param username
     * @param dbName
     * @return Connection
     */
    protected static Connection setupPostgres11DBConnection(String username, String dbName) {
        return getPostgresConnection("5434", dbName, username);
    }

    /**
     * More information about the FIS driver can be found in confluence here:
     * https://sofiinc.atlassian.net/wiki/spaces/EST/pages/513933359/Setting+up+Profile+connection
     *
     * @return Connection
     */
    protected static Connection setupFisglobalDBConnection() {
        Properties props = buildProperties("1000", "Zenbanx01");
        return buildDriverConnection(fisConnectionUrl, props, "fisglobal.jdbc.driver.ScDriver");
    }

    private static Connection getPostgresConnection(String port, String dbName, String username) {
        return buildConnection("postgresql", port, dbName, username, "org.postgresql.Driver");
    }

    private static Connection buildConnection(String dbtype, String port, String dbName, String username, String driver) {
        String connectionUrl = buildConnectionUrl(dbtype, port, dbName);
        Properties props = buildProperties(username);
        return buildDriverConnection(connectionUrl, props, driver);
    }

    /**
     * Used to build the connection url
     *
     * @param dbtype Currently either mysql or postgresql
     * @param port
     * @param dbName
     * @return String
     */
    private static String buildConnectionUrl(String dbtype, String port, String dbName) {
        return "jdbc:" + dbtype + "://" + System.getProperty(HOST) + ":" + port + "/" + dbName;
    }

    /**
     * Build the connection object
     *
     * @param connectionUrl
     * @param props
     * @param driver
     * @return Connection
     */
    private static Connection buildDriverConnection(String connectionUrl, Properties props, String driver) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(connectionUrl, props);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find database driver: " + e.getMessage());
        } catch (SQLException sqle) {
            throw new RuntimeException("Unable to setup database connection: " + sqle.getMessage());
        }
    }

    /**
     * Build the Properties object with the provided username and universal db password
     *
     * @param username
     * @return Properties
     */
    private static Properties buildProperties(String username) {
        return buildProperties(username, dbPassword);
    }

    /**
     * Build the properties object with the provided username and password (currently only needed for FIS)
     *
     * @param username
     * @param dbPassword
     * @return Properties
     */
    private static Properties buildProperties(String username, String dbPassword) {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", dbPassword);
        return props;
    }

    public static void closeDBConnection(ResultSet resultSet) throws SQLException {
        closeDBConnection(null, null, resultSet);
    }

    public static void closeDBConnection(Connection conn) throws SQLException {
        closeDBConnection(conn, null, null);
    }

    public static void closeDBConnection(Connection conn, Statement statement) throws SQLException {
        closeDBConnection(conn, statement, null);
    }

    public static void closeDBConnection(Connection conn, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (conn != null) conn.close();
    }

    protected DataSource createDataSource() throws SQLException {
        String username = "1000";
        String password = "Zenbanx01";
        ScConnectionPoolDataSource conPoolDataSource = new ScConnectionPoolDataSource();
        conPoolDataSource.setUser(username);
        conPoolDataSource.setPassword(password);
        ScJdbcPool connectionPool = new ScJdbcPool(username, password, fisConnectionUrl);
        connectionPool.setExpirationTime(300L);
        connectionPool.setMaxmumSize(100);
        connectionPool.setMinimumSize(10);
        connectionPool.setMaxIdleTime(120);

        ScJDBCConnectionPoolCache dataSource = new ScJDBCConnectionPoolCache(conPoolDataSource);
        dataSource.setConCache(connectionPool);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
