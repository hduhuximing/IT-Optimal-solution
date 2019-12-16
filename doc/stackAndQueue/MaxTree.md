## 构造数组的MaxTree

#### 题目

定义二叉树节点如下

```java
class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}
```

一个数组的MaxTree：

- 数组必须没有重复的元素
- MaxTree是一棵二叉树，数组中的每一个值对应一个二叉树节点
- 包括MaxTree树在内在其中的每一棵子树上，值最大的节点都是树的头

给定一个没有重复的数组arr，生成这个数组的MaxTree。

#### 原理：

- 每个数的父节点是他左边第一个比他大的数和右边第一个比他大的树中，较小的数据
- 如果一个数，左边和右边都没有比他大的，这个数是整个数组的最大值，也就是根节点。
- 通过此方法所有树都只有两个节点，

![image-20191216190904676](/Users/huximing/IdeaProjects/OptimalSolution/doc/stackAndQueue/MaxTree.assets/image-20191216190904676.png)

代码链接:[用栈实现汉诺塔问题](../../src/main/java/com/mi/learn/Stack_1/Stack8.java)