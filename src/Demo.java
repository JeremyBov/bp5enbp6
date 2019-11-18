import java.sql.*;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;


public class Demo extends Application {
   
public void start(Stage primaryStage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 900, 500);
        new Grafiek1 (root); 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Beroepsproduct5+6");
        primaryStage.show();

    }

    public static void main(String[] args) throws SQLException {
launch (args);
        
Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "password";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beroepsproduct blok 6", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from meting_bewegingsensor");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("TriggerID") + ", " + myRs.getString("BewegingTijd"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }  
    

}
