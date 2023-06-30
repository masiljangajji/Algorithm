#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int>sale;
int plus_Max;
int price_Max;
int Size;

void combi(int index,int depth,vector<int>v,vector<int>sale,vector<int> emoticons,vector<vector<int>> users){
    
    if(depth==v.size()){
       // 이모티콘 할인율 정해짐
        int emoticon_plus=0;
        int total_price=0;
        
        // 모든 유저에 대해서 
        for(int i=0;i<users.size();i++){
            int buy_sale=users[i][0];
            int buy_plus=users[i][1];
            double emoticon_price=0;
            
            // 할인율이 일정 이상이면 사겠다 
            for(int j=0;j<emoticons.size();j++){
                if(buy_sale<=v[j]){
                    emoticon_price+=(double)emoticons[j]*((double)(100-v[j])/100);
                }
            }
            
            // 일정 가격 이상이면 이모티콘 플러스 가입 
            if(emoticon_price>=buy_plus)
                emoticon_plus++;
            else {
                total_price+=emoticon_price;
            }
        }
        
        // 이모티콘 플러스 가입자를 최대한 늘리는 것 , 판매액 늘리는 것 
        if(plus_Max<emoticon_plus){
            plus_Max=emoticon_plus;
            price_Max=total_price;
        }
        else if(plus_Max==emoticon_plus&&price_Max<total_price){
            price_Max=total_price;
            }
        
        return;
    }
    
    // 중복순열 알고리즘 
    for(int i=0;i<sale.size();i++){
        v[depth]=sale[i];
        combi(index,depth+1,v,sale,emoticons,users);
    }
    
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    
    Size=emoticons.size();
    
    // 할인율 추가 
    sale.push_back(10);
    sale.push_back(20);
    sale.push_back(30);
    sale.push_back(40);
    
    vector<int> v(Size);
    
    // 할인율에 대한 중복순열
    combi(0,0,v,sale,emoticons,users);
    
    answer.push_back(plus_Max);
    answer.push_back(price_Max);
    
    return answer;
}