#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<queue>
#include<stack>

using namespace std;
vector<int>v;
int N, x;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		int a;
		cin >> a;
		v.push_back(a);
	}

	cin >> x;


	int i = 0;
	int j = N - 1;
	int cnt = 0;

	sort(v.begin(), v.end());

	while (i < j)
	{
		if (v[i] + v[j] == x)
		{
			j--;
			cnt++;
		}
		else if (v[i] + v[j] < x)
		{
			i++;
		}
		else if (v[i] + v[j] > x)
		{
			j--;
		}

	}

	cout << cnt << "\n";

	return 0;
}