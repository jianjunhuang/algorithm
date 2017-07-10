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
