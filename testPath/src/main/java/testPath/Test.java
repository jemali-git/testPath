package testPath;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Test extends Application {

	public static void main(String[] args) {
		System.out.println(System.getProperty("sun.arch.data.model"));
		System.out.println(System.getProperty("java.version"));
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(new Button("button"));
		scene.getStylesheets().add(getClass().getResource("/colors.css").toExternalForm());
		primaryStage.setScene(scene);

		primaryStage.setResizable(false);

		primaryStage.sizeToScene();

		primaryStage.show();

	}
}
