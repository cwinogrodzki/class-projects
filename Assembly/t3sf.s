/* CSC 2110, Computer Organization 
 * Tutorial 3: Assignment F
 * by Claire Winogrodzki

 * extern "C" void copyabc(char* R, char* S);
 * This procedure copies the letters 
 * in string R to string S.
 */
  .text
  .align  2
  .global copyabc
  .type copyabc,function  

copyabc:            //check if null character
  ldrb w3, [x0]
  cmp x3, #0
  bne test
  ret
  
skip:               //skip if not letter           
  add  x0, x0, #1
  b copyabc

test:               //check if letter
  cmp  x3, #65
  b.lt skip
  cmp x3, #121
  b.gt skip

copy:               //copy to string S
  strb w3, [x1]
  add x0, x0, #1
  add x1, x1, #1
  b copyabc



  .size copyabc, . - copyabc
  .ident  "CSC 2110, Tutorial 3 "
  .ident  "Claire Winogrodzki"
