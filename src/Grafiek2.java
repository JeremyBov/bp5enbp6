import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
    final private Button button1, button2, buttonrefresh;
    private final DBconnector connector;
    int maandagint,maandagint2,maandagint3,
            dinsdagint, dinsdagint2, dinsdagint3,
            woensdagint, woensdagint2,woensdagint3,
            donderdagint, donderdagint2, donderdagint3,
            vrijdagint, vrijdagint2, vrijdagint3,
            zaterdagint, zaterdagint2, zaterdagint3,
            zondagint, zondagint2, zondagint3;
    
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int month = localDate.getMonthValue();
    int day = localDate.getDayOfMonth();
    int dayofweekint = localDate.getDayOfWeek().getValue();
    
    public Grafiek2 (FlowPane p) {
        connector = new DBconnector();
        button1 = new Button("Weergeven data per Maand");
        button2 = new Button("Weergeven data per Maand");
        buttonrefresh = new Button("refresh");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Aantal personen afgelopen week");
        xAxis.setLabel("Tijd");       
        yAxis.setLabel("Aantal personen");
        
        int daysInMonth;
        if(month == 1 || month == 3 ||month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12)
        {
            daysInMonth = 31;
        }
        else if(month == 2)
        {
            daysInMonth = 28;
        }
        else
        {
            daysInMonth = 30;
        }
        
        
        for(int i = 0; i < daysInMonth; i++)
        {
            
        }
        
String maandag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(1-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res1 = connector.getData(maandag1);    
try { while (res1.next()) {
                String strnaam = res1.getString("triggerid");
                maandagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String maandag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(1-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res6 = connector.getData(maandag2);    
try { while (res6.next()) {
                String strnaam = res6.getString("triggerid");
                maandagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();}
maandagint3 = maandagint - maandagint2 + 1;

String dinsdag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(2-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res2 = connector.getData(dinsdag1);    
try { while (res2.next()) {
                String strnaam = res2.getString("triggerid");
                dinsdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String dinsdag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(2-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res7 = connector.getData(dinsdag2);    
try { while (res7.next()) {
                String strnaam = res7.getString("triggerid");
                dinsdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
dinsdagint3 = dinsdagint - dinsdagint2 + 1;

String woensdag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(3-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res3 = connector.getData(woensdag1);    
try { while (res3.next()) {
                String strnaam = res3.getString("triggerid");
                woensdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String woensdag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(3-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res8 = connector.getData(woensdag2);    
try { while (res8.next()) {
                String strnaam = res8.getString("triggerid");
                woensdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
woensdagint3 = woensdagint - woensdagint2 +1;

String donderdag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(4-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res4 = connector.getData(donderdag1);    
try { while (res4.next()) {
                String strnaam = res4.getString("triggerid");
                donderdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String donderdag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(4-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res9 = connector.getData(donderdag2);    
try { while (res9.next()) {
                String strnaam = res9.getString("triggerid");
                donderdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
donderdagint3 = donderdagint - donderdagint2 +1;

String vrijdag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(5-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res5 = connector.getData(vrijdag1);    
try { while (res5.next()) {
                String strnaam = res5.getString("triggerid");
                vrijdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String vrijdag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(5-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res10 = connector.getData(vrijdag2);    
try { while (res10.next()) {
                String strnaam = res10.getString("triggerid");
                vrijdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
vrijdagint3 = vrijdagint - vrijdagint2 +1;

String zaterdag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(6-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res11 = connector.getData(zaterdag1);    
try { while (res11.next()) {
                String strnaam = res11.getString("triggerid");
                zaterdagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String zaterdag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(6-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res12 = connector.getData(zaterdag2);    
try { while (res12.next()) {
                String strnaam = res12.getString("triggerid");
                zaterdagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
zaterdagint3 = zaterdagint - zaterdagint2 +1;

String zondag1 = "SELECT MAX(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(7-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res13 = connector.getData(zondag1);    
try { while (res13.next()) {
                String strnaam = res13.getString("triggerid");
                zondagint = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
String zondag2 = "SELECT MIN(TriggerID) TriggerID from meting_bewegingsensor where EXTRACT(DAY FROM BewegingTijd)= "+(day +(7-dayofweekint))+" and EXTRACT(MONTH FROM BewegingTijd)="+month+"";        
 ResultSet res14 = connector.getData(zondag2);    
try { while (res14.next()) {
                String strnaam = res14.getString("triggerid");
                zondagint2 = Integer.parseInt(strnaam);}
        } catch (SQLException e) {
            e.printStackTrace();} 
zondagint3 = zondagint - zondagint2 +1;

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Aantal Personen per dag");       
        series1.getData().add(new XYChart.Data(maandag, maandagint3));
        series1.getData().add(new XYChart.Data(dinsdag, dinsdagint3));
        series1.getData().add(new XYChart.Data(woensdag, woensdagint3));
        series1.getData().add(new XYChart.Data(donderdag, donderdagint3));
        series1.getData().add(new XYChart.Data(vrijdag, vrijdagint3));   
        series1.getData().add(new XYChart.Data(zaterdag, zaterdagint3));
        series1.getData().add(new XYChart.Data(zondag, zondagint3));
        
  
        
     button1.setOnAction(event -> {
            p.getChildren().clear();
            new Grafiek2 (p);    
       });
     buttonrefresh.setOnAction(event -> {
            p.getChildren().clear();
            new Grafiek1 (p);    
       });
       bc.getData().addAll(series1);
        p.getChildren().addAll(bc, button1, button2, buttonrefresh);
    }

}