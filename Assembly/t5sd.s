/* CSC 2110, Computer Organization
 * Tutorial 5: Assignment D
 * by Claire Winogrodzki
 *
 * void encode(char* P, char* C);
 * Encodes plaintext P into cyphertext C. 
 * Changes each character by rolling the
 * lower five bits one position left.
 */
  .text
  .align  2
  .global encode
  .type encode, %function

encode:
  ldrb    w2, [x0]
  b       test

loop:
  and w3, w2, #1         *save last(rightmost) bit of P
  and w4, w2, #31        *put last 5 bits of P into w4
  lsr w4, w4, #1         *shift right
  cmp w3, 0              *if last bit = 1, insert it into 5th position
  b.eq insert
  orr w4, w4, #16

insert:
  lsr w2, w2, #5         *clear last 5 bits of P
  lsl w2, w2, #5
  orr w4, w4, w2         *replace last 5 bits with cypher
  strb w4, [x1], #1      *store cypher byte into C
  ldrb w2, [x0, #1]!     *get next character of P

test:
  cmp     w2, #0
  bne     loop

  ret

  .size   encode, . - encode
  .ident  "CSC 2110, Tutorial 5 "
  .ident  "Claire Winogrodzki"
