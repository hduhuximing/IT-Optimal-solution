## 题目
### 设计一个有getMin功能的栈
**【要求】**

- pop、push、getMin操作的时间复杂度你都是O(1).

- 设计的栈类型可以使用现成的栈结构

**【方法1】**

应用两个栈实现，第一个栈作为保存当前元素，记为stackData，第二个栈保存每次存取后的最小值，记为stackMin。

- 入栈规则

  - 设当前数据为num，将当前数据压入栈stackData中，判断stackMin是否为空；
  - 如果是空，则直接将num压入栈stackMin中；
  - 如果不为空，判断当前stackMin栈顶元素和当前值得哪个更小；
  - 如果num小于等于stackMin栈顶元素，将其添加到stackMin中；
  - 如果num大于stackMin栈顶元素，不做操作。

- 出栈规则

  - 弹出stackData栈顶的数据value，将其与stackMin栈顶数据进行比较；
  - 当value等于stackMin栈顶元素的时候，弹出stackMin栈顶元素，否则不做操作；

  **说明：**有上述压入栈操作可知，stackMin的元素是从栈低到栈顶逐渐变小，因此stackMin中栈顶的元素就是当前栈中最小的元素。因此当前出栈操作不会比stackMin更小。

- 获取最小元素

  - 如上所说，当前stackMin的栈顶元素即为栈中最小元素，因此只需要读取stackMin元素即可。

**【方法2】**

- 入栈规则
  - 设当前数据为num，将数据压入栈stackData中，判断stackMin是否为空；
  - 如果为空，直接添加进stackMin；
  - 非空，比较当前元素和stackMin栈顶元素，去最小值压入栈中。
- 出栈规则
  - 两个栈都弹出栈顶元素；
- 最小值获取
  - 由上述规则可知，每次stackMin中都会保存当前的最小值，在入栈时添加的数据，省去了出栈的比较操作。
  - 最终stackMin的栈顶仍然保存着当前的最小数据。

代码链接：[getMin代码](../../src/main/java/com/mi/learn/Stack_1/Stack1.java)