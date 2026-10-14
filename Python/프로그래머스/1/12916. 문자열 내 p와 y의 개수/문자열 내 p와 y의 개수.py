def solution(s):
    counts = {}
    
    for x in s:
        counts[x] = counts.get(x, 0) + 1
    
    return counts.get('p', 0) + counts.get('P', 0) == counts.get('y', 0) + counts.get('Y', 0)