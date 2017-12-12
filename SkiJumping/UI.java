
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    Game game;

    public UI() {
        scanner = new Scanner(System.in);
        game = new Game();
    }

    void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        game.readNames();
        
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
        
        game.play();
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        game.results();
    }
    
    
}
