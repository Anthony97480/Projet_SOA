package soa.insa.td7.MicroService.bdd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
"FOREIGN KEY (user_id) REFERENCES users(id)"
*/

public class DatabaseInit {

    public static void init(String URL) {
        create_client(URL);
    }

    private static void create_client(String URL) {
        String sql = "CREATE TABLE IF NOT EXISTS clients (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "firstname TEXT NOT NULL," +
                    "lastname TEXT NOT NULL" +
                    ");";
        
        try(Connection conn = Database.connect(URL);
            Statement stmt = conn.createStatement()){

            stmt.execute(sql);

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}