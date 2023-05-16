import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Player player;
    static int currentRoomNumber = 2;
    static Scanner kb = new Scanner(System.in);
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
                while (!mapList.get(i).isEmpty()) {
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

    public static String swapChar(String in, int xPosition1, int xPosition2) {
        String ut;
        char ch1C = in.charAt(xPosition1);
        char ch2C = in.charAt(xPosition2);
        ut = in.substring(0, xPosition1) + ch2C + in.substring(xPosition1+1, xPosition2) + ch1C;
        if (in.length() != xPosition2+1) ut += in.substring(xPosition2 + 1);
        return ut;
    }

    public static void swapCharBetweenStrings(int xPosition1, int xPosition2, int yPosition1, int yPosition2) {
        String ut1;
        String ut2 = "";
        char ch1C = currentRoom.get(yPosition1).charAt(xPosition1);
        char ch2C = currentRoom.get(yPosition2).charAt(xPosition2);

        if (yPosition1 != yPosition2) {
            ut1 = currentRoom.get(yPosition1).substring(0, xPosition1) + ch2C + currentRoom.get(yPosition1).substring(xPosition1 + 1);
            ut2 = currentRoom.get(yPosition2).substring(0, xPosition2) + ch1C + currentRoom.get(yPosition2).substring(xPosition2 + 1);

            currentRoom.add(yPosition2, ut2);
            currentRoom.add(yPosition1, ut1);
        } else {
            ut1 = currentRoom.get(yPosition1).substring(0, xPosition1) + ch2C + currentRoom.get(yPosition1).substring(xPosition1+1, xPosition2) + ch1C;
            if (currentRoom.get(yPosition1).length() != xPosition2+1) ut1 += currentRoom.get(yPosition1).substring(xPosition2+1);

            currentRoom.add(yPosition1, ut1);
        }
    }

    public static void update() {
        System.out.println("Insert command: ");
        String commnad = kb.nextLine();
        if (commnad.equals("Command list")) {
            System.out.println(" ... ");
        } else if (commnad.equals("up")) {
            swapCharBetweenStrings(player.x, player.x, player.y, player.y-1);
        }
        drawRoom();
    }

    public static void placePlayer() {
        String playerPosition = "";
        playerPosition = currentRoom.get(player.y).substring(0, player.x) + player.symbol;
        if (currentRoom.get(player.y).length() != player.x+1) playerPosition += currentRoom.get(player.y).substring(player.x+1);
        currentRoom.add(player.y,playerPosition);
    }

    public static void main(String[] args) {
        boolean running = true;
        readFile();
        readRoom();
        placePlayer();
        drawRoom();
        while (running) {
            update();
        }
    }
}