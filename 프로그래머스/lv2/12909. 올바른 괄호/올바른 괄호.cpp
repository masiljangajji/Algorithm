#include <string>
#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

bool solution(string s)
{
    
    stack<char>st;
    
    for(int i=0;i<s.size();i++){
        
        if(!st.size()) // 암것도 없으면 무조건 push 
            st.push(s[i]);
        else{
            // 존재하면 check logic 
            
            if(st.top()=='('&&s[i]==')')
                st.pop();
            else 
                st.push(s[i]);
            
        }        
    }

    if(st.size())
        return false;
    else
        return true;
    
}