#include <iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<cstring>
#include<map>
using namespace std;

int N, M;
map<char, int>m;
map<char, int>m2;

int gcd(int a, int b) {

	if (b == 0) {
		return a;
	}
	else {
		gcd(b, a % b);
	}

}

int main() {

	cin.tie(NULL), cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	M = 0;
	cin >> N;

	string str1;
	string str2;

	for (int i = 0; i < N; i++) {
		M++;
		cin >> str1 >> str2;
		
		int num=str1.size() > str2.size() ? gcd(str2.size(), str1.size()) : gcd(str1.size(), str2.size());
	
		int check = str1.size() * str2.size();
		check /= num;

		//cout << num << "\n";
		//cout << check << "\n";

		string r1 = "";
		string r2 = "";

		while (1) {
			r1 += str1;
			if (r1.size() == check)
				break;
		}
		
		while (1) {
			r2 += str2;
			if (r2.size() == check)
				break;
		}

		if (r1 == r2) 
			cout << "#" << M << " yes\n";
		else
			cout << "#" << M << " no\n";
			
	}

	return 0;
}