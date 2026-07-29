import Foundation

func solution(_ keyinput:[String], _ board:[Int]) -> [Int] {
    let x = (board[0] - 1) / 2
    let y = (board[1] - 1) / 2

    var position = [0, 0]
    
    
    for i in keyinput {
        var px = position[0]
        var py = position[1]
        
        switch i {
            case "left": px -= 1
            case "right": px += 1
            case "up": py += 1
            case "down": py -= 1
            default: break
        }
        
        if abs(px) > x || abs(py) > y { continue }
        position = [px, py]
    }
    
    return position
}