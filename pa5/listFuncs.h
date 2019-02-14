// Name:Hang Dong
// USC NetID:donghang
// CSCI 455 PA5
// Fall 2018


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in header files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
using namespace std;

struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

//function: insert a name and value to list
//parameter: list, listkey, value
bool listInsert(ListType & list, const string & listkey, int value);

//function: remove the entry of given name.
//parameter: list, listkey
bool listRemove(ListType & list, const string & listkey);

//function: look up  the value of given name.
//parameter: list, listkey
int * listFind(ListType & list, const string & listkey);

//function: print all entries in list.
//parameter: list
void listPrint(ListType & list);

//function: print the size of the list.
//parameter: list
int listSize(ListType & list);


// keep the following line at the end of the file
#endif
