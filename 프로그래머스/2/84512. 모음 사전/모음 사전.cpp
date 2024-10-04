#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

vector<char>v;
int arr[10]={781,156,31,6,1};


int solution(string word) {
    int answer = 0;
    
    // A하나만 AE , AEI , AEIO , AEIOU를 가지고 
    // A , AA , AAA ,AAAA ,AAAAA 5개
    // AAAAE , AAAAI , AAAAO , AAAAU , AAAAE 5개 
    // AAAEA , AAAEA , AAAOA , AAAUA , AAAEA 5개
    
    v.push_back('A');
    v.push_back('E');
    v.push_back('I');
    v.push_back('O');
    v.push_back('U');
    
    for(int i=0;i<word.size();i++){
        int idx = find(v.begin(),v.end(),word[i])-v.begin();
        answer+=arr[i]*(idx)+1;
    }
    
    
    return answer;
}