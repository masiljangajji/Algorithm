#include <stdio.h>

int main(void) {
    long long n;
    if (scanf("%lld", &n) != 1) return 0;

    // 코드1 수행 횟수: n^3 (n <= 500,000 이므로 64-bit 정수로 안전)
    long long cnt = n * n * n;

    printf("%lld\n", cnt);
    printf("3\n");
    return 0;
}