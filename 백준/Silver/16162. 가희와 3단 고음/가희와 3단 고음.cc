#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
#include <string>
#include<math.h>
using namespace std;

int main() {

	int n, a, d;

	cin >> n >> a >> d;

	int num;
	vector<int>v;

	for (int i = 0; i < n; i++) {
		cin >> num;
		v.push_back(num);
	}

	int cnt = 0;
	int temp = a;
	int Max = 0;



	for (int i = 0; i < v.size(); i++) {
		//cout << v[i] << " ";
		if (v[i] == temp) {
			temp += d;
			cnt++;
		}
	}
	
	cout << cnt;
	

	return 0;
}