import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sql9932098");
        Statement statement = connection.createStatement();
        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.

        String sql1="update companies set number_of_employees= 16000 where number_of_employees<  (select avg(number_of_employees) from companies) ";
        int up1= statement.executeUpdate(sql1);  // bu metod updete edilen satir sayisini int olarak verir
        System.out.println("Güncellenen veri sayisi : "+up1);

        //update sonrasi datayi okumak ici DQL kullaniriz

        String sql2 ="select * from companies";
        ResultSet rs2=statement.executeQuery(sql2);

        while (rs2.next()){
            System.out.println(rs2.getObject(1)+"--"+rs2.getObject(2)+"--"+rs2.getObject(3));
        }

        connection.close();
        statement.close();

    }// main

}
