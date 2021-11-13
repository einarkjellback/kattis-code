package main

import (
	"fmt"
)

// func main() {
func electricaloutlets() {
	var cases int
	fmt.Scanln(&cases)
	for c := 0; c < cases; c++ {
		var strips int
		fmt.Scan(&strips)
		accOutlets := 1
		var outlets int
		for i := 0; i < strips; i++ {
			fmt.Scan(&outlets)
			accOutlets += outlets
		}
		fmt.Println(accOutlets - strips)
	}
}
