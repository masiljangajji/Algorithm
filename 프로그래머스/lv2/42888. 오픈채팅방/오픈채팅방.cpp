#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
#include<map>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    vector<vector<string>>v;
    
    string delimiter=" ";
    
    map<string,string>m;
    
    for(auto info:record){
        long long pos;
        string token="";
        vector<string>ret;
        while((pos=info.find(delimiter))!=string::npos){
            token=info.substr(0,pos);
            ret.push_back(token);
            info.erase(0,pos+delimiter.length());
        }
        if(info.length())
            ret.push_back(info);
        
        v.push_back(ret);
        
        if(ret[0]=="Enter"||ret[0]=="Change"){
            m[ret[1]]=ret[2];
        }     
    }
    
    
    for(int i=0;i<v.size();i++){
        string ans="""";
        
        if(v[i][0]=="Enter"){
            ans+=m[v[i][1]]+"님이 들어왔습니다.";
            answer.push_back(ans);
        }   
        else if(v[i][0]=="Leave"){
            ans+=m[v[i][1]]+"님이 나갔습니다.";
            answer.push_back(ans);
        }
    }
    
    return answer;
}