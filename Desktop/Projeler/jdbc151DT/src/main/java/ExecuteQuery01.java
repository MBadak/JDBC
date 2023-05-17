import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sql9932098");
        Statement statement = connection.createStatement();

        //1. Örnek:  region id'si 1 olan "country name" değerlerini çağırın.
        String sql1 = "Select country_name From countries Where region_id=1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 =" + r1);  //true

        ResultSet resultSet = statement.executeQuery(sql1);
      while (resultSet.next()){
          System.out.println(resultSet.getString(1));

      }
        System.out.println("++++++++++++++++++++++++++++++ Örnek 2 *****************************");

      //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2= "Select country_id, country_name from countries where region_id>2";
      boolean r2= statement.execute(sql2);
        System.out.println("r2 : "+ r2);

        ResultSet rs = statement.executeQuery(sql2);

        while (rs.next()){
            System.out.println(rs.getString(1)+ "--"+ rs.getString(2));
        }

        System.out.println("++++++++++++++++++++++++++++++ örnek 3 ******************************************");


        ////3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3 ="select * from companies where number_of_employees=(select min(number_of_employees) from companies);";
        ResultSet rs3= statement.executeQuery(sql3);

        while (rs3.next()){
            System.out.println(rs3.getString(1)+"--"+ rs3.getString(2)+"--"+ rs3.getString(3) );
            System.out.println(rs3.getObject(1)+"--"+ rs3.getObject(2)+"--"+ rs3.getObject(3) );  // objekt ilede  tüm datalari alabiliriz, ama int ise iselm yapamayiz

        }
        connection.close();
        statement.close();


    }
}