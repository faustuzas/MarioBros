package com.faustas.mariobros.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.util.function.Consumer;

public class EditorController {

    private Consumer<String> onGo;

    @FXML
    Button goButton;

    @FXML
    Button resetButton;

    @FXML
    TextArea commandEditor;

    public EditorController(Consumer<String> onGoHandler) {
        this.onGo = onGoHandler;
    }

    @FXML
    public void initialize() {
        goButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            onGo.accept(commandEditor.getText());
        });

        resetButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            commandEditor.setText("");
        });
    }
}
