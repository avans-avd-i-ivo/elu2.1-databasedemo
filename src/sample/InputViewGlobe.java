package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class InputViewGlobe {

    private ShapeInterface shapes;

    public InputViewGlobe(ShapeInterface shapes) { this.shapes = shapes; }

    public Parent getView() {
        Label shapeText = new Label("Globe");
        shapeText.setFont(Font.font("Verdana, FontWeight.BOLD", 30));
        Label nameText = new Label("Name: ");
        TextField nameField = new TextField();
        Label radiusText = new Label("Radius: ");
        TextField radiusField = new TextField();

        Button addButton = new Button("Add globe!");
        addButton.setOnAction((event) -> {
            int radiusInt = Integer.parseInt(radiusField.getText());
            shapes.save(new Globe(nameField.getText(), shapeText.getText(), radiusInt));
            nameField.clear();
            radiusField.clear();
        });

        GridPane layout = new GridPane();
        layout.add(shapeText, 0, 0);
        layout.add(nameText, 0, 1);
        layout.add(nameField, 1, 1);
        layout.add(radiusText, 0, 2);
        layout.add(radiusField, 1, 2);
        layout.add(addButton, 1, 3, 2, 2);

        // Add some style to the ui
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        return layout;
    }
}