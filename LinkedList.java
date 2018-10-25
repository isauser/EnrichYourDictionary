
public class LinkedList{
  Node head;
  public LinkedList()//constructor
  {
    head=null;
  }
  public void insert1(String a)//this is used when the first time to check if a slot of the table has some content
  {
    Node aNode=new Node(a,head);
    head=aNode;
  }
 public Node getNode(String a)//fetch a certain node that contain a word
  {
    Node temp=head;
    while(temp.item.compareTo(a)!=0)
    {
      temp=temp.next;
    }
    return temp;
  }
  public void insertAvoidDuplicate(String a)//avoid duplicate value in a list,So check the list if a certain word has already exist
  {
    if(!search(a))//
    {
      Node aNode=new Node(a,head);
      head=aNode;
    }
  }
  public boolean search(String a)//find if a word exist in the linkedlist
  {
    boolean found=false;
    Node temp=head;
    while(temp!=null&&temp.item.compareTo(a)!=0)
    {
        temp=temp.next;
    }
    if(temp!=null&&temp.item.compareTo(a)==0)
      found=true;
    return found;
  }
 public int countNum()//count the number of word in the table
 {
   int count=0;
   Node temp=head;
   while(temp!=null)
   {
     temp=temp.next;
     count++;
   }
   return count;
 }
}
