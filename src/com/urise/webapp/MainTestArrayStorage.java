package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1", "Name1");
        Resume r2 = new Resume("uuid2", "Name2");
        Resume r3 = new Resume("uuid3", "Name3");
        Resume r4 = new Resume("uuid4", "Name4");
        Resume r5 = new Resume("uuid5", "Name5");
        Resume r6 = new Resume("uuid6", "Name6");

        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r6);
        ARRAY_STORAGE.save(r4);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r2.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }

}
