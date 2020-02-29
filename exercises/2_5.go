package main

import (
"fmt"
)

//        0  1  5
//        2  4  6
//        3  7  8

//        8  7  5
//        6  4  2
//        3  1  0

func Exercise2_5(n int) []int {
	zigzag := make([]int, n*n)
	i := 0
	n2 := n * 2
	for p := 1; p <= n2; p++ {
		x := p - n
		if x < 0 {
			x = 0
		}
		y := p - 1
		if y > n-1 {
			y = n - 1
		}
		j := n2 - p
		if j > p {
			j = p
		}
		for k := 0; k < j; k++ {
			if p&1 == 0 {
				zigzag[(x+k)*n+y-k] = i
			} else {
				zigzag[(y-k)*n+x+k] = i
			}
			i++
		}
	}

	return zigzag
}

func main() {
	num := 3
	len := 2
	for i, draw := range Exercise2_5(num) {
		fmt.Printf("%*d ", len, draw)
		if i%num == num-1 {
			fmt.Println("")
		}
	}
}