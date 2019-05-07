import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接池
 *
 * @author WangCong
 * @since 2019-05-07
 */
@Slf4j
public class JdbcConnectionPool extends ObjectPool<Connection> {

    private String url, user, pwd;

    public JdbcConnectionPool(String url, String user, String pwd) {
        super();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            log.error("init jdbc connection pool error, the detail is:", e);
        }
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    protected Connection create() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            log.error("create connection error, the detail is:", e);
        }
        return null;
    }

    @Override
    protected void release(Connection o) {
        try {
            o.close();
        } catch (SQLException e) {
            log.error("close connection error, the detail is:", e);
        }
    }

    @Override
    protected boolean isValidate(Connection o) {
        try {
            return o.isClosed();
        } catch (SQLException e) {
            log.error("check connection is validate error, the detail is:", e);
        }
        return false;
    }
}
