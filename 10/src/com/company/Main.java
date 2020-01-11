package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //Работа с файлами
        //С точки зрения Java файл и папка это одно и то же
        //Путь к файлу:
        //-Абсолютный - от логического диска
        //-Относительный из текущей паки, относительно исполняемого файла

        File f = new File("C:\\Programs\\1.txt");

        //Метод проверяет существует ли файл
        if (f.exists()) {
            System.out.println("File exists");

        } else {
            System.out.println("File doesn't exists                                                                                                                                                                                                         ");
        }

        //Относительный путь к файлу
        File ff = new File("1.txt");
        if (!ff.exists()) {
            try {
                ff.createNewFile(); //метод генерирует исключение
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(ff.canWrite()); //проверка файла на доступность записи

        ff.compareTo(f); // Метод сравнивает пути объектов (0, -, +)

        /*ff.delete(); //Удаляет файл сразу после вызова
        ff.deleteOnExit(); //Удаляет файл только после завершения программы
        ff.getAbsoluteFile(); //Возвращает файл с абсолютным путем к файлу
        ff.getAbsolutePath(); //Возвращает путьк файлу
        ff.getFreeSpace(); //Возвращает свободное место на диске, на котором записан файл
        ff.getParent(); //Возвращает родительскую директорию файла
        ff.isDirectory(); //Проверяет, это путь к файлу или директории
        ff.lastModified(); //Возвращает время в мс с момента когда файл был изменен*/

        //Работа с папкой
        File dir = new File("C:\\Мульти-Пульти");
        String[] files = dir.list(); //возвращает массив строк, показывающих файлы и папки, содержащиеся по указанному пути (в т.ч. скрытые)

        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        File dir2 = new File("D:\\test\\hello");

        if (!dir2.exists()) { //проверка на существование указанного пути

            //метод mkdir создает только последнюю папку в указанном пути
            //dir2.mkdir();

            //mkdirs созает все папки по указанному пути
            dir2.mkdirs();

        }

        //Чтение содержимого текстового файла
        try {
            FileReader fr = new FileReader(ff); //для чтения файла применяется класс FileReader
            int c = fr.read(); //когда метод завершается, он возвращает значение -1, что позволяет понять когда файл прочитан
            while (c != -1){
                System.out.print((char) c);
                c = fr.read();
            }
            fr.close();//после чтения или записи нужно всегда писать этот метод

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Запись в файл
        String еуче = "I rule the world!!!\nI am cool!!!)\nЯ крутой!!!";

        try {
            FileWriter fw = new FileWriter("2.txt");
            fw.write("I rule the world!!!\nI am cool!!!)\nЯ крутой!!!"); //метод всегда перезаписывает содержимое файла
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Преобразование строки в число

        try {
            FileReader fr2 = new FileReader("input.txt");

            int c = fr2.read();
            String number = "";

            while (c != -1){
                if ((char) c == ' '){
                    int v = Integer.parseInt(number);
                    System.out.println(v * v);
                    number = "";
                }else {
                number += (char)c;
                }
                c = fr2.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
