#include <string>
#include <vector>

using namespace std;

string solution(string p) {
    string ans="";
    
    int idx= p.size()-4;
    
    for(int i=0;i<idx;i++){
        ans+="*";
    }
    
    ans+=p.substr(idx);
    
    
    
    return ans;
}