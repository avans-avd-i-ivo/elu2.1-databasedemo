package sample;

import javafx.collections.ObservableList;

public interface ObservablePersonWarehouse extends PersonWarehouse{

    // todo: show binding ListView items to an ObservableList
    ObservableList<Person> getObservableList();
}
