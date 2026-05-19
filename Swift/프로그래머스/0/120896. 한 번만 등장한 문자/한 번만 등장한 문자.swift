import Foundation

// 1. Collect(수집)
// 2. Aggregate(집계)
// 3. Filter(필터링)
// 4. Transform(변환)

func solution(_ s:String) -> String {
    var count: [Character: Int] = [:]
    
    // 문자열 순회 후 빈도수 집계
    for ch in s {
        count[ch, default: 0] += 1
    }
    
    // 한 번 등장한 문자열 추출 → 정렬 → 문자열로 변환
    return String(
        s.filter { count[$0] == 1}
         .sorted()
    )
}