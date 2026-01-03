def is_balanced(line):
    stack = []

    for ch in line:

        if ch == '(' or ch == '[' or len(stack) == 0:
            stack.append(ch)
        
        elif ch == ')':
            if stack[-1] == '(':
                stack.pop()
            else:
                stack.append(ch)

        elif ch == ']':
            if stack[-1] == '[':
                stack.pop()
            else:
                stack.append(ch)

    return len(stack) == 0


n = int(input())

for i in range(n):
    line = input()

    if is_balanced(line):
        print("YES")
    else:
        print("NO")
