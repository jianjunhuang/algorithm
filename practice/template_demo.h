#include <iostream>
using namespace std;
template <typename T> T sum(T *begin, T *end) {
  T *p = begin;
  T ans = 0;
  for (T *p = begin; p != end; p++) {
    /*
    不用 ans += *p 是因为 Point 接结构体中只定义了 “+” 运算符，没有定义 “+=”
    */
    ans = ans + *p;
  }
  return ans;
}

template <typename T> struct Point {
  T x, y;
  Point(T x = 0, T y = 0) : x(x), y(y) {}
};

template <typename T> Point<T> operator+(const Point<T> &A, const Point<T> &B) {
  return Point<T>(A.x + B.x, A.y + B.y);
}

template <typename T> ostream &operator<<(ostream &out, const Point<T> &p) {
  out << "(" << p.x << "," << p.y << ")";
  return out;
}
