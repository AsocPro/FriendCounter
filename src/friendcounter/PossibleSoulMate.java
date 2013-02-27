/*
 * Project: FriendCounter - Linked List
 * File: PossibleSoulMate.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: This class pairs the friend class with a score that is assigned
 * and used by the FriendAnaylizer to determine who is the best possible soul mate.
 */
package friendcounter;

/**
 *
 * @author zachary
 */
public class PossibleSoulMate 
{
    private Friend psm;
    private int score;
    /**
     * Default consructor of a PossibleSoulMate adds Unknown friend
     */
    public PossibleSoulMate()
    {
        psm = new Friend();
        score = 0;
    }
    /**
     * Constructor that specifies the Friend.
     * @param psm 
     */
    public PossibleSoulMate(Friend psm)
    {
        this.psm = psm;
        score = 0;
    }
    /**
     * Sets the Score comparted to another person
     * @param me Friend whom to compare
     */
    public void setScore(Friend me)
    {
        this.score = this.getMe().hashCode() - me.hashCode();
        this.score -= (Math.abs(this.getMe().getAge()-me.getAge()));
        this.score -= (Math.abs(this.getMe().getQuality()-me.getQuality()));
        this.score -= (Math.abs(this.getMe().getCuteness()-me.getCuteness()));
        if(this.getMe().getRelationship() == 1)
        {
            this.score = this.score/10;
        }
    }
    /**
     * Get the Score of the Soul Mate
     * @return The score of the PossibleSoulMate
     */
    public int getScore()
    {
        return score;
    }
    /**
     * Get the friend element of the PossibleSoulMate object
     * @return The PossibleSoulMate friend Element
     */
    public Friend getMe()
    {
        return psm;
    }
    /**
     * Overridden toString() to make the PSM a string
     * @return Friend and the Score
     */
    @Override
    public String toString()
    {
        return  psm.toString() + "\t" + "Score: " + score;
    }
}
