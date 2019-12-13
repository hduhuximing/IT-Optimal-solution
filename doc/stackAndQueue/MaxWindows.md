##生成窗口最大值数组

**题目**

有一个整形数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。

例如，如下数组，窗口长度为3

![image-20191213144756724](/Users/huximing/IdeaProjects/OptimalSolution/doc/stackAndQueue/MaxWindows.assets/image-20191213144756724.png)

如果数组长度为n，窗口长度为w，则产生的最大值数为n-w+1;

请实现一个函数。

- 输入：数组arr，窗口长度w
- 输出，n-w+1长度的res数组，res[i]表示一种窗口状态下的最大值。
- 时间复杂度O(n)

**思路**

用双端队列，实现窗口滑动。首先生成一个双端队列qmax，qmax内部存储当数组的下标。

假设遍历到了arr[i]，qmax放入规则如下：

- 如果qmax为空，直接放入
- 如果不是空，判断当前arr[i]是否大于队尾元素j所代表的的arr[j]
- 如果arr[i]<arr[j]，直接放入
- 如果arr[i]>=arr[j]，队尾的元素弹出，继续此循环。

加入qmax对头的下边等于i-w，对头出队。
代码链接：[MaxWindows](../../src/main/java/com/mi/learn/Stack_1/Stack7.java)