import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public void save(Resume resume) {
        if (!check(resume) && size != storage.length) {
            storage[size++] = resume;
        } else {
            System.out.println("resume is already exists");
        }
    }

    public Resume get(String uuid) {
        Resume resume;

        if (check(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    resume = storage[i];
                }
            }
        } else {
            System.out.println("resume doesn`t exist");
        }
        return null;
    }

    public void delete(String uuid) {
        if (check(uuid)) {
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
        } else {
            System.out.println("resume doesn`t exist");
        }
    }

    public void update(Resume resume) {
        if (check(resume)) {
            int index = -1;

            for (int i = 0; i < size; i++) {
                if (resume.uuid.equals(storage[i].uuid)) {
                    index = i;
                }
                storage[index] = resume;
            }

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

    boolean check(Resume resume) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (resume.uuid.equals(storage[i].uuid)) {
                check = true;
            }
        }
        return check;
    }

    boolean check(String uuid) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                check = true;
            }
        }
        return check;
    }
}
