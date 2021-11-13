package main

import "fmt"

// func main() {
func finalexam() {
	var cnt int
	fmt.Scanln(&cnt)
	var curr string
	var next string
	fmt.Scanln(&next)
	accPoints := cnt - 1
	for i := 0; i < cnt; i++ {
		curr = next
		fmt.Scanln(&next)
		if curr != next {
			accPoints--
		}
	}
	fmt.Println(accPoints)
}
