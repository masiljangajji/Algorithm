#include <iostream> 
#include <string>

using namespace std; 

int main()
{
	

	string s;
	int arr[26] = {};
	int i, j, max = 0, target, cnt = 0;
	getline(cin, s);


	for (i = 0; i < s.length(); i++)
	{
		if (s[i] >= 'a' && s[i] <= 'z')
			s[i] = s[i] - 32; 
	}

	for (i = 0; i<s.length(); i++)
	{
		arr[s[i] - 'A']++;
	}

	for (i = 0; i < 26; i++)
	{
		if (max < arr[i])
		{
			max = arr[i];
			target = i;
			cnt = 0;
		}
		if (max == arr[i])
		{
			cnt++;
		}
	}

	if (cnt > 1)
		cout << "?";
	else
		cout << (char)(target + 'A');

	return 0;
}
