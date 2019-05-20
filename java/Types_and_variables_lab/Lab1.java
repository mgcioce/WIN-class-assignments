public class Lab1 {
    public static void main(String [] args) {
        int firstInt = 6;
        int secondInt = 20;
        int thirdInt = 0;
        float firstFloat = 4.4f;
        boolean isCold = false;
        double firstDouble = 1_000.00;
        System.out.println(String.format("%d, %d, %f, %b, %f",firstInt,
                            secondInt, firstFloat, isCold,
                            firstDouble));
        System.out.println(firstInt + secondInt);
        System.out.println(firstInt + thirdInt);
        System.out.println(firstInt / secondInt);
        System.out.println(firstInt % secondInt);
        int newInt = (firstInt % secondInt) + firstInt;
        System.out.println(++newInt);
        int x = 100;
        boolean compareX = (x == 100);
        int y = 106;
        System.out.println(String.format("%b, %b, %b",(x > y), 
                            (y > x), x >= (y-6)));
        int z = 92;
        System.out.println(String.format("%b, %b, %b", 
                            ((x > y) && (y < z) ), 
                            ((y < z) && (x >= y)),
                            (z > (y + x) || (x-y) < z)
        ));
        System.out.println( (x < y) == !(x > y));
        int n = 64;
        System.out.println( 32 == n >> 1);
        System.out.println( 128 == n << 1);
        n = 40;
        System.out.println(20 == n >> 1);
        System.out.println(80 == n << 1);
        System.out.println(10 == n >> 2);
        System.out.println(160 == n << 2);
        n = 39;
        System.out.println( n >> 1);
        System.out.println( n << 1);
        System.out.println( n >> 2);
        System.out.println( n << 2);
        anotherMethod();
        playWithStrings();
    }

    public static void anotherMethod() {
        Integer a = new Integer("1000"); //no
        Integer b = new Integer(a.intValue() / 2);
        if (a.compareTo(b) > 0) {
            System.out.println(String.format("%d is a Big Value\n%d is " + 
                                "half of a big value",a.intValue(),b.intValue()));
        } else {
            System.out.println(String.format("%d is Not a big value\n" + 
                                "%d is definitely small",a.intValue(),b.intValue()));
        }
    }

    public static void playWithStrings() {
        String firstName = "Mike";
        String lastName = new String("Cioce");
        System.out.println("Hello " + firstName.concat(lastName));
        String fullName = firstName + " " + lastName;
        int totalLength = fullName.length();
        int index = fullName.indexOf('o');
        char letter = fullName.charAt(7);
        boolean contains = fullName.contains("son");
        String substring = fullName.substring(totalLength - 6);
        boolean apostrophe = fullName.matches("'||-");
        System.out.println(String.format("The total length of the string %s" + 
                            " is %d\n" + 
                            "The index of 'o' is %d\n" +
                            "The letter at index 7 is %c\n" +
                            "does this contain son? %b\n" +
                            "last five characters: %s\n" +
                            "has an apostrophe? %b",
                            fullName, totalLength, index,
                            letter, contains, substring, apostrophe
        ));
    }
}