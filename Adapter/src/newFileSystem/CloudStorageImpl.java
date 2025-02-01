package newFileSystem;

public class CloudStorageImpl implements CloudStorage {
    @Override
    public void download(String filePath) {
        System.out.println("Download data from " + filePath);
    }

    @Override
    public void upload(String filePath, String data) {
        System.out.println("Upload data to " + filePath + " " + data);
    }
}
