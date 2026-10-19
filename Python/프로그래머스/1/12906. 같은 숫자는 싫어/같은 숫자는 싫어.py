def solution(arr):
    answer = []
    
    save = -1
    for x in arr:
        if x == save:
            continue
        
        save = x
        answer.append(x)
    
    return answer