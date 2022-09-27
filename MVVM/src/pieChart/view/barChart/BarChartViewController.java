package pieChart.view.barChart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class BarChartViewController {

    @FXML
    private Label lastUpdatedLabel;
    @FXML
    private BarChart barChart;
    private XYChart.Data<String, Integer> x = new XYChart.Data<String, Integer>("Red", 0);
    private XYChart.Data<String, Integer> y = new XYChart.Data<String, Integer>("Yellow", 0);
    private XYChart.Data<String, Integer> z = new XYChart.Data<String, Integer>("Green", 0);

    private BarChartViewModel viewModel;

    public void init(BarChartViewModel viewModel) {
        this.viewModel = viewModel;

        x.YValueProperty().bind(viewModel.xProperty());
        y.YValueProperty().bind(viewModel.yProperty());
        z.YValueProperty().bind(viewModel.zProperty());
        lastUpdatedLabel.textProperty().bind(viewModel.timeStampProperty());

        XYChart.Series redSeries = new XYChart.Series<>();
        redSeries.setName("Red");
        redSeries.getData().add(x);
        barChart.getData().add(redSeries);

        XYChart.Series yellowSeries = new XYChart.Series<>();
        yellowSeries.setName("Yellow");
        yellowSeries.getData().add(y);
        barChart.getData().add(yellowSeries);


        XYChart.Series greenSeries = new XYChart.Series<>();
        greenSeries.setName("Green");
        greenSeries.getData().add(z);
        barChart.getData().add(greenSeries);
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateBarChart();
    }
}
