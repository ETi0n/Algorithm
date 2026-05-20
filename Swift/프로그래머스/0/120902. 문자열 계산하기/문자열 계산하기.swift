import Foundation

func solution(_ my_string:String) -> Int {
    let arr = my_string.split(separator: " ").map{ String($0) }
    var result = Int(arr[0])!
    
    for i in 1..<arr.count-1 {
        if arr[i] == "+" {
            result += Int(arr[i+1])!
        } else if arr[i] == "-" {
            result -= Int(arr[i+1])!
        }
    }
    
    return result
}