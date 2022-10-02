// CSC 2110, Computer Organization
// Tutorial 4: Addressing Modes II Assignment D
// by Claire Winogrodzki
 
// This program declares two arrays,
// an array of records and a simpler array of short integers.
// It calls a function that copies data from one to the other,
// and displays both.

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cctype>
using namespace std;

typedef struct {
  char      name[7];
  short int score;
  int       id;
} record;

record  CSC123[] = {
  { "Anna",   91, 354834588 },
  { "Bill",   92, 212749945 },  
  { "Cindy",  93, 758123544 },
  { "Dan",    94, 352655547 },  
  { "Elise",  95, 685421538 },
  { "Frank",  96, 268547231 },
  { "Ginger", 97, 451121168 }
};

int IDs[7];

extern "C" void CopyIDs( 
  int N, int IDs[], record R[]);

int main() {
  int i;
  char s[256];
  
  cout << "Record extraction." << endl
  << "These are sample records:" << endl
  << endl
  << "    Name   Score  ID" << endl;
  for(i = 0; i < 7; i++) {
    cout << setw(8) << CSC123[i].name;
    cout << setw(7) << CSC123[i].score;
    cout << setw(12) << CSC123[i].id;
    cout << endl;
  }
  cout << endl 
  << "Press return to continue:";
  cin.getline(s, 10);
  
  CopyIDs(7, IDs, CSC123);
  
  cout << endl << "IDs:" << endl;
  for(i = 0; i < 7; i++)
    cout << IDs[i] << endl;
  cout << endl;
  return 0;
}
