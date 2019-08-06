package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DataOperations {

    private String host = "";
    private String login = "";
    private String password = "";

    public DataOperations() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("ERROR: config.properties not found!");
        }
    }


    private Connection connect() throws Exception {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(host, login, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String namepic) throws Exception {
        createTable();

        try {
            Connection con = connect();
            PreparedStatement posted = con.prepareStatement("INSERT INTO iamalive (namepic) VALUES ('" + namepic + "')");

            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Insert Completed.");
        }
    }

    private void createTable() throws Exception {
        try {
            Connection con = connect();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS iamalive(id SERIAL, namepic varchar(255), PRIMARY KEY (id))");
            create.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Function Complete.");
        }


    }


    public  ArrayList<String> get() throws Exception{
        try{
            Connection con = connect();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM iamalive ");

            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){

                array.add(result.getString("namepic"));
            }

            System.out.println("All records have been selected!");
            return array;

        }catch(Exception e) {
            System.out.println(e);
        }
        return null;

    }

}
