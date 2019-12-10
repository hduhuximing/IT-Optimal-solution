## 题目

### 如何仅用递归函数和栈操作逆序一个栈

【要求】

一个栈一次压入1，2，3，4，5，那么从栈顶带栈低分别为5，4，3，2，1。将这个栈转至后，从栈顶到栈低为1，2，3，4，5，也就是实现了栈中元素的逆序，但是只能用递归函数实现，不能用其他数据结构。

【方法】

需要设计两个递归函数

- 递归函数一getAndRemoveLastElement()，
- 最顶端元素出栈，记为result；
- 判断此时栈是否为空，为空直接return result；
- 否则，递归调用当前方法,返回获取到的元素记为last，由于是递归调用，因此last记录的是最下层的元素，
- 将result添加到栈中，每次添加的result是当前循环所取出的数据，再次压入栈中，保证整体数据顺序不变。
- 而last作为下一层的循环值，并不参与入栈，因此最终返回了栈的底部的值。
- 返回last

![image-20191210150421371](/Users/huximing/IdeaProjects/OptimalSolution/doc/stackAndQueue/StackReverse.assets/image-20191210150421371.png)

- 逆序一个栈reverse

- 由于已经拥有了获取并移除当前栈低的元素方法，因此首先判断传入的栈是不是空，为空直接返回；

- 调用getAndRemoveLastElement方法，移除一次。

- 移除后调用reverse方法，直到return栈中没有数据。

- 将当前循环所获取到的数据添加到栈中。

  ![image-20191210151625377](/Users/huximing/IdeaProjects/OptimalSolution/doc/stackAndQueue/StackReverse.assets/image-20191210151625377.png)

代码链接:[如何仅用递归函数和栈操作逆序一个栈](../../src/main/java/com/mi/learn/Stack_1/Stack3.java)