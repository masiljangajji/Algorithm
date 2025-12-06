#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define MAX 1000001
#define INF 987654321

static int arr[MAX];

static int cmp_int(const void *a, const void *b) {
    int x = *(const int *)a;
    int y = *(const int *)b;
    if (x < y) return -1;
    if (x > y) return 1;
    return 0;
}

static int iabs_int(int x) {
    return x < 0 ? -x : x;
}

int main(void) {
    int tc;
    if (scanf("%d", &tc) != 1) return 0;

    while (tc--) {
        int N, K;
        scanf("%d %d", &N, &K);

        for (int i = 0; i < N; ++i) {
            scanf("%d", &arr[i]);
        }

        qsort(arr, N, sizeof(int), cmp_int);

        int cnt = 0;
        int minRes = INF;
        int l = 0, r = N - 1;

        while (l < r) {
            int le = arr[l];
            int ri = arr[r];
            int sum = le + ri;
            int diff = iabs_int(K - sum);

            if (diff < minRes) {
                minRes = diff;
                cnt = 1;
            } else if (diff == minRes) {
                cnt++;
            }

            if (sum == K) {
                l++;
                r--;
            } else if (sum > K) {
                r--;
            } else {
                l++;
            }
        }

        printf("%d\n", cnt);
    }

    return 0;
}