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

