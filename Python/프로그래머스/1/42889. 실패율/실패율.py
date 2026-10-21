from collections import Counter

def solution(N, stages):
    counters = Counter(stages)
    userCounts = [0] * (N + 2)
    failureRate = {}

    for stage, count in counters.items():
        userCounts[stage] = count


    # 실패율 계산
    for i in range(1, N + 1):
        # 스테이지에 도달한 플레이어 수
        a = 0
        for x in userCounts[i:N+2]:
            a += x

        # 도달한 플레이어가 없는 경우
        if a == 0:
            failureRate[i] = 0
            continue

        # 해당 스테이지에 도달했으나 클리어하지 못한 플레이어 수
        b = userCounts[i]

        failureRate[i] = b / a

    # 실패율이 높은 순서대로 정렬
    answer = sorted(
        failureRate.items(),
        key=lambda x: (-x[1], x[0])
    )

    # 스테이지 번호만 반환
    return [stage for stage, rate in answer]