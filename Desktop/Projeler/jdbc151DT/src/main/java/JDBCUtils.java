import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private  static Connection connection;
    private  static Statement statement;

    // Database baglanma metodu
    public static Connection connectToDataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sql9932098");
            System.out.println("Baglanti kuruldu");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return connection;
    }

    // Statement olusturma methodu
    public static Statement createStatement(){
        try {
            statement=connection.createStatement();
            System.out.println("Statement olusturuldu.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    // Execute ile QUERY calistiran methot

    public static  boolean execute(String sql){
        try {
            return  statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







}
