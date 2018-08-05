package testPath;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Test extends Application {

	public static void main(String[] args) {


		// System.out.println(System.getProperty("sun.arch.data.model"));
		// System.out.println(System.getProperty("java.version"));

		String property = System.getProperty("java.library.path");
		StringTokenizer parser = new StringTokenizer(property, ";");
		while (parser.hasMoreTokens()) {
			System.out.println(parser.nextToken());
		}
		Connection con = null;
		try {
			//DriverManager.registerDriver(new SQLServerDriver());

			con = DriverManager.getConnection("jdbc:sqlserver://NADHEM-PC\\SQLEXPRESS;integratedSecurity=true;");

			DatabaseMetaData meta = con.getMetaData();
			ResultSet res = meta.getCatalogs();
			System.out.println("List of databases: ");
			while (res.next()) {
				System.out.println(" " + res.getString("TABLE_CAT"));
			}
			res.close();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("done");
		// launch(args);
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
