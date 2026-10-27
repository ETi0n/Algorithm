from collections import deque

def solution(priorities, location):
    queue = deque()
    stack = sorted(list(priorities))
    
    # 순서와 우선순위를 큐에 저장
    for i in range(len(priorities)):
        queue.append((priorities[i], i))
    
    count = 0
    high_priority = stack.pop()
    while queue:
        process = queue.popleft()
        
        if high_priority != process[0]:
            queue.append(process)
            continue
        
        count += 1
        if process[1] == location:
            return count 
        high_priority = stack.pop()
    
    return -1