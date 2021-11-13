package main

import (
	"fmt"
	"strconv"
)

// func main() {
func digitproduct() {
	var strDigits string
	fmt.Scanln(&strDigits)
	for len(strDigits) > 1 {
		prod := 1
		for _, strDigit := range strDigits {
			digit := int(strDigit - '0')
			if digit != 0 {
				prod *= digit
			}
		}
		strDigits = strconv.Itoa(prod)
	}
	fmt.Println(strDigits)
}
