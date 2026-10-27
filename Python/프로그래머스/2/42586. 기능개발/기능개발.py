from collections import deque

def solution(progresses, speeds):
    queue = deque()
    
    for i in range(len(progresses)):
        if (100 - progresses[i]) % speeds[i] == 0:
            queue.append((100 - progresses[i]) // speeds[i])
        else:
            queue.append((100 - progresses[i]) // speeds[i] + 1)
    
    save = queue.popleft()
    answer = []
    count = 1
    while queue:
        node = queue.popleft()
        
        if node <= save:
            count += 1
            continue
        
        save = node
        answer.append(count)
        count = 1
    answer.append(count)
    
    return answer