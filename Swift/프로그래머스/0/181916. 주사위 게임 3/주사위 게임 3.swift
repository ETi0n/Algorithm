import Foundation

func solution(_ a:Int, _ b:Int, _ c:Int, _ d:Int) -> Int {
    var result = 0.0
    var (A, B, C, D) = (Double(a), Double(b), Double(c), Double(d))
    
    // 네 주사위가 모두 같은 경우
    if A == B && A == C && A == D {
        result = 1111 * A
    } else {
        // 세 주사위가 같은 경우
        if A == B && B == C { result = pow(10 * A + D, 2) }
        else if A == B && B == D { result = pow(10 * A + C, 2) }
        else if B == C && C == D { result = pow(10 * B + A, 2) }
        else if C == D && D == A { result = pow(10 * A + B, 2) }
        else {
            // 두 주사위가 같은 경우
            if A == B { result = C == D ? (A + C) * (abs(A - C)) : C * D }
            else if A == C { result = B == D ? (A + B) * (abs(A - B)) : B * D } 
            else if A == D { result = B == C ? (A + B) * (abs(A - B)) : B * C }
            else if B == C { result = A * D } // 위에서 경우의 수 제거
            else if B == D { result = A * C }
            else if C == D { result = A * B }
            else {
                // 모두 다른 경우
                result = min(A, B, C, D)
            }
        }
    }
    
    return Int(result)
}