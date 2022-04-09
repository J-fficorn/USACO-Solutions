#include <stdio.h>
#include <iostream>
#include <fstream>
using namespace std;

ifstream fin("cowcode.in");
ofstream fout("cowcode.out");
char parse(string, long long);

int main() {
    string s; long long index;
    fin >> s >> index;
    fout << parse(s, index - 1) << endl;
    return 0;
}

char parse(string s, long long index) {
    if (index <= s.length()) return s[index];
    long long length = s.length();
    while (length * 2 <= index) length *= 2;
    if (length == index) return parse(s, index - 1);
    return parse(s, index - length - 1);
}
