#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
#include <string>
#include<math.h>

using namespace std;

int visit[10000004];
vector<int>v;
map<int, int>m;
typedef long long ll;

int solution(string numbers) {
    
   for (int i = 0; i < numbers.size(); i++) {
		v.push_back(i);
	}

	visit[0] = 1;
	visit[1] = 1;

	for (ll i = 2; i <= sqrt(10000000); i++) {

		for (ll j = i*i; j <= 10000000; j += i) {
			visit[j] = 1;
		}
	}

	int cnt = 1;

	while (cnt <= v.size()) {
		do {

			string str = "";
			for (int i = 0; i < cnt; i++) {
				str += numbers[v[i]];
			}

			if (visit[stoi(str)] == 0 && m[stoi(str)] == 0) {
				m[stoi(str)] = 1;
			}

			reverse(v.begin() + cnt, v.end());
		} while (next_permutation(v.begin(), v.end()));
		cnt++;
	}
    
    return m.size();
}