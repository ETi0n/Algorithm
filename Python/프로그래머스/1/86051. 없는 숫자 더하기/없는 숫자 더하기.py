def solution(numbers):
    answer = 0
    counts = dict.fromkeys([0, 1, 2, 3, 4, 5, 6, 7 ,8 ,9], 0)
    
    for x in numbers:
        counts[x] = counts.get(x) + 1
    
    for x in range(10):
        if counts[x] == 0:
            answer += x
    
    return answer