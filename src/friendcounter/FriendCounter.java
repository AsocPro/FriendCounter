/*
 * Project: FriendCounter - Linked List
 * File: FriendCounter.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: This file has the runtime to count friends.
 * The FriendCounter uses a singly Linked List to store the friends.
 */
package friendcounter;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author zachary
 */
public class FriendCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String choice;
        
        System.out.println("Friend Counter - A public service by Zachary Pratt Gibbs");
        System.out.println("Choose an option by inputing the corresponding letter:");
        System.out.println("a : Add a friend");
        System.out.println("r : Remove a friend");
        System.out.println("f : View a friend's details");
        System.out.println("l : List friends.");
        System.out.println("q : Quit");
        try
        {
            choice = input.next();
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Invalid Input");
        }
        catch(IllegalStateException e)
        {
            System.out.println("There has been an error. Exiting program.");
        }
        FriendSLL fc = new FriendSLL();
    }
}
