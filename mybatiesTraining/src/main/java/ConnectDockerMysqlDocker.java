import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectDockerMysqlDocker extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void getDataVector() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        java.sql.Statement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        String dburl = "jdbc:mysql://192.168.0.100:3306/mysql";
        String dbuser = "root";
        String dbpassword = "123456";
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        String sql = "select * from Student";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Vector rowVector = new Vector();
            {
                System.out.println(rs.getString("sid"));
                System.out.println(rs.getString("sname"));
            }
        }
    }
    public static void main(String Args[]) throws ClassNotFoundException, SQLException{
        getDataVector();
    }
}
