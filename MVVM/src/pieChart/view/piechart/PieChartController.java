package pieChart.view.piechart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class PieChartController {

    @FXML
    Label eventLabel;

    @FXML
    PieChart pieChart;

    private PieChartViewModel viewModel;

    private PieChart.Data red = new PieChart.Data("Red", 0);
    private PieChart.Data yellow = new PieChart.Data("Yellow", 0);
    private PieChart.Data green = new PieChart.Data("Green", 0);

    public PieChartController() {
    }

    public void init(PieChartViewModel pieChartViewModel) {
        this.viewModel = pieChartViewModel;

        red.pieValueProperty().bind(viewModel.xProperty());

        yellow.pieValueProperty().bind(viewModel.yProperty());
        green.pieValueProperty().bind(viewModel.zProperty());

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        ObservableList<PieChart.Data> datas = FXCollections.observableArrayList(red, yellow, green);
        pieChart.setData(datas);
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updatePieChart();
    }
}
