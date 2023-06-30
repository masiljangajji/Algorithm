#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
#include<stack>

using namespace std;

string solution(string p) {
    
    if(p.size()==0)
        return p;
    
    string u="";
    string v="";
    
    stack<char>st;
    
    int cnt1,cnt2;
    cnt1=cnt2=0;
    
    for(int i=0;i<p.size();i++){
        if(st.empty())
            st.push(p[i]);
        else if(st.top()=='('&&p[i]==')')
            st.pop();
        else 
            st.push(p[i]);
        if(p[i]=='(')
            cnt1++;
        else 
            cnt2++;
        
        if(cnt1==cnt2){
            u=p.substr(0,i+1);
            v=p.substr(u.size());
            break;
        }
    }
    
    if(st.empty()){
        u+=solution(v);
        return u;
    }
    else{
        string res="(";
        res+=solution(v);
        res+=')';
        
        for(int i=1;i<u.size()-1;i++){
            if(u[i]=='(')
                res+=')';
             else
                 res+='(';
        }
        return res;
    }

}