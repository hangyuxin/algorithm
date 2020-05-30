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
	2. 
- 查找算法：  
	1. 二分法：  
		@ Description 在一个升序的队列中，如何较快的找到一个数字存不存在  
		@ author yuxin.hang  
		@ date 2020/5/28 22:05:49  
		@ package com.hyx.find.dichotomy  
		@ name DichotomyFind  
- 树：  
	1. 二叉树：  
		@ Description 将一个给定数组排为树形，要求树的左侧的子节点比当前节点小，树的右侧节点比当前节点大  
		@ author yuxin.hang  
		@ date 2020/5/30 20:43:02 
		@ package com.hyx.tree.binary  
		@ name BinaryTree
	2. 红黑树：  
		@ Description 将一个给定数组排为树形，要求树的左侧的子节点比当前节点小，树的右侧节点比当前节点大,要求树为红黑树(见红黑树定义)(此算法暂时未完成，预计明天完成)
		> 红黑树是每个节点都带有颜色属性的二叉查找树，颜色或红色或黑色,在二叉查找树强制一般要求以外，对于任何有效的红黑树我们增加了如下的额外要求:  
			1. 节点是红色或黑色  
			2. 根节点是黑色  
			3. 所有叶子都是黑色(叶子是NUIL节点)  
			4. 每个红色节点的两个子节点都是黑色(从每个叶子到根的所有路径上不能有两个连续的红色节点)  
			5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点   
		
		@ author yuxin.hang  
		@ date 2020/5/30 20:43:02 
		@ package com.hyx.tree.rb  
		@ name RedBlackTree  
#### Git Feature
1. Repository address [http://github.com]("github")
2. Http address [https://github.com/hangyuxin/algorithm.git]("本库http地址")
3. ssh address [git@github.com:hangyuxin/algorithm.git]("本库ssh地址")
	