import com.pogorelov.dbconnection.domain.Department;
import com.pogorelov.dbconnection.service.DepartmentService;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final DepartmentService departmentService;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        departmentService.findAllDepartments();
        Connection connection;
        Statement statement;
        try {
            //Driver driver = new FabricMySQLDriver();
            //http://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
            List<Department> departments = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                System.out.println("DEPARTMENT: " + id + ": " + name);
                departments.add(new Department(id, name));
            }
            System.out.println("DEPARTMENTS LIST: " + departments);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
