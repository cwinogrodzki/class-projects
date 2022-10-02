// CSC 2110, Computer Organization
// Tutorial 1: Assignment B- int inches(f, i)
// by Claire Winogrodzki
 
// This program finds the total number of inches
// in f feet, i inches

#include <iostream>
#include <stdio.h>
using namespace std;

extern "C" int inches(int f, int i);

int main()
{
  int f, i, t;

  cout << "Find total inches in f feet, i inches" << endl 
  << "Please enter integers, 'q' to quit." << endl 
  << endl
  << "Feet> ";
  
  scanf("%d", &f);

  cout << "Inches> ";

  scanf("%d", &i);

  //I couldn't figure out how to continue prompting for input after the first run-through

  //while(cin >> i) {
    t = inches(f, i);
    cout << f << " feet, " 
    << i << " inches = " << t
    << " total inches " << endl;

    /*<< "Feet> ";
  
    scanf("%d", f);
  
    cout << "Inches> ";

    scanf("%d", i);
  }*/
  return 0;
}
