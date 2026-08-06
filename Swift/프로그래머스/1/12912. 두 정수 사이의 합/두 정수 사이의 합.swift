func solution(_ a:Int, _ b:Int) -> Int64 {
    var result = 0
    
    // a와 b가 같은 경우
    if a == b { return Int64(a) }
    
    // a와 b 중 대소 관계 구분 후 덧셈
    for i in min(a, b) ..< max(a, b) + 1 {
        result += i
    }
    
    return Int64(result)
}