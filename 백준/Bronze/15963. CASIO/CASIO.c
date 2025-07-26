#include<stdio.h>


int main() {

    // ch 1
    // short 2
    // int 4 , long 8
    // float 4, double 8

    int arr[5] = {1, 2, 3, 4, 5};

    int number = 5;

    /**
     *
     * if-else if-else: 조건적 실행과 흐름의 분기
        switch문에 의한 선택적 실행
        조건문 실습 및 지필 문제 풀이
     *
     *
     */

    int n, m;

    scanf("%d %d", &n, &m);

    if (n == m) {
        printf("1");
    } else {
        printf("0");
    }


    return 0;
}
