// Name:Hang Dong
// USC NetID:donghang
// CSCI 455 PA5
// Fall 2018


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}

//*************************************************************************
// put the function definitions for your list functions below

// function: insert a new entry to list
// parameter: list, listkey, value
bool listInsert(ListType & list, const string & listkey, int value){
   if(listFind(list,listkey) != NULL){
      cout<<"failed, key already exist"<<endl;
      return false;
   }else{
      ListType curPoint = new Node(listkey, value, list);
      list = curPoint;
      return true;
   }
}

// function: remove an entry from list of given listkey
// parameter: list, listkey
bool listRemove(ListType & list, const string & listkey){
   ListType curPoint = list;
   ListType prePoint = NULL;
   //find the curPoint is the listkey
   while(curPoint != NULL) {
      if (curPoint -> key == listkey) {
          if(prePoint == NULL){
              list = curPoint -> next;
              delete curPoint;
              return true;
          }
          else {
              prePoint->next = curPoint->next;
              delete curPoint;
              return true;
          }
      }
      prePoint = curPoint;
      curPoint = curPoint ->next;
   }
   return false;
}

// function: lookup the value of given listkey in the list
// parameter: list, listkey
int * listFind(ListType & list, const string & listkey){
   ListType curPoint = list;
   while(curPoint != NULL){
      if(curPoint -> key == listkey){
         return &(curPoint -> value);
      }
      curPoint = curPoint -> next;
   }
   return NULL;
}

// function: print all entries in the list
// parameter: list
void listPrint(ListType & list){
   ListType curPoint = list;
   while(curPoint != NULL){
      cout<<curPoint -> key<<": "<<curPoint -> value<<endl;
      curPoint = curPoint -> next;
   }
}

// function: print the list's size
// parameter: list
int listSize(ListType & list){
     ListType curPoint= list;
     int num = 0;
     while(curPoint != NULL){
         num++;
         curPoint = curPoint -> next;
     }
     return num;
}

