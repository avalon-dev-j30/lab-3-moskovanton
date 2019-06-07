package ru.avalon.java.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Действие, которое удаляет файлы в пределах дискового
 * пространства.
 */
public class FileDeleteAction implements Action {
    /**
     * {@inheritDoc}
     */
    private final Path deleteFrom;

    public FileDeleteAction(String deleteFrom) throws IOException {
        this.deleteFrom = Paths.get(deleteFrom);
    }
    
    private synchronized void delete() throws IOException {

        if (!Files.exists(deleteFrom)) {
            System.out.println("Файл не найден.");
        } else {
            Files.delete(deleteFrom);
            System.out.println("Файл удален.");
        }
    }
    
    @Override
    public void run() {
        try {
            delete();
        } catch (IOException e) {
            System.out.println("Удаление не удалось: " + e.getMessage() + ".");  
        }
        System.out.print("> ");
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
