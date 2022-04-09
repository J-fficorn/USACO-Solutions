#include <stdio.h>
#include <iostream>
#include <fstream>
#include <queue>
using namespace std;

ifstream fin("cowdance.in");
ofstream fout("cowdance.out");
bool valid(int, int, int[]);
int n, t;

int main() {
    fin >> n >> t;
    int min = 1, max = n;
    int cows[n];
    for (int i = 0; i < n; i++) fin >> cows[i];
    while (min != max) {
        int mid = min + max / 2;
        if (valid(mid, t, cows)) max = mid;
        else min = mid + 1;
    }
    fout << min;
    return 0;
}

bool valid(int k, int t, int cows[]) {
    int last = 0;
    priority_queue<int> q;
    for (int i = 0; i < n; i++) {
        if (q.size() == k) { last = q.top(); q.pop(); }
        if (last + cows[i] > t) return false;
        q.push(last + cows[i]);
    }
    return true;
}
