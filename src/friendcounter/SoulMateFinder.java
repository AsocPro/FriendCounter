/*
 * Project: FriendCounter - Linked List
 * File: SoulMateFinder.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: this is an additional module to the FriendCounter Program that
 * anaylizes your friends and lets you know who is a possible soul mate.
 * 
 * It isn't written the best persay as it has a very high order N. Maybe that
 * Will help the user think it is actually doing something awesome.
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
    private PossibleSoulMate me;
    /**
     * default constructor. Search for a soul mate for someone unknown.
     */
    public SoulMateFinder()
    {
        me = new PossibleSoulMate();
    }
    /**
     * constructor specifying the person who is being searched for.
     * @param me the person being searched for
     */
    public SoulMateFinder(Friend me)
    {
        this.me = new PossibleSoulMate(me);
    }
    /**
     * Finds your Soul Mate using a very untested method.
     * @param friends SinglyLinkedList of friends to search for a soul mate
     * @return your soul Mate
     */
    public Friend find(SinglyLinkedList<Friend> friends)
    {
        //SinglyLinkedList<Friend> friends = input;
        if(me.getMe().getRelationship() == 2)
        {
           Friend spouse = new Friend("Your Spouse");
           spouse.isFamily(true);
           spouse.setRelationship(2);
           return spouse;
        }
        if(me.getMe().getGender() == -1)
        {
            return new Friend();
        }
        
        SinglyLinkedList<PossibleSoulMate> soulMates = new SinglyLinkedList<>();
        for(int index = 0; index < friends.getLength(); index++)
        {
            if(!(friends.find(index).getElement().isFamily() || 
                    friends.find(index).getElement().getGender() == -1 ||
                    friends.find(index).getElement().getGender() == me.getMe().getGender()
                    || friends.find(index).getElement().getRelationship() == 2))
            {
                PossibleSoulMate possible = new PossibleSoulMate(friends.find(index).getElement());
                soulMates.addAtHead(possible);
            }
        }
        if(soulMates.getLength() == 0)
        {
            return new Friend();
        }
        for(int index = 0; index < soulMates.getLength(); index++)
        {
            soulMates.find(index).getElement().setScore(me.getMe());
        }
        Friend theOne;
        if(soulMates.getLength() > 1)
        {
            int bestScore = soulMates.find(0).getElement().getScore();
            theOne = soulMates.find(0).getElement().getMe();
            for(int index = 1; index < soulMates.getLength(); index++)
            {
                if(soulMates.find(index).getElement().getScore() > bestScore)
                {
                    theOne = soulMates.find(index).getElement().getMe();
                    bestScore = soulMates.find(index).getElement().getScore();
                }
            }
        }
        else
        {
            theOne = soulMates.find(0).getElement().getMe();
        }
        return theOne;
    }
}
