package service;

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
            String fileName = "src/main/resources/output.json";
            Path path = Paths.get(fileName);
            Scanner scanner = new Scanner(path);
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
            }
            scanner.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) throws Exception {
        TestToGetJsonFromDB.create();
        System.out.println(getJsonToString());
    }
}
