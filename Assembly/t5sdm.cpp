// CSC 2110, Computer Organization
// Tutorial 5: Assignment D
// by Claire Winogrodzki
 
// This program prompts for a string
// and copies it into a cyphertext.

#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <cctype>
#include <string.h>
using namespace std;

extern "C" void encode(char* P, char* C);
char P[256];

int main() {
  char C[256];
  
  cout << "\nEncoding plaintext to cyphertext" << endl
  << "Please enter a string of characters." << endl
  << "Enter an empty line to quit." << endl 
  << endl;

  do {
    strncpy(P, "", 256);     //reset strings
    strncpy(C, "", 256);
    
    cout << "> ";
    cin.getline(P, 256);

    encode(P, C);
    
    cout << "Before encoding: " << P << endl
    << "After encoding: " << C << endl;  
  } while (*P != 0);

  cout << "Done." << endl;
  return 0;
}
