import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
 
public class PersonenJaar {
    final static String maandag = "Maandag";
    final static String dinsdag = "Dinsdag";
    final static String woensdag = "Woensdag";
    final static String donderdag = "Donderdag";
    final static String vrijdag = "Vrijdag";
    final private Button button1;
    private final DBconnector connector;
    int maandagint,dinsdagint,woensdagint,donderdagint,vrijdagint;
    
    public PersonenJaar (FlowPane p) {
        connector = new DBconnector();
        button1 = new Button("terug naar Data per dag");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Aantal personen afgelopen week");
        xAxis.setLabel("Tijd");       
        yAxis.setLabel("Aantal personen");
        
 String maandag1 = "SELECT * FROM weersensoren_meting WHERE tijd ='maandag'";
 ResultSet res = connector.getData(maandag1); 
        try {
            while (res.next()) {
                String strnaam = res.getString("temperatuur");

                maandagint = Integer.parseInt(strnaam);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
String dinsdag1 = "SELECT TEMPERATUUR FROM weersensoren_meting WHERE tijd ='dinsdag'";        
 ResultSet res2 = connector.getData(dinsdag1);    
try { while (res2.next()) {
                String strnaam = res2.getString("temperatuur");
                dinsdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
    
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("temperatuur per dag");       
        series1.getData().add(new XYChart.Data(maandag, maandagint));
        series1.getData().add(new XYChart.Data(dinsdag, dinsdagint));
        series1.getData().add(new XYChart.Data(woensdag, 100));
        series1.getData().add(new XYChart.Data(donderdag, 100));
        series1.getData().add(new XYChart.Data(vrijdag, 100));      
        
       /* XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(maandag, 100));
        series2.getData().add(new XYChart.Data(dinsdag, 100));
        series2.getData().add(new XYChart.Data(woensdag, 100));
        series2.getData().add(new XYChart.Data(donderdag, 100));
        series2.getData().add(new XYChart.Data(vrijdag, 100));  
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(maandag, 100));
        series3.getData().add(new XYChart.Data(dinsdag, 100));
        series3.getData().add(new XYChart.Data(woensdag, 100));
        series3.getData().add(new XYChart.Data(donderdag, 100));
        series3.getData().add(new XYChart.Data(vrijdag, 100));  */
        
     button1.setOnAction(event -> {
            p.getChildren().clear();
            new PersonenDag (p);    
       });
       bc.getData().addAll(series1);
        p.getChildren().addAll(bc, button1);
    }

}