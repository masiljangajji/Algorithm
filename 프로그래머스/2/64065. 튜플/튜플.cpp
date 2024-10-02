#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
using namespace std;

bool cmp(vector<string>a,vector<string>b){
    
    return a.size()<b.size();
    
}

vector<int> solution(string s) {
    vector<int> answer;
    
    string str = s.substr(1,s.size()-2);
    
    vector<vector<string>>v;
    string ss="";
    vector<string>cc;
    
    for(auto a:str){
        if(a=='{'){
            if(!cc.empty()){
                v.push_back(cc); // 집어넣기   
                cc.clear();
            }
        }else if(a>='0'&&a<='9'){
            ss+=a;
        }else if(a==','){
            if(ss!=""){
                cc.push_back(ss);
                ss="";
            }
            continue;
        }
    }
    
    if(ss!=""){
        cc.push_back(ss);
    }
    
    if(!cc.empty()){
        v.push_back(cc);
    }
    
    sort(v.begin(),v.end(),cmp);
    
    map<string,int>m;
    for(auto a:v){
        
        for(auto b:a){
            if(m.count(b)==0){
                m[b]=1;
                answer.push_back(stoi(b));
                break;
            }
        }
        
    }
    
    return answer;
}