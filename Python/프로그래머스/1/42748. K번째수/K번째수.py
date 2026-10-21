def solution(array, commands):
    answer = []
    
    for x in commands:
        i = x[0] - 1
        j = x[1]     # 마지막 숫자는 포함이 안됨으로
        k = x[2] - 1
        
        answer.append(sorted(array[i:j])[k])
    
    return answer