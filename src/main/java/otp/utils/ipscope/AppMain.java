package otp.utils.ipscope;

/**
 * Created by user on 03.08.2016.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.input.DataFormat.URL;

import java.util.ArrayList;

import static javafx.scene.input.DataFormat.URL;

public class AppMain extends Application {

    public static void main(String[] args) throws Exception {
        System.getProperty("java.classpath");
        launch(args);
        //System.out.print("Test");
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "fxml/ipscope.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(fxmlFile));

        Controller controller = loader.getController();
        controller.setMainApp(this);

        stage.setTitle("JavaFX and Maven");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public ArrayList<String> getScopeFromIP()
    {
        return null;
    }
}
