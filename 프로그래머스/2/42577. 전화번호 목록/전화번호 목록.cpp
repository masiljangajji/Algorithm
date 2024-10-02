#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
vector<string>ans;
bool solution(vector<string> v) {
    bool answer = true;
    
    sort(v.begin(),v.end());
    
    if(v.size()==1){
        return true;
    }
    
    for(int i=0;i<v.size()-1;i++){
        
        if (v[i+1].compare(0, v[i].size(), v[i]) == 0) {
            return false;  
        }
    }
    return true;
    
}