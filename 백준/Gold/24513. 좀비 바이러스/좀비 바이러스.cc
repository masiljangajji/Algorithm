#include<iostream>
#include<algorithm>
#include<map>
#include<queue>
#include <string>
#include<math.h>
using namespace std;

int N, M;
int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };
int cnt1, cnt2, cnt3;

int arr[1004][1004];
int visit[1004][1004];

queue<pair<int,int>>q;

void bfs() {

	while (!q.empty()) {

		int y = q.front().first;
		int x = q.front().second;

		q.pop();

		if (arr[y][x] == 1) {

			for (int i = 0; i < 4; i++) {

				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;

				if (arr[ny][nx] == -1)
					continue;

				if (arr[ny][nx] == 0) {
					arr[ny][nx] = 1;
					cnt1++;
					visit[ny][nx] = visit[y][x] + 1;
					q.push({ ny,nx});
				}
				else if (arr[ny][nx] == 2 && visit[ny][nx] == visit[y][x] + 1) {
					cnt3++;
					cnt2--;
					arr[ny][nx] = 3;
				}
			}
		}
		else if (arr[y][x] == 2) {
			for (int i = 0; i < 4; i++) {

				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;

				if (arr[ny][nx] == -1)
					continue;

				if (arr[ny][nx] == 0) {
					arr[ny][nx] = 2;
					cnt2++;
					visit[ny][nx] = visit[y][x] + 1;
					q.push({ ny,nx});
				}
				else if (arr[ny][nx] == 1 && visit[ny][nx] == visit[y][x] + 1) {
					cnt3++;
					cnt1--;
					arr[ny][nx] = 3;
				}
			}
		}
		

	}

}

int main() {

	cin >> N >> M;


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];

			if (arr[i][j] == 1) {
				q.push({ i,j});
				cnt1++;
				visit[i][j] = 1;
			}
			else if (arr[i][j] == 2) {
				q.push({ i,j});
				cnt2++;
				visit[i][j] = 1;
			}

		}
	}

	bfs();

	cout << cnt1 << " " << cnt2 << " " << cnt3 << "\n";

	return 0;
}