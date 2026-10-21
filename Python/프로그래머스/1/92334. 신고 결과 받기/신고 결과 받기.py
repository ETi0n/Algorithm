def solution(id_list, report, k):
    answer = dict.fromkeys(id_list, 0)
    recodes = {user: set() for user in id_list}
    
    for x in report:
        # 신고자와 대상자 분리
        user, target = x.split()
        
        # 대상자를 신고한 신고자 기록
        recodes[target].add(user)
        
    # 신고 횟수가 k번 일시, 계정 정지 후 결과 메일 발송
    for users in recodes.values():
        if len(users) >= k:
            for user in users:
                answer[user] += 1
        
    return list(answer.values())