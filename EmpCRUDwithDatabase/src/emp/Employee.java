package emp;
import java.sql.*;
import java.util.Scanner;

public class Employee {
	
	
	 
		public static void main(String[] args) throws Exception  {
			Class.forName("com.mysql.jdbc.Driver");
			String  url="jdbc:mysql://localhost:3306/employee?characterEncoding=utf8";
			String username="root";
			String password="root";
			Connection con =DriverManager.getConnection(url,username,password);
	 
			Statement stmt =con.createStatement();
			ResultSet rs;
			PreparedStatement st;
	 
			String qry="";
			int ID,Age,choice;
			String First_Name,Last_Name,email;
	 
			Scanner in = new Scanner(System.in);
			Scanner str = new Scanner(System.in);
	 
			while(true)
			{
				
				System.out.println("1. Insert");
				System.out.println("2. Update");
				System.out.println("3. Delete");
				System.out.println("4. Select");
				System.out.println("5. Exit");
				System.out.print("Enter a choice: ");
				choice = in.nextInt();
				System.out.println("-----------------------------------------");
				switch(choice){
				case 1:
					System.out.println("1. Insert New Data");
	 
					System.out.println("Enter First_Name : ");
					First_Name=str.nextLine();
					System.out.println("Enter Last_Name : ");
					Last_Name=str.nextLine();
					System.out.println("Enter email : ");
					email=str.nextLine();
					System.out.println("Enter Age : ");
					Age=in.nextInt();
					
	 
					qry="insert into empp (First_Name,Last_Name,email,Age) values(?,?,?,?)";
					st= con.prepareStatement(qry);
					st.setString(1, First_Name);
					st.setString(2, Last_Name);
					st.setString(3, email);
					st.setInt(4, Age);
					
	 
					st.executeUpdate();
					System.out.println("Data Insert Success");
	 
					break;
				case 2:
					System.out.println("2. Updating a Data");
	 
					System.out.println("Enter ID : ");
					ID=in.nextInt();
					System.out.println("Enter First_Name : ");
					First_Name=str.nextLine();
					System.out.println("Enter Last_Name : ");
					Last_Name=str.nextLine();
					System.out.println("Enter email : ");
					email=str.nextLine();
					System.out.println("Enter Age : ");
					Age=in.nextInt();
					
	 
					    qry="update empp set First_Name=?,Last_Name=?,emai=?,AGE=?, where ID=?";
					st= con.prepareStatement(qry);
	 
					st.setString(1, First_Name);
					st.setString(2, Last_Name);
					st.setString(3, email);
					st.setInt(4, Age);
					st.setInt(5, ID);
					st.executeUpdate();
					System.out.println("Data Update Success");
	 
					break;
				case 3:
					System.out.println("3. Deleting a Data");
					System.out.println("Enter ID : ");
					ID=in.nextInt();
	 
					qry="delete from empp where ID=?";
					st= con.prepareStatement(qry);
					st.setInt(1, ID);
	 
					st.executeUpdate();
					System.out.println("Data Deleted Success");
	 
					break;
				case 4:
					System.out.println("4. Print all Records");
					qry="SELECT ID,First_Name,Last_Name,email,Age from empp";
					rs=stmt.executeQuery(qry);
					while(rs.next())
					{
						ID=rs.getInt("ID");
						First_Name=rs.getString("First_Name");
						Last_Name=rs.getString("Last_Name");
						email=rs.getString("email");
						Age=rs.getInt("Age");
						
	 
						      System.out.print(ID+" ");
						      System.out.print(First_Name+" ");
						      System.out.print(Last_Name+" ");
						      System.out.print(email+" ");
						      System.out.print(Age+" ");
						
	 
					}
					break;
				case 5:
					System.out.println("Thank You");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Selection");
					break;
				}
				System.out.println("-----------------------------------------");
			}
		}
	 
	}

