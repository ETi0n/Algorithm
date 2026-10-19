from collections import Counter

def solution(nums):
    counters = Counter(nums)
    half = len(nums) / 2
    
    if len(counters) >= half:
        return half
    else:
        return len(counters)