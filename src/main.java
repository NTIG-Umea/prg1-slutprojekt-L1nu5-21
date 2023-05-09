import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static int oldX;
    static int x;
    static int oldY;
    static int y;
    static int currentRoomNumber = 1;
    Scanner kb = new Scanner(System.in);
    static ArrayList<String> mapList = new ArrayList<>();
    static ArrayList<String> currentRoom = new ArrayList<>();

    public static Scanner createFileScanner() {
        Scanner scan;
        try {
            scan = new Scanner(new File("./src/map.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return scan;
    }

    public static ArrayList readFile() {
        Scanner skan = createFileScanner();
        while (skan.hasNext()) {
            mapList.add(skan.nextLine());
        }
        return mapList;
    }

    public static ArrayList readRoom() {
        for (int i = 0; i < mapList.size(); i++) {
            if (mapList.get(i).contains("room "+currentRoomNumber)){
                i++;
                while (mapList.get(i).contains("x")) {
                    currentRoom.add(mapList.get(i));
                    i++;
                }
            }
        }
        return currentRoom;
    }

    public static void drawRoom() {
        for (int i = 0; i < currentRoom.size(); i++) {
            System.out.println(currentRoom.get(i));
        }

    }

    public static String swapChar(String in, int p1, int p2) {
        String ut = "";
        char ch1C = in.charAt(p1);
        char ch2C = in.charAt(p2);
        ut = in.substring(0, p1) + ch2C + in.substring(p1+1, p2) + ch1C;
        if (in.length() != p2+1) ut += in.substring(p1 + 1);
        return ut;
    }

    public static void main(String[] args) {
        readFile();
        readRoom();
        drawRoom();
        /*String test = "asliufhj";
        System.out.println(test);
        test = swapChar(test,2,4);
        System.out.println(test);*/
    }
}