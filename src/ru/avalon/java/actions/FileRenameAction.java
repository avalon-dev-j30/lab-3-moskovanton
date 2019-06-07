package ru.avalon.java.actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Действие, которое переименовывает файлы в пределах дискового
 * пространства.
 */
public class FileRenameAction implements Action {

    private final File renameFile;
    private final String newName;

    public FileRenameAction(String file, String name) throws IOException {
        File oldFile = new File(file);
        this.renameFile = oldFile;
        this.newName = name;
    }

    private synchronized void rename() throws IOException {

        if (!renameFile.exists()) {
            System.out.println("Файл не найден.");
        } else {
            Path path = Paths.get(renameFile.getAbsolutePath());
            renameFile.renameTo(new File(path.getParent().toString() + File.separator + newName));
            System.out.println("Переименование успешно.");
        }
    }
    
    @Override
    public void run() {
        try {
            rename();
        } catch (IOException e) {
            System.out.println("Переименование не удалось: " + e.getMessage() + ".");
        }
        System.out.print("> ");
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}