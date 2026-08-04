import Foundation

let str = readLine()!
var result = ""

for ch in str {
    if ch.isLowercase {
        result += String(ch).uppercased()
    } else {
        result += String(ch).lowercased()
    }
}

print(result)