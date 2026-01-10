#include <stdio.h>
#include <stdlib.h>

static int cmp_int_asc(const void *a, const void *b) {
    int x = *(const int *)a;
    int y = *(const int *)b;
    if (x < y) return -1;
    if (x > y) return 1;
    return 0;
}

int main(void) {
    int N;
    if (scanf("%d", &N) != 1) return 0;

    int *arr = (int *)malloc(sizeof(int) * (size_t)N);
    if (!arr) return 0;

    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    int x;
    scanf("%d", &x);

    qsort(arr, (size_t)N, sizeof(int), cmp_int_asc);

    int l = 0, r = N - 1;
    int cnt = 0;

    while (l < r) {
        int sum = arr[l] + arr[r];

        if (sum == x) {
            cnt++;
            r--;
        } else if (sum > x) {
            r--;
        } else {
            l++;
        }
    }

    printf("%d\n", cnt);

    free(arr);
    return 0;
}