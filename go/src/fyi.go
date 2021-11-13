package main

import "fmt"

// func main() {
func fyi() {
	var number []byte
	fmt.Scanln(&number)
	if number[0] == '5' && number[1] == '5' && number[2] == '5' {
		fmt.Println(1)
	} else {
		fmt.Println(0)
	}
}
