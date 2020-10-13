package sample;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    private PersonWarehouse warehouse;

    @Override
    public void init() throws Exception {
        // 1. Create the model that the application uses
//        this.warehouse = new MemoryPersonWarehouse();
        this.warehouse = new DatabasePersonWarehouse();
    }

    @Override
    public void start(Stage window) throws Exception {


        // 2. Create the views ("subviews")
        InputView inputView = new InputView(warehouse);
        SearchView searchView = new SearchView(warehouse);
        ListPersonView listPersonView = new ListPersonView(warehouse);

        // 3. Create the higher level layout
//        BorderPane mainPane = new BorderPane();
        TabPane mainPane = new TabPane();

        // 3.1. Create the menu for the general layout
        boolean doHorizontalMenu = true; // for vertical menu set to false.
        mainPane.setSide(doHorizontalMenu ? Side.TOP : Side.LEFT);

//        HBox hBox = new HBox();
//        hBox.setSpacing(10);
//        VBox vBox = new VBox();
//        vBox.setSpacing(10);
//        Pane menu = doHorizontalMenu ? hBox : vBox;
//
//        menu.setStyle("-fx-background-color: #336699;");
//        menu.setPadding(new Insets(20, 20, 20, 20));

        // 3.2. Create the menu buttons
//        Button enterButton = new Button("Enter new person:");
//        Button searchButton = new Button("Search");
        Tab enterPerson = new Tab("Enter Person", inputView.getView());
        Tab searchPerson = new Tab("Search Person", searchView.getView());
        Tab listPersons = new Tab("List", listPersonView.getView());
        mainPane.getTabs().add(enterPerson);
        mainPane.getTabs().add(searchPerson);
        mainPane.getTabs().add(listPersons);
//        mainPane.getTabs().add(new Tab("TableView", buildTableView()));

        // 3.3. Add the buttons to the menu
//        menu.getChildren().addAll(enterButton, searchButton);
//        if (doHorizontalMenu) {
//            // horizontal menu on top
//            mainPane.setTop(menu);
//        } else {
//            // vertical menu on left
//            mainPane.setLeft(menu);
//        }

        // 4. Connect the subviews with the buttons. Clicking menu buttons changes the subview.
//        enterButton.setOnAction((event) -> mainPane.setCenter(inputView.getView()));
//        searchButton.setOnAction((event) -> mainPane.setCenter(searchView.getView()));

        // 5. First show the input view
//        mainPane.setCenter(inputView.getView());
        mainPane.getSelectionModel().select(enterPerson);

        // 6. Create the main view and add the high level layout
        Scene view = new Scene(mainPane);

        // 7. Show the application
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
