import Foundation

func solution(_ n:Int) -> Int {
    var result: Int = 0
    var num: Int = n
    
    while true {
        if (num < 9) { return result + num }
        
        result += num % 10
        num /= 10
    }
}