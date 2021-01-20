import javax.xml.transform.Result;
import java.sql.*;
//import java.sql.*;

public class Movies {

    public static final String DB_NAME = "movie.db";
    public static final String DB_PATH = "jdbc:sqlite:c:\\Users/Bereket/ideaprojects/javaAppWithSQLiteAppAssignment\\movie.db";
   // public static final String  DB_PATH = "jdbc:sqlite:/c/Users/Bereket/ideaprojects/javaAppWithSQLiteAppAssignment/movie.db";

    public static void main(String[] args) {


        /*
        Use SQLite to create a Java app with a db of movies. Create a table also called movies. Have it contain the following columns:
            - name
            - publishing year
            - length
            - main actor/actress

            Create all CRUD operations
            - Create records
            - Print each record
            - Update data
            - Delete data
        */

        try {

            Connection conn = DriverManager.getConnection(DB_PATH);
            Statement statement = conn.createStatement();

            // Create table

            statement.execute("CREATE TABLE MOVIES (name TEXT, publishingYear INTEGER , length INTEGER, mainActorActress TEXT)");

            statement.execute("INSERT INTO MOVIES (name, publishingYear, length , mainActorActress ) VALUES ('Pursuit of happiness' , 2001, 2,  'Will Smith')");

            //Print record


            ResultSet results = statement.executeQuery("SELECT * FROM MOVIES");
            while (results.next()) {
            System.out.println(results.getString("name")+ " " + results.getNString("publishingYear")
                    + " " + results.getNString("length") + " " + results.getNString("mainActorActress"));
        }
            results.close();
            statement.close();
            conn.close();

            // Update record
        //statement.execute("UPDATE MOVIES SET publishingYear = 2020 WHERE name='Will Smith' ");

            // DELETE records
            statement.execute("DELETE FROM MOVIES WHERE name = 'Will Smith' ");



        } catch (SQLException e) {
            System.out.println("SQL EXCEPTION: " + e.getMessage());
          // e.printStackTrace();

        }


    }
}
