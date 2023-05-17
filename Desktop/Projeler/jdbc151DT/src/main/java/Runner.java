public class Runner {
    public static void main(String[] args) {
        // Database baglan
        JDBCUtils.connectToDataBase();
        // Stament olustur
        JDBCUtils.createStatement();

        // QUERY calistir.
       String sql="CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);";
        JDBCUtils.execute(sql);

    }
}
