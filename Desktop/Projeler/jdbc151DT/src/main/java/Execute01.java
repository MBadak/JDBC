import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. adim:  driver'a baglanmak  ==> JDBC 4 sonrasi gerek yok
        Class.forName("org.postgresql.Driver");


        //2. Adim: DAtabase baglan   --> once Draver maneger ihtiyac avr
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sql9932098");   // bu bize bir connetion (baglanti) verir

        // 3. Adim Statement olustur
        Statement statement= connection.createStatement();

        // 4. Adim Query calistir
        /*
        1) Eğer execute() methodu DDL (create, drop, alter table) ile kullanılırsa her zaman 'false' döner.
        2) Eğer execute() methodu DQL (select) ile kullanılırsa data dönerse 'true', data dönmezse 'false' döner.
         */

        //1.Örnek: "workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.
        boolean sql1=statement.execute("CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);");
        System.out.println("sql1 : "+sql1);

        // 2. örnek  workers tablosuna 'worker_address'  sutunu ekleyin
        boolean sql2= statement.execute("alter table workers add worker_address varchar(100);");
        System.out.println("sql2 : "+ sql2);

        // 3. ornek  workers tablosunu siliniz
        boolean sql3=statement.execute("drop table workers;");
        System.out.println("sql3 : " +sql3);

        // 5. Adim Baglantiyi kapat
        connection.close();
        statement.close();

    }
}
