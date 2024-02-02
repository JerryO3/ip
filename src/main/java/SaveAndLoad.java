import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Scanner;

public class SaveAndLoad {


    public static void saveToFile(String filePath, String textToAdd) throws IOException {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(textToAdd);
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

    public static ArrayList<String> readFile(String filePath) throws IOException {
        ArrayList<String> lst = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner s  = new Scanner(f);
            StringBuilder output = new StringBuilder();
            while (s.hasNext()) {
                lst.add(s.nextLine());
            }
            return lst;
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public static ItemList loadFromFile(ArrayList<String> lst) throws CustomExceptions {
        ItemList il = new ItemList();
        for (String s : lst) {
            String[] tmp = s.split("@");
            String[] arr = tmp[1].split("|");
            int index = Integer.parseInt(arr[0]);
            switch (arr.length) {
                case 3:
                    il.addToDo(arr, index);
                    break;
                case 4:
                    il.addDeadline(arr, index);
                    break;
                case 5:
                    il.addEvent(arr, index);
                    break;
            }
        }
        return il;
    }
}
