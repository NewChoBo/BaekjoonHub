#반복할 횟수 입력받고, 그만큼 반복하기
T = int(input())
for _ in range(T):
  #본격적인 계산 시작
  x, y = map(int,input().split())
  z = y - x

  cnt = 0
  index = 0
  adder = 1
  
  while index < z:
    for __ in range(2):
      index += adder
      cnt += 1
      if index >= z:
        break
    adder += 1

  print(cnt)