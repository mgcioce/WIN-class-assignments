import java.util.HashMap;
import java.util.Scanner;

public class HashMapPractice {

    private HashMap<String,String> hashmap;
    private final String[] KEYS = {"name","age","hometown","favoriteFood"};

    public HashMapPractice() {
        this.hashmap = new HashMap<>();
        buildHashMap(this.hashmap);
    }

    private void buildHashMap(HashMap<String,String> hashmap) {
        Scanner kb = new Scanner(System.in);
        String[] prompts = {"Hey! I need to introduce you to your adoring fans",
                            "What's your first and last name?",
                            "What's your age?",
                            "What's your hometown?",
                            "What's your favorite food?"};

        for (int i = 0; i < prompts.length; i++) {
            System.out.println(prompts[i]);
            if (i != 0) {
                hashmap.put(KEYS[i-1],kb.nextLine());
            }
        }
        System.out.println("Ok! I'll let them know. Thanks!\n");
    }

    @Override
    public String toString() {
        String returnString = "***15 minutes later***\n\nLadies and Gentlemen! Our next act needs no" +
                                "introduction.\n\n" + "This " + this.hashmap.get(this.KEYS[1]) +
                                " year old loves " + this.hashmap.get(this.KEYS[3]) +
                                ". Please welcome, the pride of " + this.hashmap.get(this.KEYS[2]) +
                                ": " + this.hashmap.get(this.KEYS[0]).toUpperCase() + "!";
        return returnString;
    }
}
