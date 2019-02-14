// Name:Hang Dong
// USC NetID:donghang
// CSCI 455 PA5
// Fall 2018

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"
// cstdlib needed for call to atoi
#include <cstdlib>
#include <iostream>
using namespace std;
int main(int argc, char * argv[]) {
   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }

   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*


   bool done = false;
   string comand ;
   string listKey ;
   int value = 0;
   while(!done){
      cout<<"comand>";
      cin>>comand;
      if(comand == "insert"){
         cin>>listKey>>value;
         grades -> insert (listKey, value);
      }
      else if(comand == "change"){
         cin>>listKey>>value;
         if(grades -> lookup(listKey) != NULL){
             * grades->lookup(listKey) = value;
         }
         else{
             cout <<"This name is not exist."<<endl;
         }
      }
      else if(comand == "lookup"){
          cin >> listKey;
          if(grades->lookup(listKey) != NULL){
              cout << listKey << ": "<< *grades->lookup(listKey) << endl;
          }else{
              cout << "This name is not exist." << endl;
          }
      }
      else if(comand == "remove"){
          cin >> listKey;
          if(grades -> lookup(listKey) != NULL){
              grades ->remove(listKey);
          }
          else{
              cout <<"This name is not exist."<<endl;
          }
      }
      else if(comand == "print"){
          grades -> printAll();
      }
      else if(comand == "size"){
          cout<< grades ->numEntries() << endl;;
      }
      else if(comand == "stats"){
          grades -> hashStats(cout);
      }
      else if(comand == "help"){
          cout<<"The valid commands as follow: "<<endl;
          cout<<"'insert' @name @score: Insert this name and score in the grade table. If this name was already present, print a message to that effect, and don't do the insert."<<endl;
          cout<<"'change' @name @score: Change the score for name. Print an appropriate message if this name isn't present."<<endl;
          cout<<"'lookup' @name: Lookup the name, and print out his or her score, or a message indicating that student is not in the table."<<endl;
          cout<<"'remove' @name: Remove this student. If this student wasn't in the grade table, print a message to that effect."<<endl;
          cout<<"'print': Prints out all names and scores in the table."<<endl;
          cout<<"'size': Prints out the number of entries in the table."<<endl;
          cout<<"'stats': Prints out statistics about the hash table at this point."<<endl;
          cout<<"'help': Prints out a brief command summary."<<endl;
          cout<<"'quit': Exit the program."<<endl;
      }
      else if(comand == "quit"){
          done = true;
      }
      else{
          cout<<"ERROR: invalid command"<<endl;
      }
   }
   return 0;
}
