// Name:Hang Dong
// USC NetID:donghang
// CSCI 455 PA5
// Fall 2018

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

// Constructor of Table class, using default hashSize
Table::Table() {
      hashTable = new ListType[HASH_SIZE];
      hashSize = HASH_SIZE;
      for(int i = 0; i < hashSize; i++){
         hashTable[i] = NULL;
      }
}

// Constructor of Table class, using self-input hashSize
//parameter: new hash size
Table::Table(unsigned int hSize) {
    hashTable = new ListType[hSize];
    hashSize = hSize;
    for(int i = 0; i <hashSize; i++){
        hashTable[i] = NULL;
    }
}

// LookUp method, return the value of given key
//parameter: key
int * Table::lookup(const string &key) {
    ListType node = hashTable[hashCode(key)];
    return listFind(node, key);
   //*& can change original value in method; * only pass the value and copy
}

// remove method, delete the entry of given key
//parameter: key
bool Table::remove(const string &key) {
    ListType & node = hashTable[hashCode(key)];
    return listRemove(node, key);
}

// insert method, insert the value and key given as a new entry.
//parameter: key, value
bool Table::insert(const string &key, int value) {
    ListType & node = hashTable[hashCode(key)];
    return listInsert(node, key, value);
}

// return the amount of entries in the list
int Table::numEntries() const {
    int num = 0;
    for(int i = 0; i < hashSize; i++){
        num += listSize(hashTable[i]);
    }
    return num;
}

// LookUp method, return the value of given key
void Table::printAll() const {
    for(int i = 0; i < hashSize; i++){
        listPrint(hashTable[i]);
    }
}

// print out all information about the list
void Table::hashStats(ostream &out) const {
    //   number of buckets: 997
    //   number of entries: 10
    //   number of non-empty buckets: 9
    //   longest chain: 2
    int nonEmptyBuckets = 0;
    int longestChain = 0;
    int numEntry = numEntries();
    for(int i = 0; i < hashSize; i++){
        int temp = listSize(hashTable[i]);
        if(hashTable[i] != NULL){
            nonEmptyBuckets++;
        }
        if(temp > longestChain){
            longestChain = temp;
        }
    }
    out << "number of buckets: " << hashSize << endl;
    out << "number of entries: " << numEntry << endl;
    out << "number of non-empty buckets: " << nonEmptyBuckets << endl;
    out << "longest chain: " << longestChain << endl;
}


// add definitions for your private methods here
