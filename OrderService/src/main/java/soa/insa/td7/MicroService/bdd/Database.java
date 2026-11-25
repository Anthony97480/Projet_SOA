package soa.insa.td7.MicroService.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection connect(String URL) throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
