package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractStorageTest {
    private Storage storage;

    public AbstractStorageTest() {
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }


    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume resume1 = new Resume(UUID_1);
    private static final Resume resume2 = new Resume(UUID_2);
    private static final Resume resume3 = new Resume(UUID_3);

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume("uuid3");
        storage.update(resume3);
        Assert.assertEquals(resume, resume3);
    }

    @Test
    public void getAll() throws Exception {
        Resume[] storageTest = {resume1, resume2, resume3};
        Assert.assertArrayEquals(storageTest, storage.getAll());
    }

    @Test
    public void save() throws Exception {
        Resume resume4 = new Resume("uuid4");
        storage.save(resume4);
        Assert.assertEquals(4, storage.size());
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void getOverflow() throws Exception {

        try {
            for (int i = 3; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid" + i + 1));
            }
        } catch (StorageException e) {
            Assert.fail("StorageException before storage overflow");
        }
        storage.save(new Resume("uuid10001"));
    }

    /* логика реализации теста на переполнение массива (StorageException):
    заполняем массив, но не вызываем у него переполнение
    если исключение вылетит раньше, чем массив будет заполнен, то тест должен провалиться (см. Assert.fail())
    если исключение вылетает, когда пытаемся добавить в полностью заполненный массив еще одно резюме - тест пройден */


}