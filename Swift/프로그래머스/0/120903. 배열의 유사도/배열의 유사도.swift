import Foundation

func solution(_ s1:[String], _ s2:[String]) -> Int {
    var st: [String:Int] = [:]
    
    // 사전으로 사용할 배열을 하나 등록
    for i in s1 {
        st[i] = 0
    }
    
    // 다른 배열의 값을 넣어보고 같은 원소가 있다면 카운트
    for i in s2 {
        if st[i] != nil {
            st[i]! += 1
        }
    }
    
    // 최종적으로 중복된 원소의 개수 집계
    return st.filter { $0.value != 0 }.count
}