package Bankk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CustomerDAO
{
    public void addCustomer(DAO customer)
    {
        String sql = "INSERT INTO customers (name, email, phone, balance) VALUES (?, ?, ?, ?)";
        try (Connection conn = Transaction.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setDouble(4, customer.getBalance());
            pstmt.executeUpdate();
            System.out.println("Customer added successfully!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public List<DAO> getAllCustomers()
    {
        List<DAO> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = Transaction.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) 
            {
            	while (rs.next())
            	{
            		DAO c = new DAO();
            		c.setAccountId(rs.getInt("account_id"));
            		c.setName(rs.getString("name"));
            		c.setEmail(rs.getString("email"));
            		c.setPhone(rs.getString("phone"));
            		c.setBalance(rs.getDouble("balance"));
            		customers.add(c);
            	}
            }
        	catch (SQLException e)
        	{
        		e.printStackTrace();
        	}
        	return customers;
    }
    public void updateBalance(int accountId, double newBalance) {
        String sql = "UPDATE customers SET balance=? WHERE account_id=?";
        try (Connection conn = Transaction.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accountId);
            pstmt.executeUpdate();
            System.out.println("Balance updated successfully!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteCustomer(int accountId) 
    {
        String sql = "DELETE FROM customers WHERE account_id=?";
        try (Connection conn = Transaction.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) 
        	{
            	pstmt.setInt(1, accountId);
            	pstmt.executeUpdate();
            	System.out.println("Customer deleted successfully!");
        	}
            catch (SQLException e) 
        	{
            	e.printStackTrace();
        	}
    }
}
