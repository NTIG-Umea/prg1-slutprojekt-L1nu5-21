import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Player player = new Player();
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
        System.out.println("");
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
        String ut2;
        String word1 = currentRoom.get(yPosition1);
        String word2 = currentRoom.get(yPosition2);
        char ch1C = word1.charAt(xPosition1);
        char ch2C = word2.charAt(xPosition2);

        if (yPosition1 != yPosition2) {
            ut1 = word1.substring(0, xPosition1) + ch2C + word1.substring(xPosition1 + 1);
            ut2 = word2.substring(0, xPosition2) + ch1C + word2.substring(xPosition2 + 1);

            currentRoom.set(yPosition2, ut2);
            currentRoom.set(yPosition1, ut1);
        } else if (xPosition2 < xPosition1) {
            ut1 = word1.substring(0, xPosition2) + ch1C + word1.substring(xPosition2+1, xPosition1) + ch2C;
            if (word1.length() != xPosition1+1) {
                ut1 += word1.substring(xPosition1+1);
                currentRoom.set(yPosition1, ut1);
            }
        } else {
            ut1 = word1.substring(0, xPosition1) + ch2C + word1.substring(xPosition1+1, xPosition2) + ch1C;
            if (word1.length() != xPosition2+1) ut1 += word1.substring(xPosition2+1);

            currentRoom.set(yPosition1, ut1);
        }
        player.x = xPosition2;
        player.y = yPosition2;
    }

    public static void update() {
        System.out.println("Insert command: ");
        String commnad = kb.nextLine();
        if (commnad.equals("Command list")) {
            System.out.println(" ... ");
        } else if (commnad.equals("up")) {
            swapCharBetweenStrings(player.x, player.x, player.y, player.y-1);
        } else if (commnad.equals("down")) {
            swapCharBetweenStrings(player.x, player.x, player.y, player.y+1);
        } else if (commnad.equals("right")) {
            swapCharBetweenStrings(player.x, player.x+1, player.y, player.y);
        } else if (commnad.equals("left")) {
            swapCharBetweenStrings(player.x, player.x-1, player.y, player.y);
        } else {
            System.out.println("Invalid command!");
        }
        drawRoom();
    }

    public static void placePlayer() {
        String playerPosition = "";
        playerPosition = currentRoom.get(player.y).substring(0, player.x) + player.symbol;
        if (currentRoom.get(player.y).length() != player.x+1) playerPosition += currentRoom.get(player.y).substring(player.x+1);
        currentRoom.remove(player.y);
        currentRoom.add(player.y,playerPosition);
    }

    public static void main(String[] args) {
        boolean running = true;
        main spel = new main();
        spel.readFile();
        readRoom();
        placePlayer();
        drawRoom();
        while (running) {
            update();
        }
    }
}