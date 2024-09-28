#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;

    // p,y 개수 같으면 true 아니면 false    py하나도 없으면 항상 true 
    
    int p_cnt=0;
    int y_cnt=0;
    
    for(int i=0;i<s.size();i++){
        if(s[i]=='p'||s[i]=='P')
            p_cnt++;
        if(s[i]=='y'||s[i]=='Y')
            y_cnt++;
    }
    
    if(p_cnt==0&&y_cnt==0)
        return true;
    else if(p_cnt==y_cnt)
        return true;
    else
        return false;
    
}