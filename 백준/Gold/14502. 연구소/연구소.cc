#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
#include<map>
#include<stack>
#include<queue>
#include<cmath>
using namespace std;
int dy[] = { 0,0,-1,1 };
int dx[] = { -1,1,0,0 };
int ny, nx, N, M;
int arr[10][10], visit[10][10];
vector<pair<int, int>>v;
vector<pair<int, int>>virus;

void prt()
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
	cout << "-------------\n\n";
}

void dfs(int y, int x)
{
	visit[y][x] = 1;

	for (int i = 0; i < 4; i++)
	{
		ny = y + dy[i];
		nx = x + dx[i];

		if (ny < 0 || nx < 0 || ny >= N || nx >= M)
			continue;
		if (visit[ny][nx] || arr[ny][nx] == 1)
			continue;
		dfs(ny, nx);
	}

}

int check()
{
	int cnt = 0;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (arr[i][j] != 1 && !visit[i][j])
				cnt++;
		}
	}
	return cnt;
}

void go()
{	
	for (auto a : virus)
	{
		if (visit[a.first][a.second])
			continue;
		dfs(a.first, a.second);
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> arr[i][j];
			if (arr[i][j] == 0)
				v.push_back({ i,j });//벽을 세울수있는 곳의 좌표 
			if (arr[i][j] == 2)
				virus.push_back({ i,j });//바이러스 좌표
		}
	}

	int Max = -1;
	//v안에서 랜덤하게 3개 뽑아서 벽세워야함 

	for (int i = 0; i < v.size()-2; i++)
	{
		for (int j = i + 1; j < v.size()-1; j++)
		{
			for (int k = j + 1; k < v.size(); k++)
			{
				fill(&visit[0][0], &visit[9][9], 0);
				arr[v[i].first][v[i].second] = arr[v[j].first][v[j].second] = arr[v[k].first][v[k].second] = 1;
				go();
				int t = check();
				Max = max(t, Max);
				arr[v[i].first][v[i].second] = arr[v[j].first][v[j].second] = arr[v[k].first][v[k].second] = 0;
			}
		}
	}
	cout << Max;


	
	//벽 랜덤하게 3군데 세우고 dfs 돌리기
		//안전영역의 넓이 체크 

	return 0;
}