#include <string>
#include <vector>

using namespace std;

string solution(vector<string> s) {
    string answer = "";
    
    for(int i=0;i<s.size();i++){
        if(s[i]=="Kim"){
            return "김서방은 "+to_string(i)+"에 있다";
        }
    }
    
    return answer;
}