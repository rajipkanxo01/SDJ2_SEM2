package pieChart.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pieChart.view.barChart.BarChartViewController;
import pieChart.view.piechart.PieChartController;
import pieChart.view.textChart.TextChartController;

import java.io.IOException;

public class ViewHandler {

    private Stage pieChartStage;
    private Stage textChartStage;
    private Stage barChartStage;
    private Scene pieChartScene;
    private Scene textChartScene;
    private Scene barChartScene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception {
        pieChartStage = new Stage();
        textChartStage = new Stage();
        barChartStage = new Stage();

        openPieChartView();
        openTextCharView();
        openBarChartView();

        textChartStage.show();
        pieChartStage.show();
        barChartStage.show();
    }

    public void openPieChartView() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loadFXMLFiles("../view/piechart/PieChartView.fxml", loader);
        PieChartController controller = loader.getController();
        controller.init(viewModelFactory.getPieChartViewModel());

        pieChartScene = new Scene(root);
        pieChartStage.setTitle("Pie Chart");
        pieChartStage.setResizable(false);
        pieChartStage.setScene(pieChartScene);
    }

    public void openTextCharView() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loadFXMLFiles("../view/textChart/TextChart.fxml", loader);
        TextChartController controller = loader.getController();
        controller.init(viewModelFactory.getTextChartViewModel());

        textChartScene = new Scene(root);
        textChartStage.setTitle("Text Chart");
        textChartStage.setResizable(false);
        textChartStage.setScene(textChartScene);
    }

    public void openBarChartView() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Parent root = loadFXMLFiles("../view/barChart/BarChartView.fxml", loader);
        BarChartViewController controller = loader.getController();
        controller.init(viewModelFactory.getBarChartViewModel());

        barChartScene = new Scene(root);
        barChartStage.setTitle("Bar Chart");
        barChartStage.setResizable(false);
        barChartStage.setScene(barChartScene);
    }

    private Parent loadFXMLFiles(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            // loading fxml files in parent instance, containing all GUI elements
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
