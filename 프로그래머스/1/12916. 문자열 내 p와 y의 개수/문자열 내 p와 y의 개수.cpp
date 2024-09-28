#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;

    int cnt1=0;
    int cnt2=0;
    
    for(auto a:s){
        if(a=='p'||a=='P'){
            cnt1++;
        }
        else if(a=='y'||a=='Y'){
            cnt2++;
        }
    }

    return cnt1==cnt2;
}