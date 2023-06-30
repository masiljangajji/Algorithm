#include<iostream>
#include<algorithm>
#include<utility>
#include<vector>
#include<string>
#include<map>
using namespace std;


vector<int> solution(string s) {
    map<string,int>m;
    vector<int>answer;
    vector<pair<int,int>>v;
    
    string str="";
    
    for(int i=1;i<s.size()-1;i++){
        
        if(s[i]>='0'&&s[i]<='9'){
            str+=s[i];
        }
       else{
           if(str!=""){
             m[str]++;
            str="";
             }
       }
        
    }

    for(auto a:m){
        v.push_back({a.second,stoi(a.first)});
    }
    
    
	sort(v.begin(), v.end(), greater<pair<int, int>>());

    for(auto a:v){
        answer.push_back(a.second);
    }
    
    
    return answer;
}