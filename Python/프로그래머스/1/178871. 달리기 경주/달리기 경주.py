def solution(players, callings):
    rank = dict(zip(players, range(1, len(players)+1)))
    
    for player in callings:
        pre_rank = rank[player]
        pre_player = players[pre_rank-2]

        rank[player] = pre_rank - 1
        rank[pre_player] = pre_rank
        players[pre_rank-1] = pre_player
        players[pre_rank-2] = player
    
    return players