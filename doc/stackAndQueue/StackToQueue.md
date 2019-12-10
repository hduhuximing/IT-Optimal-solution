## 题目

### 由两个栈组成队列

**【要求】**

- 编写一个类用两个栈实现队列，支持队列的基本操作(add、poll、peek)

**【方法】**

- 栈是先进后出，队列先进先出。因此可以用两个栈来将传入栈的数据倒序
- 第一个栈作为压入元素栈，记为stackPush，第二个栈作为弹出数据栈记为stackPop
- 需要将数据线压入stackPush中，当出栈时判断stackPop是否为空；
- 如果是空，将stackPush的所有数据全部取出压入stackPop中，此时数据已经反转过来，
- 如果当前stackPop非空，表示当前出栈口还有数据，不做操作。
- 从stackPop中弹出数据即可。

![image-20191210145239475](/Users/huximing/IdeaProjects/OptimalSolution/doc/stackAndQueue/StackToQueue.assets/image-20191210145239475.png)

**【注意】**

- 如果stackPush要将数据都压入stackPop中，必须一次性全部压入。
- 如果stackPop非空，不能向其中添加数据。

代码链接：[两个栈组成队列](../../src/main/java/com/mi/learn/Stack_1/Stack2.java)