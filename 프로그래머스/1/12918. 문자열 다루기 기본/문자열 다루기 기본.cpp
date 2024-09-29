#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    
    if(s.size()==4||s.size()==6){
        for(auto a:s){
            if(!(a>='0'&&a<='9')){
                return false;
            }
        }
        return true;
    }
    
    return false;
}