import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage overflow");
        } else if (check(resume.getUuid())){
            System.out.println("Resume is already exists");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        if (check(uuid)) {
            return storage[index];
        } else {
            System.out.println("Resume doesn`t exist");
            return null;
        }
    }

    public void delete(String uuid) {
        if (check(uuid)) {
            int numMoved = size - index - 1;
            System.arraycopy(storage, index + 1, storage, index, numMoved);
            storage[--size] = null;
        } else {
            System.out.println("Resume doesn`t exist");
        }
    }

    public void update(Resume resume) {
        if (check(resume.getUuid())) {
            storage[index] = resume;
        } else {
            System.out.println("resume doesn`t exist");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    boolean check(String uuid) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                check = true;
                index = i;
            }
        }
        return check;
    }
}
