package newFileSystem;

public interface CloudStorage {
    void download(String filePath);
    void upload(String filePath, String data);
}
