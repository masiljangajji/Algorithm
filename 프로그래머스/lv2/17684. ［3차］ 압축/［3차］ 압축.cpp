#include <string>
#include <vector>
#include<iostream>
#include<algorithm>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    vector<string>v;
    
    for(char i='A';i<='Z';i++){ // 사전 초기화 
        string ss="";
        ss+=i;
        v.push_back(ss);
    }
    
    string str="";
    string str2="";
    int i=0;
    
    while(1){
        str+=msg[i]; // 입력을 저장하는 str문자열 
        if(find(v.begin(),v.end(),str)!=v.end()){ // 입력이 사전에 존재하면 
            str2+=msg[i]; // 사전에 존재하는 부분까지 str2에 저장 
            i++;
        }
        else {
            answer.push_back(find(v.begin(),v.end(),str2)-v.begin()+1);// 색인번호는 사전에서의 위치 
            msg.erase(0,str2.size()); // 사전에 존재하는 입력 제거 
            if(msg.size()){ // 입력할 글자 남아있으면 
                v.push_back(str); // w+c 에 해당하는 단어 사전 등록
            }
            else
                break;
            
            str=str2="";
            i=0;
        }
    }
    
    
    return answer;
}