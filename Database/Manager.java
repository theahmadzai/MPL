import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Manager {
    Connection con = null; //build connection
    Statement stmt = null; //execute query

    public Manager() {
        try {
            //REGISTER DRIVERS
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            DriverManager.registerDriver(new SQLServerDriver());

            //initializtion of conncection class object
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=school;integratedSecurity=true");
            if(con != null) {
                DatabaseMetaData metaObj = con.getMetaData();
                System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
            }
            stmt = con.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertUpdateDelete(String query) {
        try {
            stmt.execute(query);
        } catch(Exception ex) {
            System.out.print(ex.toString());
        }
    }

    public ResultSet select(String query) {
        try {
            return stmt.executeQuery(query);
        } catch(Exception ex) {
            return null;
        }
    }
}
