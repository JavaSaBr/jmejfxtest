package jmejfxtest;

import com.jme3.jfx.injfx.JmeToJfxIntegrator;
import com.jme3.system.AppSettings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage fxWindow) {

        var imageView = new ImageView();

        var settings = JmeToJfxIntegrator.prepareSettings(new AppSettings(true), 60);

        var jmeApplication = new JmeApplication();
        jmeApplication.setSettings(settings);
        jmeApplication.setShowSettings(false);

        var root = new VBox(imageView, new Button("Button 1"), new TextField("Field 2"));
        var fxScene = new Scene(root, 640, 480);

        imageView.fitWidthProperty().bind(fxScene.widthProperty());
        imageView.fitHeightProperty().bind(fxScene.heightProperty().divide(2));

        fxWindow.setScene(fxScene);
        fxWindow.show();
        fxWindow.setOnCloseRequest(event -> System.exit(0));

        JmeToJfxIntegrator.startAndBindMainViewPort(jmeApplication, imageView, Thread::new);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
