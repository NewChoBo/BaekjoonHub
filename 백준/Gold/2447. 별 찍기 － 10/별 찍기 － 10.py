N = int(input())
c = [[' ']*N for _ in range(N)]

#재귀적으로
def making_Patern(x, y, index):
    global c
    if index == 1:    
        c[x][y] = '*'
        # c = [[1]*3 for _ in range(3)]
        # c[1][1] = 0
        # return c
        return

    for i in range(3):
        for j in range(3):
            x1 = x + (index/3) * i
            y1 = y + (index/3) * j

            if i==1 and j==1:
                #중앙지점
                #맨 처음에 0으로 초기화해서 생성했다면 continue 로 뛰어넘어도 될듯
                #is_mid(x1, y1, index/3)
                continue
            
            making_Patern(int(x1), int(y1), index/3)
    return


making_Patern(0,0,N)

#print(c)
for i in range(N):
    for j in range(N):
        print(c[i][j], end='')
    print('')