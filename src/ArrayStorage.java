import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume resume) {
        storage[size++] = resume;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                index = i;
            }
        }

        int numMoved = size - index - 1;
        if (index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
            storage[--size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
