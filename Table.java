
class Table{
  LinkedList [] aList;
  public Table(int size)//constructor
  {
    aList=new LinkedList[size];
    for(int i=0;i<size;i++)
    {
      aList[i]=new LinkedList();
    }
  }
 public boolean searchWord(String a ,int size)//this is checking if the word in the table
  {
    int index=hash(a,size);
    if(aList[index]==null)
      return false;
    else
    return aList[index].search(a);
  }
 public int hash(String word,int size)//calculate the hash code of a word
  {
    int length=word.length();
    int position=0;
    int hashCode=((int)(word.charAt(position)))*13;
    hashCode=hashCode%size;
    if(word.length()>1)
    {
        for(int i=1;i<length;i++)
        {
          hashCode=(hashCode+((int) (word.charAt(i))))*13;
          hashCode=hashCode%size;
        }
    }
    return hashCode;
  }
  public void hashToList(String a,int size)//first hash to the table,when a slot of the table is enpty
  {
    int index=this.hash(a,size);
    aList[index].insert1(a);
  }
 public void hashToList2(String a,int size)//when some words have the same hash code ,they will in the same list. To avoid duplicate words
                                           // check if there is no duplicate word, then insert the word
  {
    int index=this.hash(a,size);
    aList[index].insertAvoidDuplicate(a);
  }
 public LinkedList findTheList(String a ,int size)//find the list with a certain word
 {
   int index=hash(a,size);
   return aList[index];
 }
 public int countNumber()//go through the array to return how many nodes in the table
 {
   int count=0;
   int temp=0;
   for(int i=0;i<aList.length;i++)
   {
     temp=aList[i].countNum();
     count+=temp;
   }
   return count;
}
}