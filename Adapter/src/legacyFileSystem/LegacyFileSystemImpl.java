package legacyFileSystem;

public class LegacyFileSystemImpl implements LegacyFileSystem {
    @Override
    public void readFile(String filePath) {
        System.out.println("Read data from file: " + filePath);
    }

    @Override
    public void writeFile(String filePath, String data) {
        System.out.println("Write data to file: " + filePath + " " + data);
    }
}
