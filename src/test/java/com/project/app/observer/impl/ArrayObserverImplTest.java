package com.project.app.observer.impl;

import com.project.app.entity.ArrayParameters;
import com.project.app.entity.DoubleArrayWrapper;
import com.project.app.exception.ArrayValidationException;
import com.project.app.observer.ArrayObserver;
import com.project.app.warehouse.Warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayObserverImplTest {

    private Warehouse warehouse;
    private ArrayObserver observer;

    @BeforeEach
    public void setUp() {
        // Сначала очищаем синглтон (если метод очищает только карту внутри)
        Warehouse.getInstance().clear();
        
        // Получаем свежую и гарантированно правильную ссылку на единственный склад
        this.warehouse = Warehouse.getInstance();

        // ИСПРАВЛЕНО: Никаких сервисов расчетов не передаем! Используем чистый пустой конструктор
        this.observer = new ArrayObserverImpl(); 
    }

    @Test
    public void testAutomaticWarehouseUpdateOnElementChange() throws ArrayValidationException {
        // Given: Создаем массив {1.0, 2.0, 3.0} с ID = 7
        double[] initialElements = {1.0, 2.0, 3.0};
        DoubleArrayWrapper array = new DoubleArrayWrapper(7, initialElements);
        
        // Регистрируем наш наблюдатель в массиве
        array.setObserver(observer);
        
        // Принудительно вызываем первоначальный просчет для стартового заполнения склада
        observer.handleEvent(array);

        // Проверяем, что стартовые параметры успешно записались на склад
        ArrayParameters initialParams = warehouse.get(7);
        assertNotNull(initialParams, "Наблюдатель вообще не записал данные на склад (вернулся null)!");
        assertEquals(6.0, initialParams.sum(), 0.001, "Ошибка стартовой суммы! На складе лежит: " + initialParams);

        // When: Изменяем первый элемент с 1.0 на 7.0! 
        // Внутри setElement() автоматически сработает метод notifyObserver() -> handleEvent()
        array.setElement(0, 7.0); // Новый массив: {7.0, 2.0, 3.0}

        // Then: Проверяем, что склад пересчитал параметры АВТОМАТИЧЕСКИ (Сумма = 12, Среднее = 4)
        ArrayParameters updatedParams = warehouse.get(7);
        assertNotNull(updatedParams, "Склад должен содержать обновленные параметры");
        assertEquals(12.0, updatedParams.sum(), 0.001, "Сумма должна автоматически измениться на 12");
        assertEquals(4.0, updatedParams.average(), 0.001, "Среднее значение должно стать 4");
        assertEquals(7.0, updatedParams.max(), 0.001, "Максимальный элемент должен стать 7");
        assertEquals(2.0, updatedParams.min(), 0.001, "Минимальный элемент должен стать 2");
    }
}
