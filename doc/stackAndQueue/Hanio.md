## 用栈实现汉诺塔问题

普通汉诺塔算法：

```java
public class TestHanoi {

	public static void main(String[] args) {
		hanoi(5,'A','B','C');
	}
	/**
	 * @param n 	共有N个盘子
	 * @param from	开始的柱子
	 * @param in		中间的柱子
	 * @param to		目标柱子
	 * 无论有多少个盘子，都认为只有两个。上面的所有盘子和最下面一个盘子。
	 */
	public static void hanoi(int n,char from,char in,char to) {
		//只有一个盘子。
		if(n==1) {
			System.out.println("第1个盘子从"+from+"移到"+to);
		//无论有多少个盘子，都认为只有两个。上面的所有盘子和最下面一个盘子。
		}else {
			//移动上面所有的盘子到中间位置。
			hanoi(n-1,from,to,in);
			//移动最下面的盘子到目标地点。
			System.out.println("第"+n+"个盘子从"+from+"移到"+to);
			//把上面的所有盘子从中间位置移到目标位置
			hanoi(n-1,in,from,to);
		}
	}

}
```

传统汉诺塔问题更新要求：

- 不能从最左边到最右边，也不能从最右边到最左边。
- 递归方法

1.**递归方法**

- 如果**只有最上层**的塔需要移动，有如下操作：

![image-20191213113536492](/Users/huximing/IdeaProjects/OptimalSolution/doc/stackAndQueue/image-20191213113536492.png)

以上过程为递归的终止条件，也就是只剩上层塔时的打印过程。

如果剩下N层塔，从最上到最下依次为1~N，则：

- 如果剩下的N层塔在左边，希望全部移动到中间，则需要三个步骤
  - 1~N-1全部移动到右侧，需要递归操作
  - 第N层塔从左边移动到中间
  - 将1~N-1全部移动到中间，递归操作
- 如果把剩下的N层塔从中间移动到左侧，从中到右，从右到中，与当前过程相同，
- 如果剩下的N层塔都在左边，全部移动到右边：
  - 将1~N-1从左移动到右侧，递归，
  - 将第N层从左移动到中
  - 将1~N-1从右移动到左侧，递归
  - 将第N层从中移动到右侧
  - 最后将1~N-1从左侧移动到右侧 递归
  - 如果剩下的N层都在右侧，希望移动到左侧，情况与当前相同

代码链接:[用栈实现汉诺塔问题](../../src/main/java/com/mi/learn/Stack_1/Stack6.java)