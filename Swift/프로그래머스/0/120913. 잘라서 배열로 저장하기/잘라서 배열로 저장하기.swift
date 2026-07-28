import Foundation

func solution(_ my_str: String, _ n: Int) -> [String] {
    // stride(): 일정 간격으로 숫자를 만들어주는 함수
    // stride가 0, 3, 6을 반환해주고, 이를 인덱스로 사용
    return stride(from: 0, to: my_str.count, by: n).map {
        let start = my_str.index(my_str.startIndex, offsetBy: $0) // 시작 위치는 $0 (0 → 3 → 6)
        let end = my_str.index(start, offsetBy: min(n, my_str.count - $0)) // 마지막 문자열이 끝을 넘지 않도록
        return String(my_str[start..<end])
    }
}