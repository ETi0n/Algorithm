import Foundation

func solution(_ dots:[[Int]]) -> Int {
    let xs = dots.map { $0[0] }
    let ys = dots.map { $0[1] }
    
    let width: Int = xs.max()! - xs.min()! 
    let height: Int = ys.max()! - ys.min()!
    
    return width * height
}