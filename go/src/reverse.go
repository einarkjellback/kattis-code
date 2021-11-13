package main

import (
	"fmt"
	"strings"
)

// func main() {
func reverse() {
	var cnt int
	fmt.Scanln(&cnt)
	ints := make([]string, cnt)
	for i := 0; i < cnt; i++ {
		fmt.Scanln(&ints[i])
	}
	s := strings.Builder{}
	for i := cnt - 1; i > -1; i-- {
		s.WriteString(ints[i])
		s.WriteRune('\n')
	}
	fmt.Print(s.String())
}
