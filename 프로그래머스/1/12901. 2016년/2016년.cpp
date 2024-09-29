#include <string>
#include <vector>
#include <iostream>

using namespace std;

string arr[10];
int months[13]={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string solution(int a, int b) {
    string answer = "";
    
    arr[0]="THU";
    arr[1]="FRI";
    arr[2]="SAT";
    arr[3]="SUN";
    arr[4]="MON";
    arr[5]="TUE";
    arr[6]="WED";
    
    int num=0;
    for(int i=0;i<a-1;i++){
        num+=months[i];
    }
    
    num+=b;
    cout<<num;
    
    return arr[num%7];
}