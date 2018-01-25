package lab4_2;

//Leon You

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class csvgraph extends Application {
 
    final static String corOff = "Correction Officer";
    final static String cap = "Captain";
    final static String ADW = "Assistant Deputy Warden";
    final static String DW = "Deputy Warden";
    final static String Ward = "Warden";
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Department of Correction Average Salaries");
        
        barChart.setTitle("Average Salaries (Leon You Pd. 6 - 7)");
        xAxis.setCategories(FXCollections.<String>observableArrayList( Arrays.asList(corOff,cap,ADW,DW,Ward)));
        
        yAxis.setLabel("Amount in Dollars");
        xAxis.setLabel("Rank");
        
        final XYChart.Series<String, Number> set = new XYChart.Series<String, Number>();
        set.setName("Base Salary");
        set.getData().add(new XYChart.Data<String, Number>(corOff, 69862));
        set.getData().add(new XYChart.Data<String, Number>(cap, 90801));
        set.getData().add(new XYChart.Data<String, Number>(ADW, 110762));
        set.getData().add(new XYChart.Data<String, Number>(DW, 134664));
        set.getData().add(new XYChart.Data<String, Number>(Ward, 171196));
        
        final XYChart.Series<String, Number> set2 = new XYChart.Series<String, Number>();
        set2.setName("Loaded + Fringes");
        set2.getData().add(new XYChart.Data<String, Number>(corOff, 137747));
        set2.getData().add(new XYChart.Data<String, Number>(cap, 175238));
        set2.getData().add(new XYChart.Data<String, Number>(ADW, 216784));
        set2.getData().add(new XYChart.Data<String, Number>(DW, 260906));
        set2.getData().add(new XYChart.Data<String, Number>(Ward, 306864));
        
        Scene scene = new Scene(barChart, 900, 900);
        barChart.getData().addAll(set,set2);
        barChart.setBarGap(3.0);
        barChart.setCategoryGap(50);
        
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
