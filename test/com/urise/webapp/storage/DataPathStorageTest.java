package com.urise.webapp.storage;

import com.urise.webapp.storage.serialiser.DataStreamSerializer;
import com.urise.webapp.storage.serialiser.ObjectStreamSerialiser;

public class DataPathStorageTest extends AbstractStorageTest{
    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}