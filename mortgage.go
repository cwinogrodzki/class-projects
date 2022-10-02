//Claire Winogrodzki
//CSC 3110
//Semester Project- Mortgage Calculator
//11/26/2021
//Program written in Go Programming Language. This program
//will determine monthly mortgage payments and the total
//payment amount over x years, based on user inputs.

package main

import (
	"fmt" //I/O package
	"math"
)

//P = principal, r = interest rate, m = # of monthly payments

//declare variables as floats
var r, monthly, down, m, years, P float64

//mortgage equation- takes 3 float values and returns a float
func payment(P, r, m float64) float64 {
	return (P * (r / 12)) / (1 - math.Pow((1+r/12), -m))
}

//print instructions and get user inputs
func main() {
	fmt.Print("How much does the house cost? ")
	fmt.Scanf("%f", &P) //scans user input as a float value and stores in P
	fmt.Print("\nWhat percent are you putting down? ")
	fmt.Scanf("%f", &down)
  down = down * .01 * P
  P = P - down
	fmt.Println("\nYou are putting down", down, "leaving", P, "for the mortgage.")
	fmt.Print("\nHow many years does the mortgage last? ")
	fmt.Scanf("%f", &years)
	m = years * 12
	fmt.Print("\nWhat is your interest rate? ")
	fmt.Scanf("%f", &r)
	r = r * .01
	monthly = payment(P, r, m)
	fmt.Println("\nYou will make", m, "payments of $", monthly)
	fmt.Println("Over", years, "years, this will be a total of $", (m * monthly))
}
