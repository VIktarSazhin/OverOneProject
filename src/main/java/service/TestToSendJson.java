package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestToSendJson {
    public static String getJsonToString() {
//        String line = "";
//        try {
//            File file = new File("src/main/resources/output.json");
//            FileReader fr = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fr);
//            line = reader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return line;

        String line = "";
        try{
            String fileName = "D:\\Progects\\Tomcattest\\src\\main\\resources\\output.json";
            Path path = Paths.get(fileName);
            Scanner scanner = new Scanner(path);
            //читаем построчно
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }

//    public static void main(String[] args) {
//        System.out.println(readUsingScanner());
//    }

//    public static String readUsingScanner()  {
//        String line = "";
//        try{
//            String fileName = "src/main/resources/output.json";
//            Path path = Paths.get(fileName);
//            Scanner scanner = new Scanner(path);
//            //читаем построчно
//            while(scanner.hasNextLine()){
//                line = scanner.nextLine();
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        return line;
//    }
}
