
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game {
    private ArrayList<Jumper> jumpers;
    private ArrayList<Integer> votes;
    private Scanner scanner;
    private int round;
    
    public Game() {
        jumpers = new ArrayList<Jumper>();
        votes = new ArrayList<Integer>();
        scanner = new Scanner(System.in);
        round = 0;
    }
    
    public void readNames() {
        while (true) {
            System.out.print("  Participant name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) break;
            jumpers.add(new Jumper(name));
        }
    }
    
    public void play() {
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = scanner.nextLine();
            if (command.equals("jump")) {
                round++;
                System.out.println("");
                System.out.println("Round " + round);
                System.out.println("");
                System.out.println("Jumping order:");
                jumpersOrder();
                System.out.println("");
                System.out.println("Results of round " + round);
                countPoints();
            
            } else if (command.equals("quit")) {
                System.out.println("");
                System.out.println("Thanks!");
                break;
            }
        }
    }
    
    public void results() {
        int position = 0;
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        for (Jumper j : jumpers) {
            position++;
            System.out.println(position + "           " + j);
            System.out.println("            jump lengths: " + j.jumpLength());
        }
    }

    private void jumpersOrder() {
        Collections.sort(jumpers);
        int order = 1;
        for (Jumper j : jumpers) {
            System.out.println("  " + order + ". " + j);
            order++;
        }
    }
    
    private void countPoints() {
        for (Jumper j : jumpers) {
            System.out.println("  " + j.getName());
            j.countLength();
            j.countVotes();
        }
        System.out.println("");
    }
    
    
}
