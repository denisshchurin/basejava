package com.urise.webapp.storage;

public class OblectStreamStorageTest extends AbstractStorageTest{
    public OblectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }
}