#include <string>
#include <vector>
#include<iostream>
#include<map>
#include<algorithm>
using namespace std;

map<string,int>m;

bool cmp(pair<int,string> a,pair<int,string> b){
    return a.first>b.first; // 많이 주문된 순서
}

void count(vector<char>v){
    
    sort(v.begin(),v.end()); // 메뉴 구성을 알파벳 순서로 정렬 
    string str="";
    for(auto a:v){
        str+=a;
    }
    m[str]++; // map에 해당하는 메뉴가 몇번 나왔는지 저장 
    return;
}

void combi(int start,vector<char>v,int size,string str){
    if(v.size()==size){ // 내가 원하는 코스 종류와 같아지면 
        count(v);
        return;
    }
    
    for(int i=start+1;i<str.size();i++){ // 조합을 통해서 n개의 모든 메뉴 조합 보겠다 
        v.push_back(str[i]); 
        combi(i,v,size,str);
        v.pop_back();
    }
    return;
    
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    
    for(int k=0;k<course.size();k++){ // 원하는 코스 요리 개수 정하고 
        m.clear();
        for(int i=0;i<orders.size();i++){ // 모든 사람의 메뉴 구성을 본다 
            vector<char>v;
            combi(-1,v,course[k],orders[i]);
        }
        
        vector<pair<int,string>>menu;
        
        for(auto a:m){
            if(a.second>1) // 2명 이상에게 주문되야 
                menu.push_back({a.second,a.first});
        }
        
        sort(menu.begin(),menu.end(),cmp); // 가장 많이 주문된 순으로 정렬 
        
        int max=menu[0].first;
        for(int i=0;i<menu.size();i++){ 
            if(max==menu[i].first)  // 동일한 최고 횟수로 주문된 메뉴는 전부 넣어준다 
                answer.push_back(menu[i].second);
            else
                break;
        }
    }
    
    
    sort(answer.begin(),answer.end()); // 최종적으로 오름차순 정렬
    
    
    return answer;
}