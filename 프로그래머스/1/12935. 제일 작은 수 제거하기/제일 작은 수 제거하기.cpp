#include <string>
#include <vector>

using namespace std;


vector<int> solution(vector<int> arr) {
    vector<int> answer;
    

    
    long long min=9876543211;
    int idx=0;
    
    for(int i=0;i<arr.size();i++){
        if(min>arr[i]){
            min=arr[i];
            idx=i;
        }
    }
    
    arr.erase(arr.begin()+idx);
    
    
    if(arr.size()==0){
        arr.push_back(-1);
        return arr;
    }
    
    return arr;
}