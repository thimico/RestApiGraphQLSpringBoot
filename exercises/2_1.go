package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
	"time"
)

type EurekaFile struct {
	CreationDate time.Time
	ServiceName  string
	IpAddress    string
	Message      string
}

func (conf EurekaFile) ToString() string {
	return fmt.Sprintf("CreationDate: %v\nServiceName: %s\nIpAddress: %s\nMessage: %s\n",
		conf.CreationDate.Format("2006-01-02 15:04:05"), conf.ServiceName, conf.IpAddress, conf.Message)
}


func main() {
	Exercise2_1()

}

func Exercise2_1() {
	file, err := os.Open("exercises/data/eureka_logs.csv")
	if err != nil {
		fmt.Println(err)
	} else {
		var logs []EurekaFile
		scanner := bufio.NewScanner(file)
		for scanner.Scan() {
			result := strings.Split(scanner.Text(), ";")
			i, err := strconv.ParseInt(strings.Split(result[0], ".")[0], 10, 64)
			if err != nil {
				fmt.Println(err)
			}
			t := time.Unix(i, 0)
			logs = append(logs, EurekaFile{
				CreationDate:       t,
				ServiceName:     result[1],
				IpAddress:    result[2],
				Message: result[3],
			})
		}
		fmt.Println("Eureka Logs List from CSV File")
		for _, eurekaLog := range logs {
			fmt.Println(eurekaLog.ToString())
			fmt.Println("-------------------------")
		}
	}
	file.Close()
}
