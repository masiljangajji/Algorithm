#include <stdio.h>
#include <string.h>

int main(void) {

    char s[101];
    scanf("%s", s);

    int i = 0;
    int j = (int) strlen(s) - 1;

    while (i < j) {
        if (s[i] != s[j]) {
            printf("0");
            return 0;
        }
        i++;
        j--;
    }

    printf("1");

    return 0;
}