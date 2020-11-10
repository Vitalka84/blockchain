package blockchain;

import java.io.File;
import java.io.IOException;

public class FileProcessor {
    String filePath;
    File file;

    public FileProcessor(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
        file.getParentFile().mkdirs();
        try {
            boolean createdNew = file.createNewFile();
            if (createdNew) {
                System.out.println("The file was successfully created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            System.out.println("Cannot create the file: " + file.getPath());
            e.printStackTrace();
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }
}
