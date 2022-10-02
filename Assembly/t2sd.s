/*  CSC 2110, Computer Organization 
 *  Tutorial 2: Labels & Branch Instructions
 *  Assignment D: grade(int n)
 *  by Claire Winogrodzki

 *  extern "C" void grade(int n);
 *  This function returns a letter grade
 *  A-F, depending on input n.
 */
  .text
  .align  2
  .global grade
  .type   grade,function

grade:
  mov x1, #70          //ASCII counter

  cmp x0, #0         //check if <0
  b.lt invalid       //invalid if true

  cmp x0, #100       //check if >100
  b.gt invalid       //invalid if true

letter:
  cmp x0, #60
  b.lt return

  sub x1, x1, #2
  cmp x0, #70
  b.lt return

  sub x1, x1, #1
  cmp x0, #80
  b.lt return

  sub x1, x1, #1
  cmp x0, #90
  b.lt return

  sub x1, x1, #1
  cmp x0, #100
  b.le return

return:
  mov x0, x1         //move ASCII number into x0
  ret

invalid:
  mov x0, #0         //returns 0 if invalid entry
  ret

  .size  grade, . - grade
  .ident  "CSC 2110, Tutorial 2 "
  .ident  "Claire Winogrodzki"
