#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
#include<deque>

using namespace std;

deque<string>cache;

string convert(string str){
    for(int i=0;i<str.length();i++){
        if(str[i]>='A'&&str[i]<='Z')
            str[i]+=32;
    }
    return str;
}

int LRU(string str, int cacheSize) {
    for (int i = 0; i < cache.size(); i++) {
        if (cache[i] == str) {// catch 에 있다
            cache.erase(cache.begin() + i, cache.begin() + i + 1); // 해당 위치 지우고
            cache.push_front(str); // 앞으로 넣어준다 
            return 1;
        }
    }

    if (cache.size() < cacheSize) { // cache size 남아있으면 앞에서 부터 넣기 
        cache.push_front(str);
    }
    else {// cache size 꽉 찼으면 젤 오래 된거 삭제 , 새로운 거 추가
        cache.pop_back();
        cache.push_front(str);
    }
    return 5;

}

int solution(int cacheSize, vector<string> cities) {

    int answer = 0;

    for (int i = 0; i < cities.size(); i++) {
        if(cacheSize>=1){
            answer += LRU(convert(cities[i]), cacheSize); // 대소문자 구분없음
        }
        else
            answer+=5;
    }

    return answer;
}