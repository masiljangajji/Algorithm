#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
#include <string>
#include<math.h>
using namespace std;


char ch[1004];

int main() {

	int n;
	

	while(1){

		string str;
		string str2 = "";
		string ans = "";
		
		cin >> n;

		if (n == 0)
			return 0;

		getchar();

		getline(cin, str);
		

		for (int j = 0; j < str.size(); j++) {
			if (str[j] >= 'a' && str[j] <= 'z') 
				str2 += str[j] - 32;
			else if (str[j] >= 'A' && str[j] <= 'Z')
				str2 += str[j];
		}

		ch[0] = str2[0];

		int here = 1;
		int num = str2.size() - 1;
		int idx = 0;
		int idx2 = 1;

		while (num) {

			if (idx + n < str2.size()) {
				idx += n;
				ch[idx] = str2[here];
				here++;
			}
			else {
				idx = idx2;
				ch[idx] = str2[here];
				here++;
				idx2++;
			}
			num--;
		}

		for (int j = 0; j < str2.size(); j++) {
			cout << ch[j];
		}
		cout << "\n";



		
		
	}

	return 0;
}


/*


abcdefghijklmnopqrstuvwxyz

복호화할때 

암호문에 첫글자 

그 뒤부터는 n만큼 뛰어진 다음 문자

이걸 암호화 하려면

평문에 첫 글자

그 뒤부터는 n만큼 앞으로 간 다음 문자 

*/