#algorithm

#### Description
平常用到听到的一些算法的实现

#### Software Architecture
- system：windows10
- java：jdk8
- goLang：1.14.3
- javaScript：无特定版本
- editor：eclipse、vsCode
- versionManager：gradle、Artifactory
#### Contribution  
1. yuxin.hang: yuxin.hang1@outlook.com

#### Foreword  
本库内所有代码希望你们都是自己写的，敬请不要从公司代码库内copy，本库内所有算法兼可无条件使用
本库内所有算法都由算法提供者自己实现，未必标准，如有错误敬请提出，望指教。  

----------  
- 道格拉斯抽稀算法：  
	@ Description 用于将大量坐标点压缩，路径却变动微小(当大量坐标点打印到前端，前端渲染后虽然细腻，但如此多的dom元素会使前端卡死)  
	@ author yuxin.hang  
	@ date 2020/5/28 20:50:36  
	@ package com.hyx.distil.douglas  
	@ name DouglasDistil  
- 大数据去重算法：  
	@ Description 用于在大量数据中查找重复项(本算法是我基于hash算法和bit树自己构思的，暂时还没有完成，如有小伙伴有更好的算法欢迎提出)  
	@ author yuxin.hang  
	@ date 2020/5/28 21:34:57  
	@ package com.hyx.bigdata.deduplication  
 	@ name DataDeduplocation  
- 动态规划算法：  
	1. 鸡蛋下楼：  
		@ Description 有n个鸡蛋m层楼，在最坏的情况下求出最少需要扔几次鸡蛋可以找到鸡蛋不被摔破的最高层(原google面试题) 
		> You work in a 100 floor building and you get 2 identical eggs.
		You need to figure out the highest floor an egg can be dropped without breaking.
		The question is how many throws you need to make.
		Find an algorithm that is minimizing number of throws in the worst-case scenario.

		@ author yuxin.hang  
		@ date 2020/5/29 21:14:15  
		@ package com.hyx.dp.downstairs  
		@ name EggDownstair  
	2. 青蛙上楼：  
		@ Description 现有一只青蛙frog，frog每次可以跳上 1层台阶或者2层台阶，问当有 n层台阶时frog共有多少种方式跳上去  
		@ author yuxin.hang  
		@ date 2020/6/6 21:07:36  
		@ package com.hyx.dp.downstairs  
		@ name FrogUpstairs  
	3. 股票最大利润：  
		@ Description 给定一个数组a[]，数组中的数据为一只股票的每日价钱，第i个元素代表股票第i天的价钱，请设计一个策略求出最大买n次所获得的利益  
		@ author yuxin.hang  
		@ date 2020/6/7 20:11:55   
		@ package com.hyx.dp.stack  
		@ name TransactionMaxProfit  
- 查找算法：  
	1. 二分法：  
		@ Description 在一个升序的队列中，如何较快的找到一个数字存不存在  
		@ author yuxin.hang  
		@ date 2020/5/28 22:05:49  
		@ package com.hyx.find.dichotomy  
		@ name DichotomyFind  
	2. kmp算法：  
		@ Description KMP算法是一种改进的字符串匹配算法
		> [https://baike.baidu.com/item/kmp%E7%AE%97%E6%B3%95/10951804?fromtitle=KMP&fromid=10158450&fr=aladdin](https://baike.baidu.com/item/kmp%E7%AE%97%E6%B3%95/10951804?fromtitle=KMP&fromid=10158450&fr=aladdin "kmp算法介绍")  
		> 由D.E.Knuth，J.H.Morris和V.R.Pratt提出的，因此人们称它为克努特—莫里斯—普拉特操作（简称KMP算法）。KMP算法的核心是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的。具体实现就是通过一个next()函数实现，函数本身包含了模式串的局部匹配信息。KMP算法的时间复杂度O(m+n)  
		
		@ author yuxin.hang  
		@ date 2020/6/1 19:20:05   
		@ package com.hyx.find.kmp  
		@ name KmpFind  
- 树：  
	1. 二叉树：  
		@ Description 将一个给定数组排为树形，要求树的左侧的子节点比当前节点小，树的右侧节点比当前节点大  
		@ author yuxin.hang  
		@ date 2020/5/30 20:43:02 
		@ package com.hyx.tree.binary  
		@ name BinaryTree  
	2. 红黑树：  
		@ Description 将一个给定数组排为树形，要求树的左侧的子节点比当前节点小，树的右侧节点比当前节点大,要求树为红黑树(见红黑树定义)
		> 红黑树是每个节点都带有颜色属性的二叉查找树，颜色或红色或黑色,在二叉查找树强制一般要求以外，对于任何有效的红黑树我们增加了如下的额外要求:  
			1. 节点是红色或黑色  
			2. 根节点是黑色  
			3. 所有叶子都是黑色(叶子是NUIL节点)  
			4. 每个红色节点的两个子节点都是黑色(从每个叶子到根的所有路径上不能有两个连续的红色节点)  
			5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点   
		
		@ author yuxin.hang  
		@ date 2020/5/30 20:43:02
		@ editDate 2020/5/31 20:04:45  
		@ package com.hyx.tree.rb  
		@ name RedBlackTree  
	3. 最大堆：  
		@ Description 将一个给定数组排为树形，要求树的最高节点最大,树的子节点小于或等于父节点  
		@ author yuxin.hang  
		@ date 2020/6/3 23:06:38  
		@ package com.hyx.tree.binary  
		@ name MaxTopBinaryTree  
- 排序：
	1. 快速排序：  
		@ Description 将一个给定数组按给定规则排为有序数组(见快速排序定义)
		> 快速排序由C. A. R. Hoare在1960年提出。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列  

		@ author yuxin.hang  
		@ date 2020/6/2 21:55:40 
		@ package com.hyx.sort.fast  
		@ name FastSort  
	2. 堆排序:  
		@ Description 将一个给定数组按给定规则排为有序数组(见堆排序定义)
		> 堆排序（英语：Heapsort）是指利用堆这种数据结构所设计的一种排序算法，堆是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点  

		@ author yuxin.hang  
		@ date 2020/6/3 23:08:44  
		@ package com.hyx.sort.stack  
		@ name StackSort  
- 回溯：
	1. N皇后:   
		@ Description 求在一个N*N的棋盘上，摆放N个皇后旗子，同时使所有皇后彼此之间都无法相互攻击最多几种摆法(皇后见定义)
		> 英文：Queen是国际象棋棋局中实力最强的一种棋子，可横直斜走，且格数不限，吃子与走法相同。 

		@ author yuxin.hang  
		@ date 2020/6/4 21:36:25  
		@ package com.hyx.backtrack.queen  
		@ name NQueen  
- 贪心：
	1. 最小付钱：  
		@ Description 现在存在N种钱，每种钱价值Nm，数量Nn，求在付W块钱时，如何付才可以使掏出的钱最少
		@ author yuxin.hang  
		@ date 2020/6/5 20:40:42   
		@ package com.hyx.greedy.money  
		@ name MinNumPayment  
#### Git Feature
1. Repository address [http://github.com](http://github.com "github")
2. Http address [https://github.com/hangyuxin/algorithm.git](https://github.com/hangyuxin/algorithm.git "本库http地址")
3. ssh address [git@github.com:hangyuxin/algorithm.git](git@github.com:hangyuxin/algorithm.git "本库ssh地址")
	