package com.urise.webapp.storage;

import com.urise.webapp.storage.serialiser.JsonStreamSerializer;
import com.urise.webapp.storage.serialiser.XmlStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest{
    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}