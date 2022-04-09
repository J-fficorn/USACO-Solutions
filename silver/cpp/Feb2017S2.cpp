#include <iostream>
#include <fstream>
#include <algorithm>
using namespace std;

ifstream fin("maxcross.in");
ofstream fout("maxcross.out");

int n, k, b, x, minB = 1e6;

int main() {
    fin >> n >> k >> b;
    int signals[n] = {0}, pre[n + 1] = {0};
    for (int i = 0; i < b; i++) { fin >> x; signals[x - 1] = 1; } //input
    for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] + signals[i - 1]; //build prefix
    for (int i = k; i <= n; i++) minB = min(minB, (pre[i] - pre[i - k])); //calc min
    fout << minB;
    return 0;
}
