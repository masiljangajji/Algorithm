n = int(input())

for i in range(1, n + 1):  # 1 2 3 4 5

    for j in range(n - i):  # 4 3 2 1 0
        print(end=' ')

    for k in range(i * 2 - 1):  # 1 3 5 7 9
        print('*', end='')
    print()

for i in range(1, n + 1):  # 1 2 3 4

    for j in range(i):  # 1 2 3 4
        print(end=' ')

    for k in range((n - i) * 2 - 1):  # 1 3 5 7 9
        print('*', end='')
    print()
