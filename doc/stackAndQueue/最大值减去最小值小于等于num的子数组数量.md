##最大值减去最小值小于等于num的子数组数量

#### 题目

给定数组arr和整数num，工返回有多少个子数组曼度如下情况：

- max(arr[i..j])-min(arr[i..j])<=num
- max(arr[i..j])表示子数组arr[i..j]中的最大值，min(arr[i..j])表示子数组arr[i..j]中的最小值
- 复杂度要求o（N）

