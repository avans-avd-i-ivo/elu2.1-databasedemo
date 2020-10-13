package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SearchView {
    private PersonWarehouse warehouse;

    public SearchView(PersonWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Parent getView() {
        Label ssnText = new Label("Social security number: ");
        TextField ssnField = new TextField();
        Label found = new Label();
        found.setFont(new Font(16));

        Button searchButton = new Button("Search person");
        searchButton.setOnAction((event) -> {
            Person person = warehouse.search(ssnField.getText());
            found.setText("Found: " + person);
        });

        GridPane layout = new GridPane();
        layout.add(ssnText, 0, 0);
        layout.add(ssnField, 0, 1);
        layout.add(searchButton, 1, 1);
        layout.add(found, 0, 2, 2, 1);

        // Add some style to the ui
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        return layout;
    }
}
