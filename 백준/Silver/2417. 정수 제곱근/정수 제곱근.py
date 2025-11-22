n = int(input().strip())

start = 0
end = n  # [start, end) 범위

# 어떤 수의 제곱이 n보다 크거나 같은, 가장 작은 정수
while start < end:
    mid = (start + end) // 2

    if mid * mid < n:
        start = mid + 1
    else:  # mid*mid >= n
        end = mid

print(start)