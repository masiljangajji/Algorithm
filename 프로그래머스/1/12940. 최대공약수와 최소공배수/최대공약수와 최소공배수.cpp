#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    while (b != 0) {
        int r = a % b;  // 나머지를 구함
        a = b;
        b = r;
    }
    return a;
}


vector<int> solution(int n, int m) {
    vector<int> answer;
    
    
    answer.push_back(gcd(n,m));
    answer.push_back(n*m/(gcd(n,m)));
    
    return answer;
}