package pieChart.core;

import pieChart.view.barChart.BarChartViewModel;
import pieChart.view.piechart.PieChartViewModel;
import pieChart.view.textChart.TextChartViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;
    private TextChartViewModel textChartViewModel;
    private BarChartViewModel barChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textChartViewModel = new TextChartViewModel(modelFactory.getDataModel());
        barChartViewModel = new BarChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public TextChartViewModel getTextChartViewModel() {
        return textChartViewModel;
    }

    public BarChartViewModel getBarChartViewModel() {
        return barChartViewModel;
    }
}
