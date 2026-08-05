import Foundation

func solution(_ code:String) -> String {
    var ret = ""
    var mode = 0
    var idx = 0
    
    for ch in code {
        switch mode {
            case 0:
                if ch == "1" { mode = 1 }
                else { if idx % 2 == 0 { ret.append(ch) }}
            case 1:
                if ch == "1" { mode = 0 }
                else { if idx % 2 != 0 { ret.append(ch) }}
            default: continue
        }
        idx += 1
    }
    
    return ret == "" ? "EMPTY" : ret
}