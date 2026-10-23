def solution(clothes):
    answer = 1
    box = {}
    for item, category in clothes:
        if category not in box:
            box[category] = []
        box[category].append(item)
    
    etc = 0
    for items in box.values():
        # 각 카테고리마다 하나 선택하거나, 아예 선택 안했거나 = 총 개수 + 1
        answer *= len(items) + 1

    return answer - 1 # 아무것도 선택하지 않은 경우 제외