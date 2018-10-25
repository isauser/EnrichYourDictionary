
class Stack{
  Node top;
  public Stack()
  {
    top=null;
  }
  public void push(String a)
  {
    if(top==null)
      top=new Node(a,null);
    else
    {
      Node aNode=new Node(a,top);
      top=aNode;
    }
  }
  public Node pop()
  {
    Node curr=top;
    top=top.next;
    return curr;
  }
  public Node top()
  {
    return top;
  }
  public boolean isEmpty()
  {
    if(top==null)
      return true;
    else 
      return false;
  }
  public void print()
  {
    Node curr=top;
    while(curr!=null)
    {
      System.out.println(curr.item);
      curr=curr.next;
    }
  }
}