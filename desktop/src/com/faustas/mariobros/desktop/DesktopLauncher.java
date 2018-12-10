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
    private EventDispatcher eventDispatcher = EventDispatcher.getInstance();

	public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1200;
        config.height = 624;
        new LwjglApplication(new MarioBros(), config);

        Thread editorThread = new Thread(() -> launch(args));
        editorThread.start();

        try {
            editorThread.join();
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
