#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    
    
    long long min=98765243219;
    int idx=0;
    for(int i=0;i<arr.size();i++){
        if(min>arr[i]){
            min=arr[i];
            idx=i;
        }
    }
    
    arr.erase(arr.begin()+idx);
    
    if(arr.empty()){
        arr.push_back(-1);
    }
    
    return arr;
}