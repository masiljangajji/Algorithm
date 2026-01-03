#include <iostream> 
#include<string>
#include<stdlib.h>
#include <algorithm>
using namespace std;

int main()
{

	string s;
	string str2[8];
	str2[0] = "c=";
	str2[1] = "c-";
	str2[2] = "dz=";
	str2[3] = "d-";
	str2[4] = "lj";
	str2[5] = "nj";
	str2[6] = "s=";
	str2[7] = "z=";

	cin >> s;
	int sum = 0;
	int a;
	for (int i = 0; i < 8; i++)
	{
		while (1)
		{
			a=s.find(str2[i]);
			if (a == -1)
			{
				break;
			}
			s.replace(a, str2[i].length(), "#");
		}
	}

	cout << s.size();	
	


	return 0;
}














