import legacyFileSystem.LegacyFileSystem;
import legacyFileSystem.LegacyFileSystemImpl;
import newFileSystem.CloudStorageImpl;

public class Main {
    public static void main(String[] args) {
        LegacyFileSystem cloudStorageAdapter = new CloudStorageAdapter(new CloudStorageImpl());
        LegacyFileSystem legacyFileSystem = new LegacyFileSystemImpl();

        cloudStorageAdapter.readFile("file");
        cloudStorageAdapter.writeFile("file", "data");

        legacyFileSystem.readFile("file-1");
        legacyFileSystem.writeFile("file-1", "data-1");
    }
}