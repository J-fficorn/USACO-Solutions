#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;
typedef pair<int, int> pII;

ifstream fin("helpcross.in");
ofstream fout("helpcross.out");

int c, n, x, y;
multiset<int> chickens;
vector<pII> cows;

int main() {
    fin >> c >> n;
    for (int i = 0; i < c; i++) { fin >> x; chickens.insert(x); }
    for (int i = 0; i < n; i++) { fin >> x >> y; cows.push_back(pII(y, x)); } //1st element = ending time
    sort(cows.begin(), cows.end());
    int ans = 0;
    for (int i = 0; i < n; i++) {
        multiset<int>::iterator chick = chickens.lower_bound(cows[i].second); //first chicken within the bound
        if (chick != chickens.end() && *chick <= cows[i].first) {
            ans++;
            chickens.erase(chick);
        }
    }
    fout << ans << endl;
    return 0;
}
