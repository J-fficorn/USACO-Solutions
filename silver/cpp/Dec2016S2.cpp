#include <stdio.h>
#include <iostream>
#include <math.h>
#include <fstream>
#include <map>
#include <iterator>
using namespace std;

ifstream fin("citystate.in");
ofstream fout("citystate.out");

int main()
{
    map<string, long> id;
    int n;
    fin >> n;
    for (int i = 0; i < n; i++) {
        string s1, s2, s;
        fin >> s1 >> s2;
        s1 = s1.substr(0, 2); s = s1 + s2;
        if (s1 != s2) {
            if (!id.count(s)) id.insert(pair<string, long>(s, 0L));
            id[s]++;
        }
    }
    long ans = 0;
    map<string, long>::iterator itr;
    for (itr = id.begin(); itr != id.end(); itr++) {
        string s = itr->first, rev = s.substr(2) + s.substr(0, 2);
        //fout << itr->first << " " << id.at(itr->first) << rev << endl;
        if (id.count(rev)) ans += id.at(s) * id.at(rev);
    }
    fout << ans / 2;
    return 0;
}
