#include <string>
#include <vector>
#include<iostream>
#include<algorithm>

using namespace std;

bool check(long long int n) {
    if(n <= 1) 
        return 0;
    if(n == 2) 
        return 1;
    if(n % 2 == 0) 
        return 0;
    
    for (long long int i = 2; i * i <= n; i++) {
    if (n % i == 0) 
        return 0;
    }
    
    return 1;
}


int solution(int n, int k) {
    
    vector<int>v;
	while (n > 1) {
		v.push_back(n % k);
		n /= k;
	}
    
	if (n == 1)
		v.push_back(1);
	reverse(v.begin(), v.end());
    
    long long int num=0;
    int cnt=0;
    
    for(int i=0;i<v.size();i++){

        if(v[i]==0){
            if(num!=0&&check(num)){ // 0이 나왔고 num이 0이 아니라면 and 소수라면   
                    cnt++;
            }    
        num=0;
        }
        else{ 
            num*=10;
            num+=v[i];   
        }
    }
    
     if(num!=0&&check(num)){ 
         cnt++;
    }
    
    
    return cnt;
}

