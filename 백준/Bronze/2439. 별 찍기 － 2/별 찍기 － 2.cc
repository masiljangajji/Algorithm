#include <iostream> 
#include <string>

using namespace std; 

int main()
{

	int N;

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		for (int j = i; j < N - 1; j++)
		{
			cout << " ";
		}
		
		for (int k = 0; k <= i; k++)
			cout << "*";

		cout << endl;
	}


	return 0;
}
