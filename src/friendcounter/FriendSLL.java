/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package friendcounter;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class FriendSLL <Friend>
{
    public FriendSLL()
    {
        SinglyLinkedList sll = new SinglyLinkedList();
    }
    public void traverse()
    {
    }
    public Friend find(String name)
    {
        Friend cursor = head.getSuccessor().getElement().;
        
        while(cursor != tail)
        {
            if(cursor.getElement().getName().equals(name))
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
}
