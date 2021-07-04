package sonar;


	import java.sql.*;
	import java.util.*;
	import java.util.logging.Logger;

	public class EmployeeJdbcConnection {
		static Scanner scan = new Scanner(System.in);
		Logger logger = Logger.getLogger(EmployeeJdbcConnection.class.getName());
		Connection con;
		Statement st;

		EmployeeJdbcConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","system");
				st = con.createStatement();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		EmployeeJdbcConnection(String n, int a, String job, int sal) {
			this();
			try {
				st.executeUpdate("insert into employee(name, age, designation, salary) values('" + n + "'," + a + ",'" + job
						+ "'," + sal + ");");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void raiseSal() {
			new EmployeeJdbcConnection();
			new Services(st);
		}

		public void display() {
			new EmployeeJdbcConnection();
			new Services().display(st);
		}

		public void displayByDesignation() {
			new EmployeeJdbcConnection();
			logger.info("Select the Designation \n1.Manager \n2.Programmer \n3.Clerk");
			int desig = scan.nextInt();
			new Services().displayByDesignation(st, desig);

		}

		public void raiseById() {
			new EmployeeJdbcConnection();
			logger.info("Enter the ID to raise salary");
			int id = scan.nextInt();
			new Services().raiseByID(id, st);

		}

		public void deleteEmployee() {
			new EmployeeJdbcConnection();
			logger.info("Enter the ID to delete record of Employee");
			int id = scan.nextInt();
			new Services().deleteById(st, id);

		}


}
