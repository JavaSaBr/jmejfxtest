package jmejfxtest;



import com.jme3.jfx.injfx.JmeToJfxApplication;
import com.jme3.jfx.injfx.JmeToJfxIntegrator;
import com.jme3.system.AppSettings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class JmeJfxTest extends Application{
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			MyApplication myapp = new MyApplication();
			myapp.setShowSettings(false);
			myapp.simpleInitApp();
			myapp.start();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
