#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int lion[11];
int apeach[11];
int Max;
int ans[11];
bool flag = true;

void Combination(vector<int> arr, vector<int> comb, int index, int depth)
{
    if (depth == comb.size()) // 내가 뽑는것의 개수 
    {


        int cnt = 0;
        int cnt2 = 0;

        fill(lion, lion + 11, 0);
        for (int i = 0; i < comb.size(); i++) { // // 라이언이 쏜 특정 점수의 화살 개수 
            lion[comb[i]] ++;
        }


        for (int i = 0; i <= 10; i++) {
            if (apeach[i] < lion[i]) {// 라이언과 어치피가 맞춘 특정 점수의 화살 개수 비교 
                cnt2 += i;
            }
            else if (apeach[i] == 0 && lion[i] == 0) // 둘다 맞추지 못했다면 둘다 0점
                continue;
            else
                cnt += i;
        }


        if (cnt2 > cnt) {
            flag = false;
            if (Max < cnt2 - cnt) {
                Max = cnt2 - cnt; // 최대로 차이나는 점수가 차이날떄 ans에 저장
                memcpy(ans, lion, sizeof(lion)); // 
            }
            else if (Max == cnt2 - cnt) { // 여러가지인 경우 작은 걸 선택 

                for (int i = 0; i <= 10; i++) {//낮은 점수가 더 많은걸 return 할거임
                    if (ans[i] < lion[i]) { // lion 배열로 바꿔줘야함 
                        memcpy(ans, lion, sizeof(lion));
                        return;

                    }
                    else if (ans[i] > lion[i]) { // 기존게 더 작아 더 할필요x
                        return;
                    }
                }
            }

        }


        return;
    }

    for (int i = index; i < arr.size(); i++)
    {
        comb[depth] = arr[i];
        Combination(arr, comb, i, depth + 1);  
    }

}

vector<int> solution(int n, vector<int> info) {
    vector<int> answer;

    for (int i = 0; i < info.size(); i++) {
        apeach[10 - i] += info[i];
    }


    vector<int>v;
    for (int i = 0; i <= 10; i++)
        v.push_back(i); // 총 0~10점까지 

    vector<int> comb(n);

    Combination(v, comb, 0, 0);

    if (flag == true) {
        answer.push_back(-1);
        return answer;
    }

    for (int i = 10; i >= 0; i--)
        answer.push_back(ans[i]);



    return answer;
}