def solution(sizes):
    width = []
    hight = []
    
    for i in sizes:
        width.append(max(i[0], i[1]))
        hight.append(min(i[0], i[1]))
        
    width.sort()
    hight.sort()
    
    return width[len(sizes) - 1] * hight[len(sizes) - 1]