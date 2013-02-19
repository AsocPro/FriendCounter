/*
 * Project: FriendCounter - Linked List
 * File: SoulMateFinder.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: this is an additional module to the FriendCounter Program that
 * anaylizes your friends and lets you know who is a possible soul mate.
 * 
 * I will let you know if it works or not. Just give me a little.
 */
package friendcounter;

/**
 *
 * @author zachary
 */
public class SoulMateFinder 
{
    Friend me;
    public SoulMateFinder()
    {
        me = new Friend();
    }
    public SoulMateFinder(Friend me)
    {
        this.me = me;
    }
    public Friend find(SinglyLinkedList<Friend> friends)
    {
        Friend haha = new Friend("You are Hopeless If you are looking here for a soulmate");
        return haha;
    }
}
