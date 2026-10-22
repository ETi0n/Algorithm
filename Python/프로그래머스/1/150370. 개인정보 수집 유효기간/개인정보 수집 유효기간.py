categories = {}

def solution(today, terms, privacies):
    answer = []
    t_year, t_month, t_day = today.split(".")
    
    # 약관의 유효기간 정보 저장
    for term in terms:
        category, pried = term.split()
        categories[category] = pried
        
    # 개인정보(날짜와 카테고리) 정보 분리
    index = 1
    for privacy in privacies:
        p_year, p_month, p_day = calcuate_date(*string_cutter(privacy))
        is_expired = calculate_expire(
            int(t_year), int(t_month), int(t_day),
            p_year, p_month, p_day)
        
        if is_expired: answer.append(index)
        index += 1
        
    
    return answer


def string_cutter(privacy):
    date, category = privacy.split()
    year, month, day = date.split(".")
    return category, year, month, day


def calcuate_date(category, year, month, day):
    new_year = int(year)
    new_month = int(month) + int(categories[category])
    new_day = int(day) - 1

    # 유효기간 종료일 계산
    if new_day == 0:
        new_day = 28
        new_month -= 1

    # 월이 1보다 작으면 이전 연도로 이동
    if new_month < 1:
        new_month += 12
        new_year -= 1

    # 월이 12보다 크면 다음 연도로 이동
    if new_month > 12:
        new_year += (new_month - 1) // 12
        new_month = (new_month - 1) % 12 + 1

    return new_year, new_month, new_day


def calculate_expire(t_year, t_month, t_day, p_year, p_month, p_day):
    # 연도 비교
    if t_year > p_year: return True
    elif t_year < p_year: return False

    # 같은 연도일시, 달 비교
    if t_month > p_month: return True
    elif t_month < p_month: return False

    # 같은 연도 같은 달일시, 일자 비교
    if t_day > p_day: return True
    else: return False