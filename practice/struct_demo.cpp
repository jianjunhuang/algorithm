#include <iostream>
using namespace std;

struct Point {
  int x, y;
  //构造函数
  // Point a,b(1,2) 相当于调用了 Point() , Point(1,2)
  // x ， y 的默认值为 0
  // x(x) y(y) 把成员变量 x 初始化为参数 x ，成员变量 y 初始化为参数 y
  Point(int x = 0, int y = 0) : x(x), y(y) {}
};

//为结构体定义 加法
Point operator+(const Point &A, const Point &B) {
  return Point(A.x + B.x, A.y + B.y);
}

// 定义输出流方式 cout<<p
ostream &operator<<(ostream &out, const Point &p) {
  out << "(" << p.x << "," << p.y << ")";
  return out;
}

int main() {
  point a, b(1, 2);
  a.x = 3;
  cout << a + b << "\n";
  return 0;
}
