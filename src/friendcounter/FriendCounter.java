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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author zachary
 */
public class FriendCounter {

    Scanner scr = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String choice;
        
        
        System.out.println(inputFriend());
           
        System.out.println("Friend Counter - A public service by Zachary Pratt Gibbs");
        System.out.println("Choose an option by inputing the corresponding letter:");
        System.out.println("a : Add a friend");
        System.out.println("r : Remove a friend");
        System.out.println("f : View a friend's details");
        System.out.println("l : List friends.");
        System.out.println("q : Quit");
        //choice = scr.nextLine();
       // switch(choice)
        //{
         //   case "a":
       //         
        //}
    }
    private void printMenu()
    {
        
    }
    private void add()
    {
        
    }
    private void remove()
    {
        
    }
    private void view()
    {
        
    }
    private static Friend inputFriend()
    {
        Scanner scr = new Scanner(System.in);
        String strInput = "";
        Scanner strScanner = new Scanner(strInput);
        System.out.print("Enter Name [Unknown] : ");
        String name = scr.nextLine();
        if((name.isEmpty()))
        {
            name = "Unknown";
        }
        System.out.print("\nEnter Age [Unknown] : ");
        strInput = scr.nextLine();
        if(!strInput.isEmpty())
        while(!strScanner.hasNextInt() || strInput.isEmpty())
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter Age [Unknown] : ");
            strInput = scr.nextLine();
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
            while(!strScanner.hasNextBoolean() || !strInput.isEmpty())
            {
                System.out.println("Invalid Input.");
                System.out.print("\nIs the age an aproximation?(true:false) [False] : ");
                strInput = scr.nextLine();
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
        System.out.print("\nEnter gender (male:female) [Unknown]");
        strInput = scr.nextLine();
        while(!strInput.isEmpty() || !strInput.equals("male") || 
                !strInput.equals("female"))
        {
            System.out.println("Invalid Input.");
            System.out.print("\nEnter gender (male:female) [Unknown]");
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
        System.out.print("/n");
        Friend newFriend = new Friend(name, age, ageIsApprox, gender);
        //Friend newFriend = new Friend(name, age, ageIsApprox, gender, quality, 
        //        cuteness, relationship, isFamily);
        return newFriend;
    }
}
