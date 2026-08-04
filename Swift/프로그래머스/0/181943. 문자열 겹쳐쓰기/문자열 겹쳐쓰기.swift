import Foundation

func solution(_ my_string:String, _ overwrite_string:String, _ s:Int) -> String {
    
    let remain_str = my_string.count - s - overwrite_string.count
    
    if remain_str > 0 {
        return my_string.prefix(s) + overwrite_string + my_string.suffix(remain_str)
    } else {
        return my_string.prefix(s) + overwrite_string
    }
}