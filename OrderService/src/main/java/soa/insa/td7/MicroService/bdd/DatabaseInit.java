package soa.insa.td7.MicroService.bdd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*

*/

public class DatabaseInit {

    public static void init(String URL) {
        create_client(URL);
        create_commande(URL);
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
    
    private static void create_commande(String URL) {
        String sql = "CREATE TABLE IF NOT EXISTS orders (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "amount INTEGER," +
                    "FOREIGN KEY (client_id) REFERENCES clients(id)" +
                    ");";
        
        try(Connection conn = Database.connect(URL);
            Statement stmt = conn.createStatement()){

            stmt.execute(sql);

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}