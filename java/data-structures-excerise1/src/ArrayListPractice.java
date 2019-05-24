import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice {

    private ArrayList<Animal> animals;

    public ArrayListPractice() {
        this.animals = new ArrayList<>();
        populateArrayList(animals);
    }

    private void populateArrayList(ArrayList<Animal> array) {
        String[] prompts = {"Hi! I'm gonna keep a list of animals for you. How many animals would you" +
                                " like to add?: ",
                            "please enter an animal name: ",
                            "is it your favorite animal? (Y/N)"};
        Scanner kb = new Scanner(System.in);
        Animal next;
        String name;
        boolean fav;
        int n = 1;

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println(prompts[i]);
                n = kb.nextInt();
                kb.nextLine();
            } else {
                fav = false;
                System.out.println(prompts[1]);
                name = kb.nextLine();
                System.out.println(prompts[2]);
                if (kb.nextLine().compareToIgnoreCase("Y") == 0) {
                    fav = true;
                }
                next = new Animal(name,fav);
                array.add(next);
            }
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        for (Animal a: this.animals) {
            if (a.isFavorite()) {
                returnString += a.getAnimalName() + " is my favorite!\n";
            } else {
                returnString += a.getAnimalName() + " is ok i guess.\n";
            }
        }
        return returnString;
    }

    private class Animal {
        private String animalName;
        private boolean favorite;

        public Animal(String animalName, boolean favorite) {
            this.animalName = animalName;
            this.favorite = favorite;
        }

        public boolean isFavorite() {
            return this.favorite;
        }

        public String getAnimalName() {
            return this.animalName;
        }
    }
}
