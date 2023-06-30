#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int solution(vector<int> A, vector<int> B)
{
    // combi 완탐이 아니라 그냥 가장 작은거 * 가장 큰거 하면 되네
    
    sort(A.begin(),A.end());
    sort(B.begin(),B.end());
    reverse(B.begin(),B.end());
    
    int sum=0;
    
    for(int i=0;i<A.size();i++){
        sum+=A[i]*B[i];    
    }
    
    return sum;
}