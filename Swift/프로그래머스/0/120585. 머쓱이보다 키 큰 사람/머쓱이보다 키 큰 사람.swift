import Foundation

func solution(_ array:[Int], _ height:Int) -> Int {
    var count: Int = 0
    
    for n in array {
        if n > height {
            count += 1
        }
    }
    
    return count
}