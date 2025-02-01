import legacyFileSystem.LegacyFileSystem;
import newFileSystem.CloudStorage;

public class CloudStorageAdapter implements LegacyFileSystem  {
    private final CloudStorage cloudStorage;

    public CloudStorageAdapter(CloudStorage cloudStorage) {
        this.cloudStorage = cloudStorage;
    }

    @Override
    public void readFile(String filePath) {
        cloudStorage.download(filePath);
    }

    @Override
    public void writeFile(String filePath, String data) {
        cloudStorage.upload(filePath, data);
    }
}
