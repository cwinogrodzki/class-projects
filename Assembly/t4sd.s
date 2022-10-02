/* CSC 2110, Computer Organization
 * Tutorial 4: Addressing Modes II Assignment D
 * by Claire Winogrodzki
 *
 * CopyIDs(int N, int IDs[],
 *            record R[]);
 * copies N IDs from array R into array S
 */
  .text
  .align  2
  .global CopyIDs
  .type CopyIDs,function

CopyIDs: 
  sub   x2, x2, #4

loop:
  ldr  w3, [x2, #16]!
  str  w3, [x1], #4
  subs  w0, w0, #1
  b.gt loop

  ret

  .size CopyIDs, . - CopyIDs
  .ident  "CSC 2110, Tutorial 4 "
  .ident  "Claire Winogrodzki"
