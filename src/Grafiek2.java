import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
 
public class Grafiek2 {
    final static String maandag = "Maandag";
    final static String dinsdag = "Dinsdag";
    final static String woensdag = "Woensdag";
    final static String donderdag = "Donderdag";
    final static String vrijdag = "Vrijdag";
    final static String zaterdag = "Zaterdag";
    final static String zondag = "Zondag";
    final private Button button1;
    private final DBconnector connector;
    int maandagint,maandagint2,maandagint3,
            dinsdagint, dinsdagint2, dinsdagint3,
            woensdagint, woensdagint2,woensdagint3,
            donderdagint, donderdagint2, donderdagint3,
            vrijdagint, vrijdagint2, vrijdagint3;
    
    public Grafiek2 (FlowPane p) {
        connector = new DBconnector();
        button1 = new Button();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Aantal personen afgelopen week");
        xAxis.setLabel("Tijd");       
        yAxis.setLabel("Aantal personen");
        
String maandag1 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 1 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res1 = connector.getData(maandag1);    
try { while (res1.next()) {
                String strnaam = res1.getString("triggerid");
                maandagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String maandag2 = "SELECT MIN(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 1 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res6 = connector.getData(maandag2);    
try { while (res6.next()) {
                String strnaam = res6.getString("triggerid");
                maandagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();}
maandagint3 = maandagint - maandagint2 + 1;

String dinsdag1 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 2 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res2 = connector.getData(dinsdag1);    
try { while (res2.next()) {
                String strnaam = res2.getString("triggerid");
                dinsdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String dinsdag2 = "SELECT min(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 2 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res7 = connector.getData(dinsdag2);    
try { while (res7.next()) {
                String strnaam = res7.getString("triggerid");
                dinsdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
dinsdagint3 = dinsdagint - dinsdagint2 + 1;

String woensdag1 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 3 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res3 = connector.getData(woensdag1);    
try { while (res3.next()) {
                String strnaam = res3.getString("triggerid");
                woensdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String woensdag2 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 3 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res8 = connector.getData(woensdag2);    
try { while (res8.next()) {
                String strnaam = res8.getString("triggerid");
                woensdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
woensdagint3 = woensdagint - woensdagint2 +1;

String donderdag1 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 4 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res4 = connector.getData(donderdag1);    
try { while (res4.next()) {
                String strnaam = res4.getString("triggerid");
                donderdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String donderdag2 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 4 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res9 = connector.getData(donderdag2);    
try { while (res9.next()) {
                String strnaam = res9.getString("triggerid");
                donderdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
donderdagint3 = donderdagint - donderdagint2 +1;

String vrijdag1 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 5 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res5 = connector.getData(vrijdag1);    
try { while (res5.next()) {
                String strnaam = res5.getString("triggerid");
                vrijdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String vrijdag2 = "SELECT max(triggerid) triggerid from waarneming where EXTRACT(DAY FROM tijd)= 5 and EXTRACT(MONTH FROM tijd)=1";        
 ResultSet res10 = connector.getData(vrijdag2);    
try { while (res10.next()) {
                String strnaam = res10.getString("triggerid");
                vrijdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
vrijdagint3 = vrijdagint - vrijdagint2 +1;

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("temperatuur per dag");       
        series1.getData().add(new XYChart.Data(maandag, maandagint3));
        series1.getData().add(new XYChart.Data(dinsdag, dinsdagint3));
        series1.getData().add(new XYChart.Data(woensdag, woensdagint3));
        series1.getData().add(new XYChart.Data(donderdag, donderdagint3));
        series1.getData().add(new XYChart.Data(vrijdag, vrijdagint3));   
        series1.getData().add(new XYChart.Data(zaterdag, vrijdagint3));
        series1.getData().add(new XYChart.Data(zondag, vrijdagint3));
        
  
        
     button1.setOnAction(event -> {
            p.getChildren().clear();
            new Grafiek1 (p);    
       });
       bc.getData().addAll(series1);
        p.getChildren().addAll(bc, button1);
    }

}