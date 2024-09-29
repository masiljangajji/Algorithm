#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string convert(int cnt){
    
    string str="";
    while(cnt){ // 4
        str+=to_string(cnt%2);
        cnt/=2;
    }
    reverse(str.begin(),str.end());
    return str;
}

vector<int> solution(string s) {
    vector<int> answer;
    
    vector<int>v;
    
    
    
    int ans=0;
    int ans2=0;
    
    while(s!="1"){
    
        int cnt=0;
        
        for(int i=0;i<s.size();i++){
            if(s[i]=='0'){
                ans2++;
                continue;
            }
            cnt++;
        }
        s=convert(cnt);
        cout<<s<<" ";
        ans++;
    }
    
    
    
    
    
    
    v.push_back(ans);
    v.push_back(ans2);
    return v;
}