/*
 * Project: FriendCounter - Linked List
 * File: Backend.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: This is the program backend for a command line interface.
 *    This file is used to segment the code to improve debugging and readability.
 */
package friendcounter;

import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class Backend 
{
    SinglyLinkedList<Friend> friends;
    /**
     * Default Constructor for the backend
     */
    public Backend()
    {
        friends = new SinglyLinkedList<>();
    }
    /**
     * Method to run the Main menu
     */
    public void mainMenu()
    {
        boolean exit = false;
        while(!exit)
        {
            String choice;
            Scanner scr = new Scanner(System.in);
            System.out.println("Friend Counter - A public service by Zachary Pratt Gibbs");
            System.out.println("Choose an option by inputing the corresponding letter:");
            System.out.println("a : Add a friend");
            System.out.println("r : Remove a friend");
            System.out.println("s : Search for a friend");
            System.out.println("v : Advanced friend Search");
            System.out.println("f : View a friend's details");
            System.out.println("l : List All friends.");
            System.out.println("x : Soul Mate Finder");
            System.out.println("q : Quit");
            choice = scr.nextLine();
            switch(choice)
            {
                case "a":
                    add();
                    break;
                case "r":
                    remove();
                    break;
                case "s":
                    search();
                    break;
                case "v":
                    advancedSearch();
                    break;
                case "f":
                    viewDetails();
                    break;
                case "l":
                    viewList();
                    break;
                case "x":
                    soulMateFinder();
                    break;
                default:
                    System.out.println("Invalid Input");
                case "q":
                    System.out.println("Program Exiting");
                    System.out.println("Stay in Touch for facebook friend list integration");
                    exit = true;
                    break;
            }
        }
    }
    /**
     * Used to manually add Friends to the list to preset a list before usage.
     * @param inputTthe friend to add
     */
    public void addManual(Friend input)
    {
        friends.addAtTail(input);
    }
    /**
     * Internal method to add a friend
     */
    private void add()
    {
        Friend temp = inputFriend();
        friends.addAtTail(temp);
        System.out.println(temp.toStringDetails());
        System.out.println("Friend Added");
        System.out.println("-------------------------------------------");
    }
    /**
     * internal method to remove a friend
     */
    private void remove()
    {
        Scanner scr = new Scanner(System.in);
        Scanner strScanner;
        String strInput;
        System.out.print("Enter the Friend Number to remove. Use blank input to "
                + "main menu.");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("Enter the Friend Number to remove. Use blank input to "
                    + "main menu.");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        if(!strInput.isEmpty())
        {
            int index = strScanner.nextInt();
            System.out.println(friends.find(index).getElement().toStringDetails());
            System.out.println("");
            System.out.println("Are you sure you want to delete this friend? "
                    + "(true:false) [true]");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
            while(!(strScanner.hasNextBoolean() ^ strInput.isEmpty()))
            {
                System.out.println("Invalid Input.");
                System.out.print("Are you sure you want to delete this friend? "
                        + "(true:false) [true]");
                strInput = scr.nextLine();
                strScanner = new Scanner(strInput);
            }
            boolean delete;
            if(strInput.isEmpty())
            {
                delete = true;
            }
            else
            {
                delete = strScanner.nextBoolean();
            }
            if(delete)
            {
                friends.delete(index);
                System.out.println("Friend Deleted");
                System.out.println("-------------------------------------------");
            }
        }
    }
    /**
     * Internal method to search for a friend
     */
    private void search()
    {
        System.out.println("-------------------------------------------");
        Friend search = inputFriendBasic();
        System.out.println("Friends found");
        friends.printedFindAll(search);
        System.out.println("-------------------------------------------");
    }
    /**
     * Internal method to search for a friend using all details possible
     */
    private void advancedSearch()
    {
        System.out.println("-------------------------------------------");
        Friend search = inputFriend();
        System.out.println("Friends found");
        friends.printedFindAll(search);
        System.out.println("-------------------------------------------");
    }
    /**
     * Internal method to print a list of all friends
     */
    private void viewList()
    {
        System.out.println("-------------------------------------------");
        System.out.println("List of Friends");
        friends.traverse();
        System.out.println("-------------------------------------------");
    }
    /**
     * Internal method to view details of a friend
     */
    private void viewDetails()
    {
        System.out.println("-------------------------------------------");
        Scanner scr = new Scanner(System.in);
        Scanner strScanner;
        String strInput;
        System.out.print("Enter friend number to view, Blank for main menu : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("Enter friend number to view, Blank for main menu : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int index;
        if(!strInput.isEmpty())
        {
            index = strScanner.nextInt();
            System.out.println("Friend Details");
            System.out.println(friends.find(index).getElement().toStringDetails());
        }
        System.out.println("-------------------------------------------");
    }
    /**
     * Internal method to implement the SoulMateFinder plugin
     */
    private void soulMateFinder()
    {
        System.out.println("-------------------------------------------");
        System.out.println("Input your information");
        Friend me = inputMe();
        SoulMateFinder smf = new SoulMateFinder(me);
        System.out.println("Your Soul Mate is...");
        System.out.println(smf.find(friends).toStringDetails());
        System.out.println("-------------------------------------------");
    }
    /**
     * Internal method to create a new  basic Friend from user Input
     * @return The friend made
     */
    private Friend inputFriendBasic()
    {
        System.out.println("-------------------------------------------");
        Scanner scr = new Scanner(System.in);
        String strInput = "";
        Scanner strScanner;
        System.out.print("Enter Name [Unknown] : ");
        String name = scr.nextLine();
        if((name.isEmpty()))
        {
            name = "Unknown";
        }
        //strScanner = new Scanner(strInput);
        System.out.print("\nEnter Age [Unknown] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        //if(!strInput.isEmpty())
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter Age [Unknown] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int age;
        if(strInput.isEmpty())
        {
            age = -1;
        }
        else 
        {

            age = strScanner.nextInt();
        }
        boolean ageIsApprox;
        if(!(age == -1))
        {
            System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
            while(!(strScanner.hasNextBoolean() ^ strInput.isEmpty()))
            {
                System.out.println("Invalid Input.");
                System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
                strInput = scr.nextLine();
                strScanner = new Scanner(strInput);
            }
            if(strInput.isEmpty())
            {
                ageIsApprox = false;
            }
            else
            {
                ageIsApprox = strScanner.nextBoolean();
            }
        }
        else
        {
            ageIsApprox = false;
        }
        System.out.print("\nEnter gender (male:female) [Unknown : ]");
        strInput = scr.nextLine();
        while(!(strInput.isEmpty() || strInput.equals("male") || 
                strInput.equals("female")))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter gender (male:female) [Unknown] : ");
            strInput = scr.nextLine();
        }
        int gender;
        if(strInput.isEmpty())
        {
            gender = -1;
        }
        else
        {
            if(strInput.equals("male"))
            {
                gender = 0;
            }
            else
            {
                gender = 1;
            }
        }
        System.out.println("-------------------------------------------");
        Friend newFriend = new Friend();
        try
        {            
            newFriend = new Friend(name, age, ageIsApprox, gender);
        }
        catch(InvalidParameterException ipe)
        {
            System.out.println("Friend was invalid Please try again."
                    + "\n Remember to read the instructions Carefully");
            newFriend = inputFriendBasic();
        }
        return newFriend;
    }
    /**
     * Internal method for creating a friend from user input
     * @return The friend made
     */
    private Friend inputFriend()
    {
        System.out.println("-------------------------------------------");
        Scanner scr = new Scanner(System.in);
        String strInput = "";
        Scanner strScanner;
        System.out.print("Enter Name [Unknown] : ");
        String name = scr.nextLine();
        if((name.isEmpty()))
        {
            name = "Unknown";
        }
        System.out.print("\nEnter Age [Unknown] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter Age [Unknown] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int age;
        if(strInput.isEmpty())
        {
            age = -1;
        }
        else 
        {

            age = strScanner.nextInt();
        }
        boolean ageIsApprox;
        if(!(age == -1))
        {
            System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
            while(!(strScanner.hasNextBoolean() ^ strInput.isEmpty()))
            {
                System.out.println("Invalid Input.");
                System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
                strInput = scr.nextLine();
                strScanner = new Scanner(strInput);
            }
            if(strInput.isEmpty())
            {
                ageIsApprox = false;
            }
            else
            {
                ageIsApprox = strScanner.nextBoolean();
            }
        }
        else
        {
            ageIsApprox = false;
        }
        System.out.print("\nEnter gender (male:female) [Unknown : ]");
        strInput = scr.nextLine();
        while(!(strInput.isEmpty() || strInput.equals("male") || 
                strInput.equals("female")))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter gender (male:female) [Unknown] : ");
            strInput = scr.nextLine();
        }
        int gender;
        if(strInput.isEmpty())
        {
            gender = -1;
        }
        else
        {
            if(strInput.equals("male"))
            {
                gender = 0;
            }
            else
            {
                gender = 1;
            }
        }
        System.out.print("\nEnter the quality of your friendship,(-5 to 5) [0] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter the quality of your friendship,(-5 to 5) [0] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int quality;
        if(strInput.isEmpty())
        {
            quality = 0;
        }
        else 
        {

            quality = strScanner.nextInt();
        }
        System.out.print("\nEnter the cuteness,(-5 to 5) [0] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter the cuteness,(-5 to 5) [0] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int cuteness;
        if(strInput.isEmpty())
        {
            cuteness = 0;
        }
        else 
        {

            cuteness = strScanner.nextInt();
        }
        System.out.print("\nEnter the relationship status, (single:relationship:married)"
                + " [Unknown] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strInput.isEmpty() || strInput.equals("single") || 
                strInput.equals("relationship") || strInput.equals("married")))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter the relationship status, (single:relationship:married)"
                    + " [Unknown] : ");
            strInput = scr.nextLine();
        }
        int relationship;
        if(strInput.isEmpty())
        {
            relationship = 0;
        }
        else 
        {
            if(strInput.equals("single"))
            {
                relationship = 0;
            }
            else
            {
                if(strInput.equals("relationship"))
                {
                    relationship = 1;
                }
                else
                {
                    relationship = 1;
                }
            }
        }
        System.out.print("\nThey are family. (true:false) [False] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextBoolean() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nThey are family(true:false) [False] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        boolean isFamily;
        if(strInput.isEmpty())
        {
            isFamily = false;
        }
        else
        {
            isFamily = strScanner.nextBoolean();
        }
        System.out.println("-------------------------------------------");
        Friend newFriend = new Friend();
        try
        {            
            newFriend = new Friend(name, age, ageIsApprox, gender, quality, 
                    cuteness, relationship, isFamily);
        }
        catch(InvalidParameterException ipe)
        {
            System.out.println("Friend was invalid Please try again."
                    + "Remember to read the instructions carefully");
            newFriend = inputFriend();
        }
        return newFriend;
    }
    /**
     * Internal method used to create a Me character for the SoulMateFinder
     * @return ME!
     */
    private Friend inputMe()
    {
        System.out.println("-------------------------------------------");
        Scanner scr = new Scanner(System.in);
        String strInput = "";
        Scanner strScanner;
        System.out.print("Enter Name [Unknown] : ");
        String name = scr.nextLine();
        if((name.isEmpty()))
        {
            name = "Unknown";
        }
        System.out.print("\nEnter Age [Unknown] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter Age [Unknown] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int age;
        if(strInput.isEmpty())
        {
            age = -1;
        }
        else 
        {

            age = strScanner.nextInt();
        }
        boolean ageIsApprox;
        if(!(age == -1))
        {
            System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
            while(!(strScanner.hasNextBoolean() ^ strInput.isEmpty()))
            {
                System.out.println("Invalid Input.");
                System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
                strInput = scr.nextLine();
                strScanner = new Scanner(strInput);
            }
            if(strInput.isEmpty())
            {
                ageIsApprox = false;
            }
            else
            {
                ageIsApprox = strScanner.nextBoolean();
            }
        }
        else
        {
            ageIsApprox = false;
        }
        System.out.print("\nEnter gender (male:female) [Unknown : ]");
        strInput = scr.nextLine();
        while(!(strInput.isEmpty() || strInput.equals("male") || 
                strInput.equals("female")))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter gender (male:female) [Unknown] : ");
            strInput = scr.nextLine();
        }
        int gender;
        if(strInput.isEmpty())
        {
            gender = -1;
        }
        else
        {
            if(strInput.equals("male"))
            {
                gender = 0;
            }
            else
            {
                gender = 1;
            }
        }
        System.out.print("\nEnter the quality of Person you are (-5 to 5) [0] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter the quality of person you are (-5 to 5) [0] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int quality;
        if(strInput.isEmpty())
        {
            quality = 0;
        }
        else 
        {

            quality = strScanner.nextInt();
        }
        System.out.print("\nEnter the cuteness,(-5 to 5) [0] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strScanner.hasNextInt() ^ strInput.isEmpty()))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter the cuteness,(-5 to 5) [0] : ");
            strInput = scr.nextLine();
            strScanner = new Scanner(strInput);
        }
        int cuteness;
        if(strInput.isEmpty())
        {
            cuteness = 0;
        }
        else 
        {

            cuteness = strScanner.nextInt();
        }
        System.out.print("\nEnter the relationship status, (single:relationship:married)"
                + " [Unknown] : ");
        strInput = scr.nextLine();
        strScanner = new Scanner(strInput);
        while(!(strInput.isEmpty() || strInput.equals("single") || 
                strInput.equals("relationship") || strInput.equals("married")))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter the relationship status, (single:relationship:married)"
                    + " [Unknown] : ");
            strInput = scr.nextLine();
        }
        int relationship;
        if(strInput.isEmpty())
        {
            relationship = 0;
        }
        else 
        {
            if(strInput.equals("single"))
            {
                relationship = 0;
            }
            else
            {
                if(strInput.equals("relationship"))
                {
                    relationship = 1;
                }
                else
                {
                    relationship = 2;
                }
            }
        }
        System.out.println("-------------------------------------------");
        Friend newFriend = new Friend();
        try
        {            
            newFriend = new Friend(name, age, ageIsApprox, gender, quality, 
                    cuteness, relationship);
        }
        catch(InvalidParameterException ipe)
        {
            System.out.println("Friend was invalid Please try again."
                    + "Remember to read the instructions carefully");
            newFriend = inputFriend();
        }
        return newFriend;
    }
}
