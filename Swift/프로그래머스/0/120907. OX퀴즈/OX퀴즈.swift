import Foundation

func solution(_ quiz:[String]) -> [String] {
    var result : [String] = []
    
    for str in quiz {
        // 공백 기준으로 분리 (반환값은 Substring)
        var arr = str.split(separator: " ")
        
        // 타입 변환
        let x = Int(arr[0])!
        let symbol = String(arr[1])
        let y = Int(arr[2])!
        let answer = Int(arr[4])!
        
        // 계산 후 답 저장
        if calculation(x, symbol, y) == answer {
            result.append("O")
        } else {
            result.append("X")
        }
    }
    
    return result
}

func calculation(_ x: Int, _ symbol: String, _ y: Int) -> Int {
    switch symbol {
        case "+":
            return x + y
        case "-":
            return x - y
        default:
            return 0
    }
}