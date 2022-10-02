/* CSC 2110, Computer Organization 
 * Tutorial 1: Assignment B- int inches(f, i)
 * by Claire Winogrodzki
 *
 * extern "C" int inches(int f, int i);
 * This function takes feet f and 
 * inches i and returns the
 * total number of inches
 */
  .text
  .align  4
  .global inches
  .type inches, %function

inches:
  mov  x2, #12       
  mul  x0, x0, x2    //feet * 12
  add x0, x1, x0     //(feet * 12) + inches
  ret
  
  .size inches, .-inches
  .ident  "GCC: (SUSE Linux) 4.8.5"
  .ident  "Claire Winogrodzki, CSC 2110, t1"
  .section  .note.GNU-stack,"",%progbits
