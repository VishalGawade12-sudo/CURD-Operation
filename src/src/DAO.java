package Bankk;

public class DAO 
{
	    private int accountId;
	    private String name;
	    private String email;
	    private String phone;
	    private double balance;
	    public DAO() {}

	    public DAO(String name, String email, String phone, double balance) 
	    {
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	        this.balance = balance;
	    }
	    public int getAccountId() 
	    { 
	    	return accountId; 
	    }
	    public void setAccountId(int accountId) 
	    {
	    	this.accountId = accountId; 
	    }
	    public String getName() 
	    {
	    	return name; 
	    }
	    public void setName(String name) 
	    { 
	    	this.name = name; 
	    }
	    public String getEmail() 
	    { 
	    	return email; 
	    }
	    public void setEmail(String email) 
	    { 
	    	this.email = email; 
	    }
	    public String getPhone() 
	    { 
	    	return phone; 
	    }
	    public void setPhone(String phone) 
	    { 
	    	this.phone = phone; 
	    }
	    public double getBalance() 
	    {
	    	return balance; 
	    }
	    public void setBalance(double balance) 
	    { 
	    	this.balance = balance; 
	    }
	}



