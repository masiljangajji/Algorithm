import sys

input = sys.stdin.readline

n = int(input())
l = []

for _ in range(n):
	l.append(int(input()))
count = 0
max = 0
for x in reversed(l):
	if max < x:
		max = x
		count += 1
print(count)