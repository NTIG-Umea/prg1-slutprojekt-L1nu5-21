import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static boolean running;
    static ArrayList<String> mapList = new ArrayList<>();

    public static Scanner createFileScanner() {
        Scanner scan;
        try {
            scan = new Scanner(new File("./src/map.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
        return scan;
    }

    public static ArrayList readMap() {
        Scanner skan = createFileScanner();
        while (skan.hasNext()) {
            mapList.add(skan.nextLine());
        }
        return mapList;
    }

    public static void mapDraw() {

    }

    public static void main(String[] args) {
        while (running) {
            mapDraw();
            // ask for input
        }
    }

    public void keyPressed(KeyEvent e) {

    }
}
