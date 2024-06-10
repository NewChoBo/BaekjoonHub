m=int(input())

for i in range (m):
    a, b = map(int, input().split())
    
    if a==b:
        print(a)
        continue

    if b > a:
        temp = a
        a = b
        b = temp

    #최대공약수 구하기
    c = a - b
    while True:    
        if a%c==0 and b%c==0:
            #print(c)
            break  # c 가 최대공약수면 빠져나옴
        c = c-1

    #최소공배수 구하기
    a1 = int(a/c)
    b1 = int(b/c)
    print(int(a1*b1*c))