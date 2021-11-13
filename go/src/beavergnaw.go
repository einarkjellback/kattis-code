package main

import (
	"fmt"
	"math"
	"strings"
)

// func main() {
func beavergnaw() {
	var dBig, vol float64
	fmt.Scan(&dBig, &vol)
	output := strings.Builder{}
	for dBig != 0 && vol != 0 {
		dSmall := math.Pow(dBig*dBig*dBig-(6.0/math.Pi*vol), 1.0/3.0)
		output.WriteString(fmt.Sprint(dSmall))
		output.WriteRune('\n')
		fmt.Scan(&dBig, &vol)
	}
	fmt.Print(output.String())
}
