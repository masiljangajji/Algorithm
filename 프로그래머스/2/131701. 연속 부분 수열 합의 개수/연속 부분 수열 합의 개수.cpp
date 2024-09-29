#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> v) {
    
    int n=v.size();
    
    // sort(v.begin(),v.end());

    for(int i=0;i<n;i++){
        v.push_back(v[i]);
    }
    
    
    int cnt=1;
    
    map<long long,int>m;
    
    for(int k=1;k<=n;k++){ // 길이1부터 5까지 
        for(int i=0;i<v.size()-k;i++){ // 시작 index
            int sum=0;
            for(int p=i;p<i+k;p++){
                sum+=v[p];   
            }
            m[sum]=1;
            // cout<<sum<<" ";
            sum=0;
        }
        // cout<<"\n";
        
    }
    
    // 1 1 4 7 9
    // 1 1 4 7 9 1 1 4 7 9
    
    return m.size();
}