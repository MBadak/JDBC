import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sql9932098");   // bu bize bir connetion (baglanti) verir
        Statement statement = connection.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        //1. yol  Offset ve limit  kullanarak
        System.out.println("1. yol");
        String sql1 = "select company, number_of_employees from companies order by number_of_employees desc offset 1 limit 1;";
        ResultSet rs1 = statement.executeQuery(sql1);
        while (rs1.next()) {
            System.out.println(rs1.getObject(1) + "--" + rs1.getObject(2));
        }

        // 2. yol
        System.out.println("2. yol");
        String sql2="SELECT company, number_of_employees FROM companies " +
                "WHERE number_of_employees = (SELECT MAX(number_of_employees) FROM companies " +
                "WHERE number_of_employees < (SELECT MAX(number_of_employees) FROM companies))";
        ResultSet rs2= statement.executeQuery(sql2);

        while (rs2.next()){
            System.out.println(rs2.getObject(1) + "--" + rs2.getObject(2));
        }

        connection.close();
        statement.close();


    }//main
}
