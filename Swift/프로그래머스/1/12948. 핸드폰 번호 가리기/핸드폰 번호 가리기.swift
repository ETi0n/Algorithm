func solution(_ phone_number:String) -> String {
    var lastNum = String(phone_number.suffix(4))
    var starCount = phone_number.count - 4
    var result = ""
    
    for _ in 0..<starCount {
        result.append("*")
    }
    result.append(lastNum)
    
    return result
}