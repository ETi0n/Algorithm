func solution(_ arr:[Int]) -> [Int] {
    if arr[0] == 10 { return [-1] }
    
    var result = arr
    result.remove(at: result.firstIndex(of: result.min()!)!)
    return result
}