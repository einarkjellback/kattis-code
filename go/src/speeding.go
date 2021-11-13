package main

import "fmt"

// func main() {
func speeding() {
	var photoCnt int
	fmt.Scanln(&photoCnt)
	maxSpeed := 0
	var currT, currD, nextT, nextD int
	currT, currD = 0, 0
	var eatInput string
	fmt.Scanln(&eatInput) // First line is "0 0"
	for i := 1; i < photoCnt; i++ {
		fmt.Scan(&nextT)
		fmt.Scanln(&nextD)
		speed := (nextD - currD) / (nextT - currT)
		if speed > maxSpeed {
			maxSpeed = speed
		}
		currT, currD = nextT, nextD
	}
	fmt.Println(maxSpeed)
}
