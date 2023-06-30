#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int cnt;
int ans;

int solution(string s) {
    int answer = 0;
    
    ans=s.size(); // 가장 긴 문자열의 길이 
    
    string tmp="";
    
    for(int i=1;i<s.size();i++){
        string str=s;
        string answer="";
        cnt=1;
        vector<string>v;
        while(str.size()){ // 특정 단위로 자른다 
            v.push_back(str.substr(0,i));
            str.erase(0,i); 
        }
        
        if(v[0].size()!=v[1].size()){ // 첫 두개의 size가 다르면 압축 불가능 
            answer=s;
            break;
        }
        else{
        string tmp=v[0]; // 압축이 가능한지 확인하는 로직 
        for(int j=1;j<v.size();j++){
            if(tmp==v[j]){
                cnt++;
            }
            else{
                if(cnt>1)
                    answer+=to_string(cnt)+tmp; 
                else
                    answer+=tmp; 
                cnt=1;
            }
            tmp=v[j];
        }
        if(cnt>1)
            answer+=to_string(cnt)+tmp; 
        else
            answer+=tmp; 
        }
    
        if(ans>answer.size()) // 가장 작은 길이의 문자열
            ans=answer.size(); 
    }
    return ans;
}