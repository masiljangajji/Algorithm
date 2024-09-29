#include <string>
#include <vector>

using namespace std;

int arr[1004];

vector<int> solution(string s) {
    
    fill(arr,arr+1000,-1);
    
    vector<int> answer;
    
    for(int i=0;i<s.size();i++){
        
        int num=s[i];
        
        if(arr[num]==-1){
            arr[num]=i;
            answer.push_back(-1);
        }else{
            answer.push_back(i-arr[num]);
            arr[num]=i;
        }
    }
    
    return answer;
}