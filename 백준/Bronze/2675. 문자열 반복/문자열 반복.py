import sys

t = int(input())

for _ in range(t):
    r_str, s = input().split()
    r = int(r_str)

    result = ''
    for ch in s:
        result += (ch * r)
    print(result)
