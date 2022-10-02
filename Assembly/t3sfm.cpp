// CSC 2110, Computer Organization
// Tutorial 3: Assignment F
// by Claire Winogrodzki
 
// This program reads input string (string R)
// and copies the letters to string S.

#include <iostream>
#include <string.h>
using namespace std;

extern "C" void copyabc(char* R, char* S);

int main(){
  char s[256] = "";
  char r[256] = "";
  
  cout << "Copy letters in string R to String S." << endl
  << "Please enter a string." << endl
  << "Enter an empty line to quit." << endl;
  do {
    strncpy(r, "", 256);     //reset strings
    strncpy(s, "", 256);

    cout << "string R> ";
    cin.getline(r,256);
    cout << "string S> ";

    copyabc(r, s);
    
    cout << s << endl;

  } while (*r != 0);
  return 0;
}
