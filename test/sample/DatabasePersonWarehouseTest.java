package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabasePersonWarehouseTest {

    private final DatabasePersonWarehouse sut = new DatabasePersonWarehouse();

    @Test
    void getAll() {
        assertFalse(sut.getAll().isEmpty());
    }
}