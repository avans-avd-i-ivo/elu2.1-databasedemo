package sample;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ListPersonView {
    private final PersonWarehouse warehouse;

    public ListPersonView(PersonWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Node getView() {

        javafx.scene.control.ListView<Person> listview = new javafx.scene.control.ListView<>();
        listview.setItems(FXCollections.observableList(warehouse.getAll()));

//        Label listview = new Label("ListView under build...");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            warehouse.save(new Person("Test", "123"));
        });

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> listview.setItems(FXCollections.observableList(warehouse.getAll())));

        VBox layout = new VBox();
        layout.getChildren().addAll(listview, addButton, refreshButton);

        return layout;
    }
}
