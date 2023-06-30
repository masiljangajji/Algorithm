#include <string>
#include <vector>
#include <iostream>

using namespace std;



vector<int> solution(int brown, int yellow) {
    vector<int> answer;

    int row=1;
    int col;
    int cnt=0;
    
    while(1){
        if(yellow%row==0){
            col=yellow/row;
            if(row*2+col*2+4==brown){
                answer.push_back(col+2);
                answer.push_back(row+2);
                return answer;
            } 
        }
        row++;
    }
    
}