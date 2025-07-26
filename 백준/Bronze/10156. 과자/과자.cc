#include <iostream> 
#include<string>
#include <algorithm>
using namespace std;

int main()
{
	int K, N, M; // 과자가격 k 개수 N 가진돈 M

	cin >> K >> N >> M;

	int c = K * N; // 필요한돈 

	int d = M - c; // 가진돈  - 필요한돈 이게 양수면 0출력 음수면 그만큼 받으면됨. 

	if (d > 0)
	{
		cout << "0";
		return 0;
	}
	else
	{
		cout << abs(d);
	}


	return 0;
}