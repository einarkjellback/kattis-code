package main

import "fmt"

func main() {
	var students int
	fmt.Scanln(&students)

}

// comboCnt := make(map[int]int)
// var courses [5]int
// max := 0
// for i := 0; i < students; i++ {
// 	// fmt.Scan(&courses)
// 	for j := range courses {
// 		fmt.Scan(&courses[j])
// 	}
// 	hash := 1
// 	for _, c := range courses {
// 		hash *= c
// 	}
// 	for _, c := range courses {
// 		hash += c
// 	}
// 	comboCnt[hash]++
// 	if comboCnt[hash] > max {
// 		max = comboCnt[hash]
// 	}
// }

// popCourseCnt := 0
// for _, v := range comboCnt {
// 	if v == max {
// 		popCourseCnt += max
// 	}
// }
// fmt.Println(popCourseCnt)
// }
