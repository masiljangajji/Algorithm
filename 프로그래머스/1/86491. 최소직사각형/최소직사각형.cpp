#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool cmp(int a,int b){
    return a>b;
}

int solution(vector<vector<int>> sizes) {
   
   vector<int>v;
   vector<int>v2;
   
   for(int i=0;i<sizes.size();i++){
      if(sizes[i][0]>sizes[i][1]){
        v.push_back(sizes[i][0]);
        v2.push_back(sizes[i][1]);
      }
      else{
        v.push_back(sizes[i][1]);
        v2.push_back(sizes[i][0]);
      }
   }
    
    sort(v.begin(),v.end(),cmp);
    sort(v2.begin(),v2.end(),cmp);

    return v[0]*v2[0];
}