package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {

        try {
            for (int i = 3; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }

    /* логика реализации теста на переполнение массива (StorageException):
    заполняем массив, но не вызываем у него переполнение
    если исключение вылетит раньше, чем массив будет заполнен, то тест должен провалиться (см. Assert.fail())
    если исключение вылетает, когда пытаемся добавить в полностью заполненный массив еще одно резюме - тест пройден */


}