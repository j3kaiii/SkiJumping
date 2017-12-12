
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Jumper implements Comparable<Jumper>{
    private String name;
    private int points;
    private Random random;
    private ArrayList<Integer> votes;
    private ArrayList<Integer> jumps;
    
    public Jumper(String name) {
        this.name = name;
        points = 0;
        random = new Random();
        votes = new ArrayList<Integer>();
        jumps = new ArrayList<Integer>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.getPoints();
    }
    
    public void countLength() {
        int length = random.nextInt(60) + 60;
        System.out.println("    length: " + length);
        jumps.add(length);
        this.points += length;
        //System.out.println("points " + this.points);
    }
    
    public void countVotes() {
        votes.clear();
        System.out.print("    judge votes: [");
        for (int i = 0; i < 5; i++) {
            int vote = random.nextInt(10) + 10;
            votes.add(vote);
            if (i == 4) System.out.println(vote + "]");
            else System.out.print(vote + ", ");
        }
        Collections.sort(votes);
        for (int i = 1; i < 4; i++) {
            this.points += votes.get(i);
            //System.out.println("points " + this.points);
        }
    }
    
    public String jumpLength() {
        String result = "";
        for (int i = 0; i < jumps.size(); i++) {
            if (i == jumps.size() - 1) result += jumps.get(i) + " m";
            else result += jumps.get(i) + " m,";
        }
        return result;
    }
}
