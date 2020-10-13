package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {

    private PersonWarehouse warehouse;

    public InputView(PersonWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Parent getView() {
        Label nameText = new Label("Name: ");
        TextField nameField = new TextField();
        Label ssnText = new Label("Social security number: ");
        TextField ssnField = new TextField();

        Button addButton = new Button("Add person to the list of persons...");
        addButton.setOnAction((event) -> {
            warehouse.save(new Person(nameField.getText(), ssnField.getText()));
            nameField.clear();
            ssnField.clear();
        });

        GridPane layout = new GridPane();
        layout.add(nameText, 0, 0);
        layout.add(nameField, 1, 0);
        layout.add(ssnText, 0, 1);
        layout.add(ssnField, 1, 1);

        // addButton in row 3 results in additional 10 pixels vgap
        layout.add(addButton, 0, 3, 2,1);

        // Add some style to the ui
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        return layout;
    }
}
