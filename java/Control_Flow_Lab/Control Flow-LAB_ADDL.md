#Control Flow Additional lab.  

This file contains the "interspersed" lab statements for the **Types and Variables** lesson.  The main lesson file will contain instructions such as "Addl Lab #2 here", and that means that in this file, lab #2 *could* be inserted at that point.  

The statements in this file, unlike the full-on lab, are meant to be executed during the lesson at the appropriate times, and flow together.  


### Lab Step #1 (if statements)  
* Create a new java class with a `main()` method like so:
```java
public class MainFile
{
  
  public static void main(String args[]) 
  {
    // scanner reads input from the command line through various methods
    Scanner scanner = new Scanner(System.in);
  
    // prompt and read a string
    System.out.print("Enter your name: ");
    String username = scanner.next();
  
    // prompt and read an int
    System.out.print("Enter your age: ");
    int age = scanner.nextInt();
  
    System.out.println(String.format("Hello %s, your age is %d", username, age));
      
  }
  
}
```
* Run this to make sure it compiles and runs successfully.
* Add a series of `if() statements that will check and output the following:
    - if 16 or older, print "You are old enough to drive"
    - if 18 or older, print "You are old enough to vote"
    - if 21 or older, print "You are old enough to drink"
    - if 35 or older, print "You are old enough to be President"
    - if 55 or older, print "You can join AARP"
    - if 67 or older, print "You can starting drawing Social Security"

* The output should be progressive - if age is 17, only one statement.  If age is 25, three statements, etc.

* Test the statements by entering several different ages and ensuring the correct statements are printed.
* Add else statements to each test that prints the negative of each condition.  In this case there should be 6 statements each run combining both positive and negative responses depending on age.

  

### Lab Step #2 (switch statements)  
* To the statements above add more questions:
    - Prompt the user to enter 'E', 'U', or 'S' for employment status - employed, unemployed, or student.
    - Do you have a car, truck, suv, or do not own a vehicle? (make up your own one letter responses for this).

* Using `switch` statements, print out a sentence for each of the choices above - such as "You are employed" and "You own an SUV".


### Addl Lab Step #3 (for loops)
* declare an integer array with 30 elements
    - `int[] myArray = new int[30];` 
    
* with a `for` loop, initialize the array with the same number as the index. [0] = 0, [1] = 1, etc.
* print out the contents of each element of the array using an enhanced `for`

* with a `for` loop, reassign the elements of the array with the even numbers up to 60.
* print out the contents of each element of the array using an enhanced `for`
* print the contents of the array in reverse order.


### Addl Lab Step #4 (while loops)  
* write the last two statements from the previous step - forward enhanced for and reverse order, using `while` loops.
* Redo the `main()` method shown in step 1, but surround it with a do-while loop.  The last statement in the loop should be a question - "Do you want to answer the questions again?"  Use the input to either do the loop again or quit.  why is a do-while more appropriate than a while?

### Addl Lab Step #5 (branching)  
break, continue, return
* create a void method that takes an integer as an argument.
* in the method, loop through the array created in step 3.  Perform the following
    - if the number is even, print it.
    - if the number is odd, skip it.
    - if the number is equal to the number passed in the method, quit processing.

* run some tests to make sure the methods performs as expected.
* Now change the method signature to return an int.
* change the method as follows:
    - if the number is odd, print it.
    - if the number is even, add it to a running total of even numbers.
    - if the number is equal to the number passed in the method, return the running total sum from the method.

* run some tests, including printing out the return value from the method.



