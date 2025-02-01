package legacyFileSystem;

public interface LegacyFileSystem {
    void readFile(String filePath);
    void writeFile(String filePath, String data);
}
