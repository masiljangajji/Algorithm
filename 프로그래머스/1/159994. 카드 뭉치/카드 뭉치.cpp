#include <string>
#include <vector>
#include <map>
using namespace std;

map<string,int>m;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "";
    
    int i=0,j=0;
    
    for(auto a:goal){
        
        if(a==cards1[i]){
            i++;
        }else if(a==cards2[j]){
            j++;
        }else{
            return "No";
        }
        
    }
    
    
    
    return "Yes";
}