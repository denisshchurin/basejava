import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public int getSize() {
        return size;
    }

    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                size += 1;
                break;
            }
        }
    }

    Resume get(String uuid) {
//        int size = size();
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {

        int number = 0;
        boolean presence = false;
//        int size = size();
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                number = i;
                presence = true;
            }
        }

        if (presence) {
//            for (int i = number; i < size; i++) {
//                storage[i] = storage[i + 1];
//            }
            Resume[] tempArray = new Resume[size - 1];
            System.arraycopy(storage, 0, tempArray, 0, number);
            System.arraycopy(storage, number + 1, tempArray, number, size - number - 1);
            storage = tempArray;
            size -= 1;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

//    int size() {
//        int size = 0;
//        for (int i = 0; i < storage.length; i++) {
//            if (storage[i] != null) {
//                size += 1;
//            } else break;
//        }
//        return size;
//    }
}
