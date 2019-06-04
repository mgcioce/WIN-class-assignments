import library.items.Loanable;
import library.items.Item;

public class Driver {

    public static void main(String[] args) {
        System.out.println(Item.Book.THE_CAT_IN_THE_HAT.toString());
        //or
        System.out.println(Loanable.Book.THE_CAT_IN_THE_HAT.toString());

    }
}
