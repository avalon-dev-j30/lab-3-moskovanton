package ru.avalon.java;

import java.io.BufferedReader;
import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.io.InputStreamReader;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileDeleteAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.actions.FileRenameAction;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {
    
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    private String argumentOne;
    private String argumentTwo;
    
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                System.out.println("Копирование файла.");
                System.out.print("Введите путь к файлу: > ");
                argumentOne = reader.readLine();
                System.out.print("Введите путь для копирования: > ");
                argumentTwo = reader.readLine();
                FileCopyAction copy = new FileCopyAction(argumentOne, argumentTwo);
                copy.start();
                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                System.out.println("Перемещение файла.");
                System.out.print("Введите к путь к файлу: > ");
                argumentOne = reader.readLine();
                System.out.print("Введите путь для перемещения: > ");
                argumentTwo = reader.readLine();
                FileMoveAction move = new FileMoveAction(argumentOne, argumentTwo);
                move.start();
                break;
            case delete:
                System.out.println("Удаление файла.");
                System.out.print("Введите к путь к файлу: > ");
                argumentOne = reader.readLine();        
                FileDeleteAction delete = new FileDeleteAction(argumentOne);
                delete.start();
                break;
            case rename:
                System.out.println("Переименование файла.");
                System.out.print("Путь к файлу: >");
                argumentOne = reader.readLine();
                System.out.print("Новое имя файла: >");
                argumentTwo = reader.readLine();                    
                FileRenameAction rename = new FileRenameAction(argumentOne, argumentTwo);
                rename.start();
                break;
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }    
}
