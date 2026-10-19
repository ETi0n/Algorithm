from collections import Counter

def solution(participant, completion):
    counts = Counter(participant)
    
    for name in completion:
        counts[name] -= 1
    
    for name, count in counts.items():
        if count > 0:
            return name