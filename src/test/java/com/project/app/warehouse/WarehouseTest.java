package com.project.app.warehouse;

import com.project.app.entity.ArrayParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {

    private Warehouse warehouse;

    @BeforeEach
    public void setUp() {
        warehouse = Warehouse.getInstance();
        warehouse.clear();
    }

    @Test
    public void testSingletonInstance() {
        Warehouse firstInstance = Warehouse.getInstance();
        Warehouse secondInstance = Warehouse.getInstance();
        assertSame(firstInstance, secondInstance, "Warehouse должен быть строгим синглтоном");
    }

    @Test
    public void testPutAndGetParameters() {
        // Given
        ArrayParameters params = new ArrayParameters(10.0, 2.5, 4.0, 1.0);

        // When: Просто вызываем метод, не оборачивая его в assertTrue
        warehouse.put(1, params);
        ArrayParameters savedParams = warehouse.get(1);

        // Then: Проверяем, что параметры успешно достаются со склада
        assertNotNull(savedParams, "Параметры должны сохраниться на складе");
        assertEquals(10.0, savedParams.sum(), 0.001);
        assertEquals(2.5, savedParams.average(), 0.001);
    }

    @Test
    public void testRemoveParameters() {
        // Given
        ArrayParameters params = new ArrayParameters(5.0, 5.0, 5.0, 5.0);
        warehouse.put(5, params);

        // When
        boolean removed = warehouse.remove(5);

        // Then
        assertTrue(removed, "Метод remove должен вернуть true при успешном удалении");
        assertNull(warehouse.get(5), "Параметры должны быть удалены со склада");
    }
}
