import Foundation

let inp = readLine()!.components(separatedBy: [" "]).map { $0 }
let (str, n) = (inp[0], Int(inp[1])!)

var result = ""
for _ in 0 ..< n {
    result.append(str)
}
print(result)