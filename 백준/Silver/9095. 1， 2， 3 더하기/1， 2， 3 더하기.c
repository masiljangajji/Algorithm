#include<stdio.h>
#include <string.h>
#include <stdlib.h>
#include<time.h>
#define _CRT_NO_WARNINGS
int a = 1, b = 2, c = 3;
// 11보다 작은 양수 
int check(int n)
{
	int arr[10000];
	int sum = 0, i = 0, count = 0;
	
	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 4;
	
	if (n < 4)
	{
		return arr[n];
	}

	for (int i = 4; i <= n; i++)
	{
		arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
	}
	
	return arr[n];
	


}

int main()
{
	int T, n;
	scanf("%d", &T);

	for (int i = 0; i < T; i++)
	{
		scanf("%d", &n);
		printf("%d\n",check(n));
	}
	


	return 0;
}
