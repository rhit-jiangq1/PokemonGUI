package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //DO NOT EDIT THIS STRING, YOU WILL RECEIVE NO CREDIT FOR THIS TASK IF THIS STRING IS EDITED
    private final String SampleURL = "jdbc:sqlserver://${dbServer};databaseName=${dbName};user=${user};password={${pass}}";

    private Connection connection = null;

    private String databaseName;
    private String serverName;

    public DatabaseConnection(String serverName, String databaseName) {
        //DO NOT CHANGE THIS METHOD
        this.serverName = serverName;
        this.databaseName = databaseName;
    }

    public boolean connect(String user, String pass) {
        //DONE: Task 1
        //BUILD YOUR CONNECTION STRING HERE USING THE SAMPLE URL ABOVE
        String fullUrl = SampleURL
                .replace("${dbServer}", this.serverName)
                .replace("${dbName}", this.databaseName)
                .replace("${user}", user)
                .replace("${pass}", pass);
        System.out.println("Connecting");
        try {
            connection = DriverManager.getConnection(fullUrl);
            System.out.println("Connection Successful");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        //DONE: Task 1
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}