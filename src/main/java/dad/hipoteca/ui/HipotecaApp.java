package dad.hipoteca.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HipotecaApp extends Application {

    private RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hipoteca");
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();
    }
}
