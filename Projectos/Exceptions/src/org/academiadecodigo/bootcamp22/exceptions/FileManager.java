package org.academiadecodigo.bootcamp22.exceptions;

public class FileManager {

    private File file;

    private boolean logged;

    private int maxFileSpace;

    private int fileCount;

    private FileManager fileManager;

    public FileManager(int maxFileSpace) {

        this.maxFileSpace = maxFileSpace;
        fileManager = this;
    }

    public File getFile(String fileName) throws FileException {

        return null;

    }

    public void createFile(String fileName) throws FileException {

            if (!logged) {
                throw new NotEnoughPermissionsExceptions("A");
            }

            if (fileCount >= maxFileSpace) {
                throw new NotEnoughSpaceException("A");
            }

            file = new File(fileName);
            fileCount++;

    }

    public void login() {

        logged = true;
    }

    public void logout() {

        logged = false;
    }
}
