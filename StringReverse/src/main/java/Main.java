/**
 * Copyright (C) 2017 Mark Pro.
 */

/**
 * Main class.
 *
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter in a string and I will reverse it for you!\n{~}> ");
        // Try with grabbing input and auto-close scanner at the end of the try block
        try(java.util.Scanner input = new java.util.Scanner(System.in)) {

            //Read in the line from the user
            String s = input.nextLine();

            // Split the tokens and set up a reverse token array
            String[] tokens = s.split(" ");
            String reversedTokens = "";

            // Reverse the tokens
            for(int i = 0; i < tokens.length; i++)
                reversedTokens += String.format("%s ", tokens[tokens.length - 1 - i]);
            
            // print out the reversed tokens
            System.out.println(reversedTokens);
        }
        catch (Exception e) {
            System.out.printf("Looks like something went wrong: %s", e.getMessage());
        }
    }
}
