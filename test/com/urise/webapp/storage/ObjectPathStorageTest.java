package com.urise.webapp.storage;

import com.urise.webapp.storage.serialiser.ObjectStreamSerialiser;

public class ObjectPathStorageTest extends AbstractStorageTest{
    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerialiser()));
    }
}