#include <iostream>
#include <string>
#include <map>
#include <stack>

using namespace std;

int solution(string s)
{
    
    stack<char>st;
    for(int i=0;i<s.size();i++){
        if(!st.size())
            st.push(s[i]);
        else{
            if(st.top()==s[i])
                st.pop();
            else
                st.push(s[i]);
        }
    }
    
    
    if(st.size())
        return 0;
    else
        return 1;

}