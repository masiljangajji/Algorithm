#include <string>
#include <vector>

using namespace std;

bool arr[100];

int solution(vector<int> numbers) {
    int answer = -1;
    
    int n=0;
    for(int i=0;i<numbers.size();i++){
        arr[numbers[i]]=true;
    }
    
    for(int i=1;i<=9;i++){
        if(!arr[i]){
            n+=i;
        }
    }
    
    return n;
}