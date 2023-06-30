#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;

bool check[10000]; // in out 상태를 저장 
int time_arr[10000]; // 들어온 시간을 저장
int result[10000]; // 들어온 시간과 나간 시간의 총 합 저장 

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    vector<int>v;
    
    for(auto a:records){
        int n=0;
        string carNumber="";
        string time_="";
        for(int i=0;i<a.size();i++){
            if(a[i]==' '){
                n++;
            }
            else if(n==0){
                time_+=a[i];
            }
            else if(n==1){
                carNumber+=a[i];
            }
            else if(n==2)
                break;
        }
        
        int num=stoi(carNumber); // 차 번호를 정수형으로 저장하겠다 
        if(find(v.begin(),v.end(),num)==v.end()) // vector에 차 번호가 없으면 추가 
            v.push_back(num);
        
        string h=time_.substr(0,2); // 들어온 시
        string m=time_.substr(3,2); // 들어온 분 
        
        if(check[num]==false){     // out인 상태면 
            time_arr[num]=stoi(h)*60+stoi(m); // 들어온 시각 분단위로 저장
            check[num]=true; // in상태로 바꿈 
        }
        else { // in 상태면 
            check[num]=false; // out상태로 바꿈
            result[num]+=stoi(h)*60+stoi(m)-time_arr[num]; // 분단위로 in - out 시간 저장 
            time_arr[num]=0;
        }
    }
    
    sort(v.begin(),v.end()); // 차량 번호 오름차순으로 정렬
    
    int total_fee;
    
    for(int i=0;i<v.size();i++){
        if(check[v[i]]==true){ // 아직 in인 상태라면 23:59에 out처리 
            result[v[i]]+=23*60+59-time_arr[v[i]];
        }
        
        total_fee=fees[1]; // 기본요금 
        double total_time=result[v[i]]-fees[0]; 
        if(total_time>0){ // 기본시간보다 주차 시간이 길면 추가 요금 내야함 
         total_time/=(fees[2]);
         total_time=(ceil(total_time))*fees[3]; // 올림 처리후 단위 요금 추가
        total_fee+=total_time;   
        }
        answer.push_back(total_fee);
    }
    
    
    
    return answer;
}