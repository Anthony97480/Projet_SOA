package soa.insa.td7.MicroService.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import soa.insa.td7.MicroService.bdd.Database;
import soa.insa.td7.MicroService.model.*;

public class commandeHandler {
	private static String URL;

    public commandeHandler(String URL) {
        this.URL = URL;
    }
    
    public void AddOrder(commandes order) {
    	String sql = "INSERT INTO orders(name, amount) VALUES(?, ?)";
    	
    	try(Connection conn = Database.connect(sql); PreparedStatement stmt = conn.prepareStatement(sql)){
    		stmt.setString(1, order.getName());
    		stmt.setInt(2, order.getAmount());
    		
    		stmt.executeUpdate();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public commandes getOrderByID(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";

        try(Connection conn = Database.connect(URL); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new commandes(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("amount")
                );
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public void DeleteOrderByID(int id){
        String sql = "DELETE FROM orders WHERE id = ?";

        try(Connection conn = Database.connect(URL);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateOrder(int id, int new_amount) {
    	String sql = "UPDATE orders SET amount=? WHERE id=?";
    	
    	try(Connection conn = Database.connect(URL); PreparedStatement stmt = conn.prepareStatement(sql) ) {
            stmt.setInt(1, new_amount);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
}
