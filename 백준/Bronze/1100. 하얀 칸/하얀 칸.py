# 체스판 데이터를 입력받기
board = [input().strip() for _ in range(8)]

# 말이 놓인 하얀 칸 개수 세기
count = 0
for i in range(8):
    for j in range(8):
        # (i + j) % 2 == 0이면 하얀 칸
        if (i + j) % 2 == 0 and board[i][j] == 'F':
            count += 1

print(count)
