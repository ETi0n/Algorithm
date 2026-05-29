func solution(_ num:Int, _ k:Int) -> Int {
    let target = Character(String(k))
    
    for (i, v) in String(num).enumerated() {
        if v == target {
            return i + 1
        }
    }
    
    return -1
}