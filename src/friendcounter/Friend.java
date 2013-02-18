/*
 * Project: FriendCounter - Linked List
 * File: Friend.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: This is a friend class to be used in the Friend Counter program.
 */
package friendcounter;
//Needs to change constructors and set methods to check for valid entry.

import java.security.InvalidParameterException;


/**
 *
 * @author zachary
 */
public class Friend 
{
    private String name;
    private int age;// Age in years -1 for Unknown
    private boolean ageIsApprox;
    private int gender; // 0 = Male, 1 = Female, -1 = Unknown
    
    private int quality; //Quality of friendship. Scale from -5 to 5 where 0 is 
                           //neutral, -5 is sworn Enemy and 5 is like a brother
                           //from another mother.
    
    private int cuteness; //Cuteness. -5 to 5. 0 is the normal, -5 is looks like
                            //a monster and 5 is having an angelic beauty
    
    private int relationship;//0 is single, 1 is in a relationship, 2 is married 
                            //and -1 is unknown.
    private boolean isFamily;
    /**
     * Default constructor Makes an unknown friend
     */
    public Friend()
    {
        this.name = "Unknown";
        this.age = -1;
        this.ageIsApprox = false;
        this.gender = -1;
        this.quality = 0;
        this.cuteness = 0;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor if Only the Name is known
     * @param name Name of the friend.
     */
    public Friend(String name)
    {
        this.name = name;
        this.age = -1;
        this.ageIsApprox = false;
        this.gender = -1;
        this.quality = 0;
        this.cuteness = 0;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor Specifying the name and age.
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     */
    public Friend(String name, int age)
    {
	if(age < -1)
        {
            throw new InvalidParameterException();
        }
        this.name = name;
        this.age = age;
        this.ageIsApprox = false;
        this.gender = -1;
        this.quality = 0;
        this.cuteness = 0;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor Specifying the name and age.
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     * @param ageIsApprox True if the age is an approximation false if it isn't.
     */
    public Friend(String name, int age, boolean ageIsApprox)
    {
	if(age < -1)
        {
            throw new InvalidParameterException();
        }
        this.name = name;
        this.age = age;
        this.ageIsApprox = ageIsApprox;
        this.gender = -1;
        this.quality = 0;
        this.cuteness = 0;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor Specifying the name, age, and gender.
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     * @param ageIsApprox True if the age is an approximation false if it isn't.
     * @param gender Gender of friend. 0 = Male, 1 = Female, -1 = Unknown
     */
    public Friend(String name, int age, boolean ageIsApprox, int gender)
    {
        if(age < -1 || gender < -1 || gender > 1)
        {
            throw new InvalidParameterException();
        }
        this.name = name;
        this.age = age;
        this.ageIsApprox = ageIsApprox;
        this.gender = gender;
        this.quality = 0;
        this.cuteness = 0;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor Specifying the name, age, and gender.
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     * @param ageIsApprox True if the age is an approximation false if it isn't.
     * @param gender Gender of friend. 0 = Male, 1 = Female, -1 = Unknown
     */
    public Friend(String name, int age, int gender)
    {
        if(age < -1 || gender < -1 || gender > 1)
        {
            throw new InvalidParameterException();
        }
        this.name = name;
        this.age = age;
        this.ageIsApprox = false;
        this.gender = gender;
        this.quality = 0;
        this.cuteness = 0;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor Specifying the name, age, and gender, quality and cuteness
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     * @param ageIsApprox True if the age is an approximation false if it isn't.
     * @param gender Gender of friend. 0 = Male, 1 = Female, -1 = Unknown
     * @param quality Quality of friendship. Scale from -5 to 5 where 0 is 
     *     neutral, -5 is sworn Enemy and 5 is like a brother from another mother.
     * @param cuteness Overall Cuteness. -5 to 5. 0 is the normal, -5 is looks like
     *     a monster and 5 is having an angelic beauty
     */
    public Friend(String name, int age, boolean ageIsApprox, int gender, 
            int quality, int cuteness)
    {
    	if(age < -1 || gender < -1 || gender > 1 || quality < -5 || quality > 5 || cuteness < -5 || cuteness > 5)
    	{
        	throw new InvalidParameterException();
    	}
        this.name = name;
        this.age = age;
        this.ageIsApprox = ageIsApprox;
        this.gender = gender;
        this.quality = quality;
        this.cuteness = cuteness;
        this.relationship = -1;
        this.isFamily = false;
    }
    /**
     * Constructor specifying the name, age, gender, cuteness, quality and relationship status of the friend
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     * @param ageIsApprox True if the age is an approximation false if it isn't.
     * @param gender Gender of friend. 0 = Male, 1 = Female, -1 = Unknown
     * @param quality Quality of friendship. Scale from -5 to 5 where 0 is 
     *     neutral, -5 is sworn Enemy and 5 is like a brother from another mother.
     * @param cuteness Overall Cuteness. -5 to 5. 0 is the normal, -5 is looks like
     *     a monster and 5 is having an angelic beauty
     * @param relationship The relationship status of the friend. 0 is single, 
     *     1 is in a relationship, 2 is married and -1 is unknown.
     */
    public Friend(String name, int age, boolean ageIsApprox, int gender, 
            int quality, int cuteness, int relationship)
    {
        if(age < -1 || gender < -1 || gender > 1 || quality < -5 || quality > 5 || cuteness < -5 || cuteness > 5 || relationship < -1 || relationship > 2)
    	{
        	throw new InvalidParameterException();
    	}
        this.name = name;
        this.age = age;
        this.ageIsApprox = ageIsApprox;
        this.gender = gender;
        this.quality = quality;
        this.cuteness = cuteness;
        this.relationship = relationship;
        this.isFamily = false;
    }
    /**
     * Constructor specifying the name, age, gender, cuteness, quality and relationship status of the friend
     * @param name Name of the friend
     * @param age Age in years. -1 = Unknown
     * @param ageIsApprox True if the age is an approximation false if it isn't.
     * @param gender Gender of friend. 0 = Male, 1 = Female, -1 = Unknown
     * @param quality Quality of friendship. Scale from -5 to 5 where 0 is 
     *     neutral, -5 is sworn Enemy and 5 is like a brother from another mother.
     * @param cuteness Overall Cuteness. -5 to 5. 0 is the normal, -5 is looks like
     *     a monster and 5 is having an angelic beauty
     * @param relationship The relationship status of the friend. 0 is single, 
     *     1 is in a relationship, 2 is married and -1 is unknown.
     * @param isFamily If the friend is a family member.
     */
    public Friend(String name, int age, boolean ageIsApprox, int gender, 
            int quality, int cuteness, int relationship, boolean isFamily)
    {
        if(age < -1 || gender < -1 || gender > 1 || quality < -5 || quality > 5 || cuteness < -5 || cuteness > 5 || relationship < -1 || relationship > 2)
    	{
        	throw new InvalidParameterException();
    	}
        this.name = name;
        this.age = age;
        this.ageIsApprox = ageIsApprox;
        this.gender = gender;
        this.quality = quality;
        this.cuteness = cuteness;
        this.relationship = relationship;
        this.isFamily = isFamily;
    }
    /**
     * @return Name of the friend.
     */
    public String getName()
    {
        return name;
    }
    /**
     * Set the name of the friend
     * @param name Name of the friend
     */
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return age;
    }
    public boolean getAgeIsApprox()
    {
        return ageIsApprox;
    }
    public void setAge(int age)
    {
        if(age < -1)
    	{
        	throw new InvalidParameterException();
    	}
        this.age = age;
    }
    public void setAge(int age, boolean ageIsApprox)
    {
        if(age < -1)
    	{
        	throw new InvalidParameterException();
    	}
        this.age = age;
        this.ageIsApprox = ageIsApprox;
    }
    public int getGender()
    {
        return gender;
    }
    public void setGender(int gender)
    {
        if(gender < -1 || gender > 1)
    	{
        	throw new InvalidParameterException();
    	}
        this.gender = gender;
    }
    public int getQuality()
    {
        return quality;
    }
    public void setQuality(int quality)
    {
        if(quality < -5 || quality > 5)
    	{
        	throw new InvalidParameterException();
    	}
        this.quality = quality;
    }
    public int getCuteness()
    {
        return cuteness;
    }
    public void setCuteness(int cuteness)
    {
        if(cuteness < -5 || cuteness > 5)
    	{
        	throw new InvalidParameterException();
    	}
        this.cuteness = cuteness;
    }
    public int getRelationship()
    {
        return relationship;
    }
    public void setRelationship(int relationship)
    {
        if(relationship < -1 || relationship > 2)
    	{
        	throw new InvalidParameterException();
    	}
        this.relationship = relationship;
    }
    public boolean isFamily()
    {
        return isFamily;
    }
    public void isFamily(boolean isFamily)
    {
        this.isFamily = isFamily;
    }
    @Override
    public String toString()
    {
        String friend = "";
        friend = friend + "Name: " + name + "/t";
        friend = friend + "Age: ";
        if(age == -1)
        {
            friend = friend + "Unknown/t";
        }
        else
        {
            if(ageIsApprox)
            {
                friend = friend + " approx/t";
            }
         else
            {
                friend = friend + "/t";
            }
        }
        friend = friend + "Gender: ";
        switch(this.gender)
        {
            case -1:
                friend = friend + "Unknown";
                break;
            case 0:
                friend = friend + "Male";
                break;
            case 1:
                friend = friend + "Female";
                break;
        }
        return friend;
    }
    public String toStringDetails()
    {
        String friend = "";
        friend = friend + "Name: " + name + "/n";
        friend = friend + "Age: ";
        if(age == -1)
        {
            friend = friend + "Unknown/n";
        }
        else
        {
            if(ageIsApprox)
            {
                friend = friend + " approx/n";
            }
         else
            {
                friend = friend + "/n";
            }
        }
        friend = friend + "Gender: ";
        switch(this.gender)
        {
            case -1:
                friend = friend + "Unknown";
                break;
            case 0:
                friend = friend + "Male";
                break;
            case 1:
                friend = friend + "Female";
                break;
        }
        friend = friend + "/n";
        friend = friend + "Quality: " + quality;
        friend = friend + "Cuteness Level: " + cuteness;
        friend = friend + "Relationship Status: ";
        switch(relationship)
        {
            case -1:
                friend = friend + "Unknown";
                break;
            case 0:
                friend = friend + "Single";
                break;
            case 1:
                friend = friend + "In a relationship";
                break;
            case 2:
                friend = friend + "Married";
                break;
        }
        friend = friend + "/n";
        if(isFamily)
        {
            friend = friend + "Is family/n";
        }
        else
        {
            friend = friend + "Not Family/n";
        }
        return friend;
    }
    /**
     * Override equals() providing a friend that is close to the description.
     *     If a parameter is unknown then it will count that parameter as equal
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        } 
        if(this == object)
        {
            return true;
        } 
        if(!(object instanceof Friend))
        {
            return false;
        }
        Friend other = (Friend)object;
        if(!(this.getName().equals(other.getName()) || other.getName().equals("Unknown")))
        {
            return false;
        }
        if(ageIsApprox)
        {
            if(!(Math.abs(this.getAge()-other.getAge()) < 5))
            {
                return false;
            }
        }
        else
        {
            if(!(this.getAge() == other.getAge() || other.getAge() == -1))
            {
                return false;
            }
        }
        if(!(this.getGender() == other.getGender() || other.getGender() == -1))
        {
            return false;
        }
        if(!(this.getCuteness() == other.getCuteness()))
        {
            return false;
        }
        if(!(this.getQuality() == other.getQuality()))
        {
            return false;
        }
        if(!(this.getRelationship() == other.getRelationship() || other.getRelationship() == -1))
        {
            return false;
        }
        if(!(this.isFamily() == other.isFamily()))
        {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 37 * result + name.hashCode();
        result = 37 * result + age;
        result = 37 * result + (ageIsApprox ? 0 : 1);
        result = 37 * result + cuteness;
        result = 37 * result + quality;
        result = 37 * result + relationship;
        result = 37 * result + (isFamily ? 0 : 1);
        return result;
    }
}
