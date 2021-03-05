package package1;

import package2.SuperClass;
import packageWeapon.SuperArmor;

import java.io.IOException;


public class Game {
    SuperClass superClass = new SuperClass();
    SuperArmor superArmor = new SuperArmor();
    Story story = new Story(superClass, superArmor);

    public static void main(String[] args) throws InterruptedException, IOException {
          String message = "Hello this game is made by Samuel Rapp. I made this game for coding practice  ";
        System.out.println("\n");
         slowPrint(message, 45);
         new Game();
    }

    public Game() throws IOException {
        System.out.println("\n");
        story.defaultSetup();
    }

    //Method for making the text look like its writing
    public static void slowPrint(String message, long millisPerChar) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));

            try {
                Thread.sleep(millisPerChar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}