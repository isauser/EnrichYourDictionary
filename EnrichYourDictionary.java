import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;


public class EnrichYourDictionary{

  public static void main(String[] args) {
    try{
        System.out.println("Please type the file name of your dictionary :");
        String dictionaryFile = JOptionPane.showInputDialog("Please type the name of the dictionary");
        BufferedReader inFile=new BufferedReader(new FileReader(dictionaryFile));
        Table dictionary=new Table(3001);// this is a table to store dictionary
        String line1;// iterate through the dictionary file, hold each word in each line
        line1=inFile.readLine();// assign the word to this variable
        line1=line1.toLowerCase();// convert the word to lower case
        while(line1!=null)//go through the dictionary file, mapping the dictionary into the dictionary table
        {
          dictionary.hashToList(line1,3001);
          line1=inFile.readLine();
          if(line1!=null)
          line1=line1.toLowerCase();
        }
        System.out.println("Please type the name of the file you want to check :");
        String fileToBeCheck = JOptionPane.showInputDialog("Please type the name of the file to be check");
        BufferedReader secondInFile=new BufferedReader(new FileReader(fileToBeCheck));
        String line2;// this variable used to go through the checked file,hold each word in each line
        Table checkedFile=new Table(1009);//this table used to store words in the checked file
        line2=secondInFile.readLine();//assigning value
        Stack newWords=new Stack();

        while(line2!=null)
        {
          line2=line2.toLowerCase();
          int charIndex=0;
          while(charIndex<line2.length())//Changing symbols that are not letters and apostrophe to blank space
          {
            if(!Character.isLetter(line2.charAt(charIndex))&&(!(line2.charAt(charIndex)=='\'')))
            {
              line2=line2.substring(0,charIndex)+' '+line2.substring(charIndex+1);
            }
               charIndex++;
          }
          
          Scanner check= new Scanner(line2);//scan this line
          
          String wordChecked;//hold the word to be checked
          while(check.hasNext())//check if there is next token
          {
            wordChecked=check.next();//assigning the word to this variable
            if(!dictionary.searchWord(wordChecked ,3001))//in this case, this word isn't in the dictionary
            {
                  checkedFile.hashToList2(wordChecked,1009);//using the insert method that avoid duplicate value
                  newWords.push(wordChecked);// push this word to the stack
             }
          }
          line2=secondInFile.readLine();//go to the next line
        }
        int dictionaryWordsNum=dictionary.countNumber();
        int newWordsNum=checkedFile.countNumber();
        System.out.println("There are a total of "+dictionaryWordsNum+" words in the dictionary");
        System.out.println("There are a total of "+newWordsNum+" new words found in the file");
        System.out.println("New words are as follows:");
        newWords.print();
        System.out.println("Do you wants to add these words to your dictionary?");
        System.out.println("Or maybe storing them in a new file and you modify the file and merge the file youself ?");
        System.out.println("Press Y to add new words to dictionary");
        System.out.println("Press M to store these new words in a new file called 'words'");
        System.out.println("Press others to exit");
        Scanner keyboard = new Scanner(System.in);
        String myInput= keyboard.nextLine();
        if(myInput.compareTo("Y")==0)
        {
          PrintWriter outFile=new PrintWriter(new FileWriter(dictionaryFile,true));
          Node anotherNode=newWords.top;
          outFile.println("");
          while(anotherNode!=null)
          {
            outFile.println(anotherNode.item);
            anotherNode=anotherNode.next;
          }
          System.out.println("Successfully append new words to the dictionary");
          outFile.close();
        }
        else if(myInput.compareTo("M")==0)
        {
          File file=new File("word.txt");
          PrintWriter outFile=new PrintWriter(new FileWriter(file));
          Node anotherNode=newWords.top;
          while(anotherNode!=null)
          {
            outFile.println(anotherNode.item);
            anotherNode=anotherNode.next;
          }
          System.out.println("Successfully create a new file called 'word.txt'to store these new words");
          outFile.close();
        }
        else
          System.out.println("End of process.");
        inFile.close();//close the file of dictionary
        secondInFile.close();//close the file that is used to check the misspelling words
  }
    catch(Exception e)
    {
      System.out.println("Error !"+e.toString()+"\n "+e.getMessage());
      e.printStackTrace();
    }
  }
}


