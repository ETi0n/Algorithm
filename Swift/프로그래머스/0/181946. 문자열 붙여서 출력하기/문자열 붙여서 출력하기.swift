import Foundation

let inp = readLine()!.split(separator: " ").map { $0 }
let (s1, s2) = (inp[0], inp[1])

print(s1 + s2)