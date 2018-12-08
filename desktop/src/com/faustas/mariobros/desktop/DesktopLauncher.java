package com.faustas.mariobros.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.faustas.mariobros.MarioBros;
import com.faustas.mariobros.controller.EditorController;
import com.faustas.mariobros.events.RunCommandsEvent;
import com.faustas.mariobros.tools.EventDispatcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class DesktopLauncher extends Application {

    private static Thread gameThread;

    private EventDispatcher eventDispatcher = EventDispatcher.getInstance();

	public static void main (String[] args) {
	    gameThread = new Thread(() -> {
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
            config.width = 1200;
            config.height = 624;
            new LwjglApplication(new MarioBros(), config);
        });
	    gameThread.start();

        launch(args);

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("fxml/editor.fxml").toURI().toURL());
        fxmlLoader.setController(new EditorController(
                commands -> eventDispatcher.dispatch(new RunCommandsEvent(commands))
        ));

        Parent root = fxmlLoader.load();
		primaryStage.setScene(new Scene(root, 600, 400));

		primaryStage.show();
	}
}
