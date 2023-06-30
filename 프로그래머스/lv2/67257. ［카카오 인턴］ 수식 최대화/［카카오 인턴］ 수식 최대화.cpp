#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

long long int check(vector<string>str,vector<string>op){
    
    long long int answer=0;
    
    for(int i=0;i<op.size();i++){
        while(1){
            if(find(str.begin(),str.end(),op[i])==str.end())
                break;
            else{
                int j=find(str.begin(),str.end(),op[i])-str.begin();
                    if(op[i]=="*"){
                        answer=stoll(str[j-1])*stoll(str[j+1]);
                        str.erase(str.begin()+j-1,str.begin()+j+2);
                        str.insert(str.begin()+j-1,to_string(answer));
                    }
                    else if(op[i]=="+"){
                        answer=stoll(str[j-1])+stoll(str[j+1]);
                        str.erase(str.begin()+j-1,str.begin()+j+2);
                        str.insert(str.begin()+j-1,to_string(answer));
                    }
                    else{
                        answer=stoll(str[j-1])-stoll(str[j+1]);
                        str.erase(str.begin()+j-1,str.begin()+j+2);
                        str.insert(str.begin()+j-1,to_string(answer));
                    }
            }
        }
    }
    return stoll(str[0]);
}

long long solution(string expression) {
    long long answer = 0;
    long long Max=0;
    
    
    vector<int>v;
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);
    
    vector<string>str;
    
    string con="";
    for(int i=0;i<expression.size();i++){
        if(expression[i]>='0'&&expression[i]<='9')
            con+=expression[i];
        else{
            str.push_back(con);
            con="";
            string ss="";
            ss+=expression[i];
            str.push_back(ss);
        }
    }
    str.push_back(con);

	do {
        vector<string>op;
		for(int i=0;i<3;i++){
            if(v[i]==1)
                op.push_back("*");
            else if(v[i]==2)
                op.push_back("+");
            else 
                op.push_back("-");
        }
        
    answer=check(str,op);
    if(answer<0)
        answer=abs(answer);
        
    Max=max(Max,answer);
        
        
	} while (next_permutation(v.begin(), v.end()));
    
    
    return Max;
}