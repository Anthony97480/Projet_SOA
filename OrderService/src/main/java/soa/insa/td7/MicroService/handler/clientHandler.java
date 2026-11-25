package soa.insa.td7.MicroService.handler;

import soa.insa.td7.MicroService.model.*;
import soa.insa.td7.MicroService.bdd.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class clientHandler {
    private static String URL;

    public clientHandler(String URL) {
        this.URL = URL;
    }

    public void AddClient(Client clt) {
        String sql = "INSERT INTO clients(firstname, lastname) VALUES(?, ?)";

        try (Connection conn = Database.connect(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, clt.getFirstName());
            pstmt.setString(2, clt.getLastName());

            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Client getClientByID(int id) {
        String sql = "SELECT * FROM clients WHERE id = ?";

        try(Connection conn = Database.connect(URL); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new Client(
                    rs.getInt("id"),
                    rs.getString("lastname"),
                    rs.getString("firstname")
                );
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public void DeleteClientByID(int id){
        String sql = "DELETE FROM clients WHERE id = ?";

        try(Connection conn = Database.connect(URL);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void RenameClient(int id, String new_lastname, String new_firstname){
        String sql = "UPDATE clients " +
                    "SET firstname=?, " +
                    "lastname=? " +
                    "WHERE id=?";
        
        try(Connection conn = Database.connect(URL); PreparedStatement stmt = conn.prepareStatement(sql) ) {
            stmt.setString(1, new_firstname);
            stmt.setString(2, new_lastname);
            stmt.setInt(3, id);

            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
