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

/**
 *
 * @author zachary
 */
public class FriendCounter {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Backend counter = new Backend();
        counter.addManual(new Friend("Melvin Fanny", 32, false, -1, 2, 0, 0, false));
        counter.addManual(new Friend("Suzie Smith", 21, false, 1, 3, 4, 2, false));
        counter.addManual(new Friend("Betzy Jones", 40, true, 1, 1, 0, 0, true));
        counter.addManual(new Friend("Jorge Francin", 2, false, 0, 5, 0, 1, true));
        counter.addManual(new Friend("Scott Bullock", 30, true, 0, -4, -5, -1, false));
        counter.mainMenu();
    }
}