#include<iostream>
#include<string>
#include<algorithm>
#include<vector>
#include<stack>

using namespace std;

string str;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int N;
	cin >> N;
	
	for (int i = 0; i < N; i++)
	{
		stack<char>s;
		cin >> str;
		for (int j = 0; j < str.size(); j++)
		{
			if (s.empty())
			{
				if (str[j] == '(')
					s.push(str[j]);
				else
				{
					s.push('1');
					break;
				}
			}
			else
			{
				if (str[j] == '(')
					s.push(str[j]);
				else
				{	
					s.pop();
				}
			}
		}
		if (s.empty())
			cout << "YES\n";
		else
			cout << "NO\n";

	}
	

	return 0;
}