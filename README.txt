This program is mainly used to practise hush table

The process is like this: this program will read two files as input, the first
                          one is dictionary.All words in the dictionary will hashed
                          into a table , using separate chaining
                          The second input file is the file user want to test if 
                          there are new words(that don't show up in the dictionary file)
                          Each word will be checked if it is in the dictionary file,
                          If not, it will be regarded as a new word
                           and hash it into another table. meanwhile, new words will be pushed into a stack
                         All new words will be printed out .The user will choose whether to append these new words
                         into the dictionary, or write them into a new file
                         or do nothing.
Details:
1.The program uses separate chaining(in which each table slot is a linked list of node)
  to resolve collisions
2. The program uses Horner's method to calculate polynomial hash code,and mod table
   size to avoid integer overflow
3. In the second input file , there could be some symbol like apostrophe, or uppercase,or
  punctuations. These situation will be handled by the program correspondingly.

