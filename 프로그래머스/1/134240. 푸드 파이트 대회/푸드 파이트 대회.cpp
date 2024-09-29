#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    
    // 칼로리 오름차순
    // 중앙먼저 가는 사람이 이김
    // 짝수개 아니면 버려짐 최소 2이상이여야 쓸 수 있음 
    
    string str="";
    
    int cnt=1;
    for(int i=1;i<food.size();i++){
        
        if(food[i]<2){
            continue;
        }
        
        int num= food[i]/2;
        
        for(int j=0;j<num;j++){
            str+=to_string(i);
        }
    
    }
    
    answer+=str;
    answer+="0";
    reverse(str.begin(),str.end());
    answer+=str;
    
    
    return answer;
}