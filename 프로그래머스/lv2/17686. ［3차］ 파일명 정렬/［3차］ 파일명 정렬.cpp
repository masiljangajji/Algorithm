#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
#include<cctype>
using namespace std;

struct File{
  string head;
    string number;
    string tail;
    int idx;
}file[1001];

bool cmp(File &f1,File&f2){
    
    string str1,str2;
    str1=str2="";
    
    for(int i=0;i<f1.head.size();i++){
        if(isupper(f1.head[i])==0)
            str1+=toupper(f1.head[i]);
        else
            str1+=f1.head[i];
    }
    
    for(int i=0;i<f2.head.size();i++){
        if(isupper(f2.head[i])==0)
            str2+=toupper(f2.head[i]);
        else
            str2+=f2.head[i];
    } // 대소문자 구분 없게 전부 대문자로 
    
    if(str1==str2){ // head부분이 같다면 
        if(stoi(f1.number)==stoi(f2.number))// number부분이 같다면
            return f1.idx<f2.idx; // 입력한 순서대로
        else 
            return stoi(f1.number)<stoi(f2.number); // 숫자 오름차순 정렬 
    }
    else
        return str1<str2; // head순으로 정렬
    
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    
    
    for(int i=0;i<files.size();i++){
        
        string head,number,tail="";
        bool check=true;
        for(int j=0;j<files[i].length();j++){
            
            if(!(files[i][j]>='0'&&files[i][j]<='9')&&check){
                head+=files[i][j]; // head부분 
            }
            else if(files[i][j]>='0'&&files[i][j]<='9'){
                check=false;
                number+=files[i][j]; // nnumber부분 
            }
            else if(!(files[i][j]>='0'&&files[i][j]<='9')&&!check){
                tail=files[i].substr(j); // tail부분 
                break;
            }
        }
        // file 구조체에 저장 
        file[i].head=head;
        file[i].number=number;
        file[i].tail=tail;
        file[i].idx=i;
    }
    
    sort(file,file+files.size(),cmp);
    
    for(int i=0;i<files.size();i++){
        string ans=file[i].head+file[i].number+file[i].tail;
        answer.push_back(ans);
    }
    
    return answer;
}