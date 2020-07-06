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
		@ package com.hyx.dp.stock  
		@ name TransactionMaxProfit  
	4. 连续数组的最大值：  
		@ Description 给定一个整型数组arrays，数组中一个或连续的多个整数组成一个子数组，求所有子数组的和的最大值  
		@ author yuxin.hang  
		@ date 2020/6/8 20:54:54  
		@ package com.hyx.dp.sum  
		@ name MaxSonArraysSum  
	5. 正则表达式：  
		@ Description 给定一个正则表达式p(只能含有.(匹配1个任意字符)和*(匹配0~n个*号前面的字符))，在给定一个字符串s，判断s是否符合p的规律  
		@ author yuxin.hang  
		@ date 2020/6/9 22:45:08   
		@ package com.hyx.dp.match  
		@ name Pattern  
	6. 接雨水：  
		@ Description 给定一个整型数组arrays(大于 1)，将每个数n换算为高为n宽为1的柱子，求这些柱子中可以接多少水  
		@ author yuxin.hang  
		@ date 2020/6/10 20:58:51  
		@ package com.hyx.dp.sum  
		@ name CatchRain  
	7. 骑士救公主：  
		@ Description 某一个公主被魔王困于地下城中，一个骑士要去拯救公主，给定一个矩阵，每个元素代表一个房间，公主在最后一排最后一列的房间中， 骑士从第一排第一列出发，每个房间中的数字代表骑士进入该房间会增加的血量，当骑士血量=0时骑士会死亡，求骑士救出公主最低所需初始血量  
		@ author yuxin.hang  
		@ date 2020/6/14 20:49:40  
		@ package com.hyx.dp.table  
		@ name KnightSavesThePrincess  
	8. 最大有效括号：  
		@ Description 给定一个字符串s，s中只包含'('和')'这两种字符，求s中最长的合法括号长度  
		@ author yuxin.hang  
		@ date 2020/6/15 12:48:39  
		@ package com.hyx.dp.sum  
		@ name MaxEffectiveBrackets  
	9. 正则表达式二：  
		@ Description 给定一个正则表达式p(只能含有?(匹配1个任意字符)和*(匹配任意字符串))，在给定一个字符串s，判断s是否符合p的规律  
		@ author yuxin.hang  
		@ date 2020/6/16 17:50:20  
		@ package com.hyx.dp.match  
		@ name Pattern1  
	10. 扰乱字符串：  
		@ Description 给定一个字符串s，可以依据任何节点将字符串划分为两个非空子字串，一直划分为每个子字符串都只有一个字符，然后可以任意n个节点旋转一次来得出一个字符串s1，在给定一个字符串s2，求s2是否为s1  
		@ author yuxin.hang  
		@ date 2020/6/18 19:10:10  
		@ package com.hyx.dp.string  
		@ name DisturbString  
	11. 编辑距离：  
		@ Description 给定两个字符串s1，s2，你可以对s1和s2进行任何操作(每次操作只可以动一个字符，删除、插入和修改)，求将s1和s2变为相等字符串最少需要操作几次？
		@ author yuxin.hang  
		@ date 2020/6/19 17:44:53  
		@ package com.hyx.dp.string  
		@ name EditString  
	12. 交错字符串：  
		@ Description 给定一个字符串s1一个字符串s2一个字符串s3，求s2是否有s1+s2交错而成的  
		@ author yuxin.hang  
		@ date 2020/6/20 17:33:30  
		@ package com.hyx.dp.string  
	13. 不同子序列：  
		@ Description 给定一个字符串s1，一个字符串s2。你可以对s1进行删除字符操作，求将s1变换为s2最多有几种方式  
		@ author yuxin.hang  
		@ date 2020/6/22 17:57:58  
		@ package com.hyx.dp.string  
		@ name SubSequenceString  
	14. 最长回文串：  
		@ Description 给定一个字符串s1，求s1中的最大回文子串  
		@ author yuxin.hang  
		@ date 2020/6/23 17:24:10  
		@ package com.hyx.dp.string  
		@ name MaxPalindromeString  
	15. 最小切割回文串：  
		@ Description 给定一个字符串s，通过n次切割，使s的每个子串都是回文串，求n最小为多少  
		@ author yuxin.hang  
		@ date 2020/6/24 17:32:26  
		@ package com.hyx.dp.string  
		@ name MinCutPalindromeString  
	16. 字符编码：  
		@ Description 给定一个只包含数字的字符串， 字符串内的字符按以下编码来编码吗，1-a、2-b …… 26-z，求最多可以转换出多少种字符串  
		@ author yuxin.hang  
		@ date 2020/6/26 19:17:29  
		@ package com.hyx.dp.string  
		@ name CharacterEncodingSring  
	17. 恢复二差搜索树：  
		@ Description 给定一个整数，将该数恢复成二叉搜索树，求最多可以恢复出多少种  
		@ author yuxin.hang  
		@ date 2020/6/27 13:28:21  
		@ package com.hyx.dp.tree  
		@ name BinarySearchTree  
	18. 不同二差搜索树：  
		@ Description 给定一个整数，将该数恢复成二叉搜索树，求最多可以恢复出多少种  
		@ author yuxin.hang  
		@ date 2020/6/28 17:36:13  
		@ package com.hyx.dp.tree  
		@ name BinarySearchTree1  
	19. 最短超级串：  
		@ Description 给定一个字符串数组ss，使用ss中的字符串的子串组成一个字符串s，s中要包含ss中所有的字符串，求s最短为什么  
		@ author yuxin.hang  
		@ date 2020/6/29 20:18:28  
		@ package com.hyx.dp.string  
		@ name MinSuperString  
	20. 单次拆分：  
		@ Description 给定一个字符串s，一个字符串数组ss，求s是否可以拆分为ss中的单词，ss中的单词可以重复使用，s中的字符不可以重复使用  
		@ author yuxin.hang  
		@ date 2020/6/30 19:34:54  
		@ package com.hyx.dp.string  
		@ name WordSplitString  
	21. 乘积最大子数组：  
		@ Description 给定一个整数数组s，求s中子数组乘积最大为多少  
		@ author yuxin.hang  
		@ date 2020/7/1 22:29:52  
		@ package com.hyx.dp.sum  
		@ name MaxSonArrayMultiplication  
	22. 最大偷窃数额：  
		@ Description 给定一个数组n，数组中全部为大于0的数，取数时不可以连续取，必须接隔一位，求最大能取多大的数  
		@ author yuxin.hang  
		@ date 2020/7/2 22:24:24  
		@ package com.hyx.dp.sum  
		@ name TheftMoneyMax  
	23. 最大偷窃数额1：  
		@ Description 给定一个数组n，数组中全部为大于0的数，取数时不可以连续取，必须接隔一位，求最大能取多大的数, 首尾只能可以偷窃一个  
		@ author yuxin.hang  
		@ date 2020/7/3 23:16:13  
		@ package com.hyx.dp.sum  
		@ name TheftMoneyMax1  
	24. 最大正方形：  
		@ Description 给定一个二维数组n，数组汇总只有0,1两种数字，求有1组成的正方形最大面积为多大  
		@ author yuxin.hang  
		@ date 2020/7/4 15:48:42  
		@ package com.hyx.dp.table  
		@ name MaxSquare  
	25. 丑数：  
		@ Description 给定一个数字n，求第n个丑数为多少？(丑数为质因数只有2,3,5的数)  
		@ author yuxin.hang  
		@ date 2020/7/5 17:48:37  
		@ package com.hyx.dp.find  
		@ name UglyNumber  
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
	3. 两数之和等于第三数：  
		@ Description 给定 一组数组arrays和一个数n，求出数组中哪两个元素之和等于n  
		@ author yuxin.hang  
		@ date 2020/6/13 19:14:07   
		@ package com.hyx.find.hash  
		@ name SumTwoNumber  
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
- 机器学习:
	1. 朴素贝叶斯分类：  
		@ Description 一种自动分类算法
		> [https://baike.baidu.com/item/%E6%9C%B4%E7%B4%A0%E8%B4%9D%E5%8F%B6%E6%96%AF/4925905?fr=aladdin](https://baike.baidu.com/item/%E6%9C%B4%E7%B4%A0%E8%B4%9D%E5%8F%B6%E6%96%AF/4925905?fr=aladdin "朴素贝叶斯百度百科")  
		> 贝叶斯方法是以贝叶斯原理为基础，使用概率统计的知识对样本数据集进行分类。由于其有着坚实的数学基础，贝叶斯分类算法的误判率是很低的。贝叶斯方法的特点是结合先验概率和后验概率，即避免了只使用先验概率的主观偏见，也避免了单独使用样本信息的过拟合现象。贝叶斯分类算法在数据集较大的情况下表现出较高的准确率，同时算法本身也比较简单。
		
		@ author yuxin.hang  
		@ date 2020/6/11 20:46:31   
		@ package com.hyx.ai.lassify  
		@ name NaiveBayesianAlgorithmLassify  
- 计算
	1. 信息熵：  
		@ Description 计算信息熵的大小  
		@ author yuxin.hang  
		@ date 2020/6/12 22:14:19    
		@ package com.hyx.info.entropy  
		@ name Entropy  
- 有限状态机
	1. 数字有效性：  
		@ Description 给定一个字符串s，判断s是否为一个正确的十进制数字，可以包括(+,-,e,.,[0-9])  
		@ author yuxin.hang  
		@ date 2020/6/17 18:03:42    
		@ package com.hyx.statemachine.finite  
		@ name VerificationNumber  
- 栈  
	1. 最大矩形：  
		@ Description 给定一个数组a，a中全部为非负整数，求a中存在的最大矩形面积为多少？  
		@ author yuxin.hang  
		@ date 2020/6/21 17:25:48    
		@ package com.hyx.stack.monotonous  
		@ name MaxRectangle  
- 图
	1. 广度优先算法(BFS)：  
		1.  单词接龙：  
			@ Description 问：给定一个字符串s1，一个字符串s2，一个字符串列表ss，s1每次可以从ss总选取一个字符串来转换，每次转换最多转换一个字符，求s1转换为s2的最短顺序  
			@ author yuxin.hang  
			@ date 2020/6/25 18:39:09  
			@ package com.hyx.graph.breadth  
			@ name WordSolitaire  
	2. 深度优先算法(DFS)： 
		1.  xxx：  
			@ Description XXX  
			@ author XXX  
			@ date XXX  
			@ package XXX  
			@ name XXX  
- 链表
	1. 重复数字：  
		@ Description 给定一个数组，改数组中存在一个数字是重复的，求这个重复的数字为多少  
		@ author yuxin.hang  
		@ date 2020/7/6 19:01:08    
		@ package com.hyx.list.node  
		@ name RepeatNumber  
#### Git Feature
1. Repository address [http://github.com](http://github.com "github")
2. Http address [https://github.com/hangyuxin/algorithm.git](https://github.com/hangyuxin/algorithm.git "本库http地址")
3. ssh address [git@github.com:hangyuxin/algorithm.git](git@github.com:hangyuxin/algorithm.git "本库ssh地址")
	