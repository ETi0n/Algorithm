import Foundation

func solution(_ array:[Int]) -> Int {
    var count: Int = 0
    for n in array {
        for ch in String(n) {
            if ch == "7" {
                count += 1
            }
        }
    }
    return count
}