import sys


def is_balanced(line):
    stack = []

    for ch in line:
        if ch == '(' or ch == '[':
            stack.append(ch)

        elif ch == ')':
            if not stack or stack[-1] != '(':
                return False
            stack.pop()

        elif ch == ']':
            if not stack or stack[-1] != '[':
                return False
            stack.pop()

    return len(stack) == 0


input = sys.stdin.readline

while True:
    line = input().rstrip('\n')
    if line == ".":
        break

    if is_balanced(line):
        print("yes")
    else:
        print("no")
