
import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sql9932098");
        Statement statement = connection.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
        /*
         Prepared statement olusturmak icin;
         1. Adim Prepared statement Query olustur
         */

        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";  // ? demek parametrelendirmek yani baska degerlerde alabilir demek
       // 2. adim Prepared statement objesi olustur
        PreparedStatement preparedStatement= connection.prepareStatement(sql1);
        //3. adim:  objeyi kullanrak ? isaretli yerlere deger atiyoruz
        preparedStatement.setInt(1,9999);
        preparedStatement.setString(2,"IBM");
        //4. Adim: Query calistir
        int güncellenen_satir_sayisi=preparedStatement.executeUpdate();
        System.out.println("güncellenen_satir_sayisi : "+ güncellenen_satir_sayisi);


        // güncelleme sonrasi tabolu okumka

        String sql2="select * from companies";
        ResultSet rs2= statement.executeQuery(sql2);
        while (rs2.next()){
            System.out.println(rs2.getObject(1)+"--"+rs2.getObject(2)+"--"+rs2.getObject(3));
        }


        //2. Örnek: Prepared statement kullanarak company adı CASPER olan number_of_employees değerini 5000 olarak güncelleyin.
        preparedStatement.setInt(1,5000);
        preparedStatement.setString(2,"CASPER");
        int güncellenen_satir_sayisi2=preparedStatement.executeUpdate();
        System.out.println("güncellenen_satir_sayisi2 : "+ güncellenen_satir_sayisi2);

        // güncelleme sonrasi tabolu okumka

        String sql3="select * from companies where company='CASPER' ";
        ResultSet rs3= statement.executeQuery(sql3);
        while (rs3.next()){
            System.out.println(rs3.getObject(1)+"--"+rs3.getObject(2)+"--"+rs3.getObject(3));
        }



        connection.close();
        statement.close();
    }
}
