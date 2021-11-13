package main

import (
	"fmt"
)

// func main() {
func greetings() {
	var greet string
	fmt.Scan(&greet)

	eCnt := len(greet) - 2
	reply := "h"
	for i := 0; i < eCnt*2; i++ {
		reply += "e"
	}
	reply += "y"

	fmt.Print(reply)
}
