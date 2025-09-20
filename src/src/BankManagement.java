package Bankk;
import java.util.List;
import java.util.Scanner;
public class BankManagement 
{
    public static void main(String[] args) 
    {
        CustomerDAO dao = new CustomerDAO();
        Scanner sc = new Scanner(System.in);
        int choice;
        do 
        {
            System.out.println("\n--- Bank Management ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Balance");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter balance: ");
                    double balance = sc.nextDouble();
                    dao.addCustomer(new DAO(name, email, phone, balance));
                    break;

                case 2:
                    List<DAO> customers = dao.getAllCustomers();
                    for (DAO c : customers) 
                    {
                        System.out.println(c.getAccountId() + "  " + c.getName() + "  " + c.getEmail() + "  " + c.getPhone() + "   " + c.getBalance());
                    }
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int accId = sc.nextInt();
                    System.out.print("Enter new balance: ");
                    double newBalance = sc.nextDouble();
                    dao.updateBalance(accId, newBalance);
                    break;

                case 4:
                    System.out.print("Enter account ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteCustomer(delId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } 
        while (choice != 5);

        sc.close();
    }
}
