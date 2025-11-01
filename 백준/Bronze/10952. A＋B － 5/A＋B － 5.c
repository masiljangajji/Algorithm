#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>

int main() {
    int T, arr[1000];
    int a, b, i = 0, j = 0;

    int result;


    while (1) {
        scanf("%d %d", &a, &b);
        i++;
        if (a == 0 && b == 0)
            break;
        printf("%d\n", a + b);
    }

    return 0;
}