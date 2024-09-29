#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    int n=s.size();
    s+=s;
    
    for(int i=0;i<n;i++){
        string str="";
        for(int j=i;j<i+n;j++){
            str+=s[j];
        }

        
        stack<char>st;
        for(auto a:str){
            
            if(st.empty()){
                st.push(a);
                continue;
            }
            
            char ch=st.top();
            
            if(ch=='{'&&a=='}'){
                st.pop();
            }else if(ch=='['&&a==']'){
                st.pop();
            }else if(ch=='('&&a==')'){
                st.pop();
            }
            else{
                st.push(a);
            }
        }
        
        if(st.empty()){
            answer++;
        }
        
    }
    
    return answer;
}