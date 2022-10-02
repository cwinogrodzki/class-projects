// CSC 2110, Computer Organization
// Tutorial 2: Loops and branches.
// Assignment D: grade(int n)
// by Claire Winogrodzki
 
// This program reads an integer, 0-100,
// and returns a letter grade correlating
// to the integer score

#include <iostream>
using namespace std;

extern "C" int grade(int n);

int main(){
  char c;
  int n;

  cout << "Letter grade based on score entered." << endl 
  << "Please enter an integer score, 0-100, 'q' to quit." << endl 
  << endl
  << "Score> ";

  while (cin >> n) {
    c = char(grade(n));
    if(int(c) == 0){
      cout << "Please enter a valid integer from 0-100" << endl;
    }
    else{
    cout << "Your grade is: " << c << endl;
    }
  }

  return 0;
}
