package main

import (
	"fmt"
	"strconv"
	"strings"
)

// func main() {
func homework() {
	var input string
	fmt.Scanln(&input)
	tasks := strings.FieldsFunc(input, func(r rune) bool { return r == ';' })
	accTask := 0
	for _, t := range tasks {
		if strings.ContainsRune(t, '-') {
			taskInterval := strings.FieldsFunc(t, func(r rune) bool { return r == '-' })
			lo, _ := strconv.Atoi(taskInterval[0])
			hi, _ := strconv.Atoi(taskInterval[1])
			accTask += hi - lo + 1
		} else {
			accTask++
		}
	}
	fmt.Println(accTask)
}
