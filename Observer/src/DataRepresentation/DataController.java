package DataRepresentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DataController implements Initializable {
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;
    private DataModel dataModel = new DataModel();

    private Pie_Chart pie = new Pie_Chart(dataModel);
    private BarGraph barGraph = new BarGraph(dataModel);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPieChart();
        showBarGraph();
    }

    @FXML
    private void showPieChart() {
        // Creating Data for pie chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Red", 15),
                new PieChart.Data("Green", 35),
                new PieChart.Data("Yellow", 55)
        );

        // creating pie chart object

        pieChart.setTitle("Colour Value");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);


        // adding data to Pie Chart
        pieChart.getData().addAll(pieChartData);
    }


    @FXML
    void showBarGraph() {
//        ObservableList<String> colours = FXCollections.observableArrayList("Red", "Green", "Yellow");
//        CategoryAxis xAxis = new CategoryAxis(colours);
//
//        NumberAxis yAxis = new NumberAxis();

        XYChart.Series<String, Number> series = new XYChart.Series<>(
                FXCollections.observableArrayList(
                        new XYChart.Data<>("Red", 15),
                        new XYChart.Data<>("Green", 25),
                        new XYChart.Data<>("Yellow", 35)
                )
        );


        barChart.setTitle("Colour Value");
        barChart.getData().add(series);
    }

    @FXML
    private void reCalculateData(ActionEvent actionEvent) {
        dataModel.recalculateData();
        changeData();
    }

    @FXML
    private void changeData() {
        // changing data of pie chart
        pieChart.getData().get(0).setPieValue(pie.getRed());
        pieChart.getData().get(1).setPieValue(pie.getGreen());
        pieChart.getData().get(2).setPieValue(pie.getYellow());



        // changing data of bar chart
        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList(
                new XYChart.Data<>("Red", barGraph.getRed()),
                new XYChart.Data<>("Green", barGraph.getGreen()),
                new XYChart.Data<>("Yellow", barGraph.getYellow())
        );
        barChart.getData().get(0).setData(data);

    }
}
