#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
#include <string>
#include<math.h>
using namespace std;

string make_binary(string str) {

	int n = stoi(str);

	string res = "";

	while (n) {
		if (n % 2 == 0) {
			n /= 2;
			res += "0";
		}
		else {
			n /= 2;
			res += "1";
		}
	}

	while (res.size() != 6) {
		res += "0";
	}

	reverse(res.begin(), res.end());
	
	return res;

}

int main() {

	int n;

	cin >> n;
	
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;

		vector<string>v;

		while (str.find(":") != string::npos) {
			int idx = str.find(":");
			string temp = str.substr(0, idx);
			v.push_back(temp);
			str.erase(0, idx + 1);
		}
		v.push_back(str);


		vector<string>res;
		for (auto a : v) {
			res.push_back(make_binary(a));
		}

		string answer1 = "";
		string answer2 = "";

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				answer1+=res[j][i];
			}
		}

		for (auto a : res)
			answer2 += a;

		cout << answer1 << " ";
		cout << answer2 << "\n";

	}
	

	return 0;
}


/*

001010    10
100101    37
110001	  49 

열방식 
011
001
100
010
100
011


*/