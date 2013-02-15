/*
 * Project: FriendCounter - Linked List
 * File: SinglyLinkedList.java
 * @author Zachary Pratt Gibbs
 * Date: 18 Feb 2013
 * 
 * Description: This is the Singly Linked List class from the book.
 * It links Singly linked nodes together.
 */
package friendcounter;

/**
 *
 * @author zachary
 */
public class SinglyLinkedList <E>
{
    private SLNode<E> head;
    private SLNode<E> tail;
    private int length;
    //it is not needed both tail and length just head and one
    //of them.
    
    public SinglyLinkedList()
    {
        // this is for dummy nodes where the head and the tail
        //do not have values and are not part of the list
        //if you did not want to do this then you would set 
        //them to null values.
        tail = new SLNode();
        head = new SLNode(null, tail);
        length = 0;
    }
    /** 
     * they use a visitor in the book but we will not implement
     * it all the way so we are going to print it all out.
     */
    public void traverse()
    {
        SLNode<E> cursor = head.getSuccessor();
        
        while(cursor != tail)
        {
            System.out.println(cursor.getElement());
            //this is where we would have visited the node. 
            //but we are not doing visitors
            cursor = cursor.getSuccessor();
        }
    }
    public SLNode<E> find(int pos)
    {
        if(pos<0 || pos >= this.length)
        {
            throw new IndexOutOfBoundsException();
        }
        SLNode<E> cursor = head.getSuccessor();
        
        for(int index = 0; index < pos; ++index)
        {
            cursor = cursor.getSuccessor();
        }
        return cursor;
    }
    public SLNode<E> find(E element)
    {
        SLNode<E> cursor = head.getSuccessor();
        
        while(cursor != tail)
        {
            if(cursor.getElement().equals(element))
            {
                return cursor;
            }
            else
            {
                cursor = cursor.getSuccessor();
            }
        }
        return null;
    }
    public void addAtHead(E element)
    {
        SLNode<E> newNode = new SLNode<E>(element,null);
        newNode.setSuccessor(head.getSuccessor());
        head.setSuccessor(newNode);
        length++;
    }
    public void addAtTail(E element)
    {
        SLNode<E> newNode = new SLNode<E>(element, null);
        if(length<0)
        {
            SLNode<E> lastNode = find(this.length-1);
            newNode.setSuccessor(lastNode.getSuccessor());
        
            lastNode.setSuccessor(newNode);
        }
        else
        {
            newNode.setSuccessor(head.getSuccessor());
            head.setSuccessor(newNode);
        }
        length++;
    }
    public void insert(E element,int pos)
    {
        if(pos<0 || pos > this.length)// changed took out = cause if pos = length puts it at end
        {
            throw new IndexOutOfBoundsException();
        }
        //java 7 there is a feature that is a diamond operator
        //this is new in 7 it will take from the left
        // you can if it is a child of the other type
        
        if(pos == 0)
        {
            addAtHead(element);
        }
        else if(pos == length)
        {
            addAtTail(element);
        }
        else 
        {
            SLNode<E> newNode = new SLNode<>(element, null);
            
            SLNode<E> prevNode = find(pos-1);
            
            newNode.setSuccessor(prevNode.getSuccessor());
            prevNode.setSuccessor(newNode);
            length++;
        }
    }
    public E delete(int pos)
    {
        //write check position method
        if(pos<0 || pos >= this.length)
        {
            throw new IndexOutOfBoundsException();//unchecked exception
        }
        SLNode<E> prevNode;
        if(pos == 0)
        {
            prevNode = head;
        }
        else
        {
            prevNode = find(pos-1);
        }
        SLNode<E> delNode = prevNode.getSuccessor();
       
        prevNode.setSuccessor(delNode.getSuccessor());
        delNode.setSuccessor(null);//just for completeness
        
        length--;
        
        return delNode.getElement();
    }
    public int getLength()
    {
        return length;
    }
}
