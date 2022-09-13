import java.util.Scanner;
import java.sql.*;

public class DrudDemo {
	

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		
		int ch;
		do {
			System.out.println("1.Create");
			System.out.println("2.Read");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("Enter your choice : ");
			ch= sc.nextInt();
			
			switch(ch) {
			case 1: CreateFiles();
			break;
			
			case 2: ReadFiles();
			break;
			
			
			case 3: UpdateFiles();
			break;
			
			
			case 4: DeleteFiles();
			break;
			
			default : System.out.println("invalid option");
			
			}
			
		}while(ch!=5);
		
		
		
	}

	private static void ReadFiles() {
		
		
			
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch6", "root", "root");
			
			Statement stmt = con.createStatement();
			ResultSet rs= (ResultSet) stmt.executeQuery("select * from emp");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" : "+ rs.getString(2)+" : "+rs.getInt(3)+" : "+ rs.getString(4));
			}
			
			 
			 con.close();
			 stmt.close();
			 
			
			 
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private static void DeleteFiles() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch6", "root", "root");
			
			PreparedStatement stmt = con.prepareStatement("delete from emp where id=?");
			
			Scanner sc= new Scanner(System.in);
			
			 
			 System.out.println("Enter id");
			 int id = sc.nextInt();
			 
			
			 stmt.setInt(1, id);
			 
			 stmt.execute();
			 
			 con.close();
			 stmt.close();
			 
			 System.out.println("data deleted");
			 
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private static void UpdateFiles() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch6", "root", "root");
			
			PreparedStatement stmt = con.prepareStatement("update emp set age=? where id=?");
			
			Scanner sc= new Scanner(System.in);
			 System.out.println("Enter age");
			 int age = sc.nextInt();
			 
			 System.out.println("Enter id");
			 int id = sc.nextInt();
			 
			 stmt.setInt(1, age);
			 stmt.setInt(2, id);
			 
			 stmt.execute();
			 
			 con.close();
			 stmt.close();
			 
			 System.out.println("data updated");
			 
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	

	public static void CreateFiles() {
		
try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch6", "root", "root");
			
			PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?,?)");
			
			Scanner sc= new Scanner(System.in);
			 System.out.println("Enter Id");
			 int id = sc.nextInt();
			 
			 System.out.println("Enter Name");
			 String name= sc.next();
			 
			 System.out.println("Enter Age");
			 int age=sc.nextInt();
			 
			 System.out.println("Enter design");
			 String design= sc.next();
			 
			 stmt.setInt(1, id);
			 stmt.setString(2, name);
			 stmt.setInt(3, age);
			 stmt.setString(4, design);
			 
			 stmt.execute();
			 
			 
			
					 stmt.close();
					 con.close();
					 
					 System.out.println("data saved");
					 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
}
