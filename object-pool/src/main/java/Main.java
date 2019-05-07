import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JdbcConnectionPool pool = new JdbcConnectionPool("jdbc:mysql://localhost:3306/mytest?allowMultiQueries=true&autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456");

        Connection connection = pool.acquireOne();

        PreparedStatement ps = connection.prepareStatement("select * from msg_info");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("age"));
        }

        resultSet.close();
        ps.close();
        pool.returnOne(connection);
    }
}
