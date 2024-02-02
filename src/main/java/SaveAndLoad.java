import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Scanner;

public class SaveAndLoad {

    public static void saveToFile(ItemList l) {
        try {
            FileWriter fw = new FileWriter("./data/duke.txt");
            fw.write(toSaveFormat(l));
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static String toSaveFormat(ItemList l) {
        int c = 0;
        String out = "";
        while (c < l.getListOfItems().size()) {
            out += c + "@" + l.getListOfItems().get(c).toSaveFormat() + "\n";
            c++;
        }
        return out.trim();
    }

    private static ArrayList<String> readFile(String filePath) throws IOException {
        ArrayList<String> lst = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner s  = new Scanner(f);
            StringBuilder output = new StringBuilder();
            while (s.hasNext()) {
                lst.add(s.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return lst;
    }

    public static ItemList loadFromFile() {
        ItemList il = new ItemList();
        try {
            for (String s : readFile("./data/duke.txt")) {
                String[] tmp = s.split("@");
                String[] arr = tmp[2].split("\\|");
                int index = Integer.parseInt(tmp[0]);
                boolean isDone = Integer.parseInt(tmp[1]) == 1;
                switch (arr.length) {
                    case 2:
                        il.addToDo(arr, index, isDone);
                        break;
                    case 3:
                        il.addDeadline(arr, index, isDone);
                        break;
                    case 4:
                        il.addEvent(arr, index, isDone);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("No file found, creating new file. ");
        } catch (CustomExceptions e) {
            System.out.println("File Corrupted");
            return new ItemList();
        }
        return il;
    }

}
