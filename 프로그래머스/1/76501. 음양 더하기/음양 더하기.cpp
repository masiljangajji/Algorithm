#include <string>
#include <vector>

using namespace std;

int solution(vector<int> abs, vector<bool> sign) {
    int ans = 0;
    
    for(int i=0;i<abs.size();i++){
        if(sign[i]){
           ans+=abs[i]; 
        }else{
            ans-=abs[i];
        }
    }
    
    return ans;
}