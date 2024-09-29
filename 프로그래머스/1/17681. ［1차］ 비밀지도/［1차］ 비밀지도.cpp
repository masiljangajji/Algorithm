#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    
    for(int i=0;i<arr1.size();i++){
        
        string str="";
        string str2="";
        
        int a=arr1[i];
        int b=arr2[i];
        while(a){
            str+=to_string(a%2);
            a/=2;
        }
        
        while(b){
            str2+=to_string(b%2);
            b/=2;
        }
        
        
        
        reverse(str.begin(),str.end());
        reverse(str2.begin(),str2.end());
        
        while(str.size()<n){
            str.insert(str.begin(),'0');
        }
        while(str2.size()<n){
            str2.insert(str2.begin(),'0');
        }
        
        cout<<str<<" "<<str2<<"\n";
        
        string ans = "";
        
        for(int j=0;j<n;j++){
            if(str[j]=='1'||str2[j]=='1'){
                ans+="#"; 
            }else{
                ans+=" ";
            }
        }
        answer.push_back(ans);
    }
    
    
    
    return answer;
}