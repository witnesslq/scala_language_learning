package com.lionxxw.scala

import scala.collection.mutable.ListBuffer
/**
  * @description scala集合学习
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/11 10:49
  * @version 1.0.0
  */
object ListTest extends App{
  /**
    * list 集合创建
    * 默认是不可变的
    * 一个list分为两个部分：head和tail或者head和Nil
    */
  var list = List(1,2,3,4)
  println(list)

  /**
    * head代表的是第一个元素
    */
  println(list.head)

  /**
    * tail代表的是第一个元素之后的所有元素
    */
  println(list.tail)

  /**
    * Nil 表示一个空的list
    */
  println(Nil)

  /**
    * :: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。
    * 用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，
    * 也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
    */
  var new_list = 2::list
  println(new_list)

  /**
    * :+和+: 两者的区别在于
    * :+方法用于在尾部追加元素，
    *
    */
  var new2_list = list:+99
  println(new2_list)
  /**
    * +:方法用于在头部追加元素，和::很类似，
    * 但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。
    */
  var new3_list = 101+:list
  println(new3_list)

  /**
    * ++ 该方法用于连接两个集合，list1++list2
    */
  var new4_list = new2_list++new3_list
  println(new4_list)

  /**
    * ::: 该方法只能用于连接两个List类型的集合
    */
  var new5_list = new2_list:::new3_list
  println(new5_list)

  /**
    * 案例:
    * 用递归函数来给List中每个元素都加上指定前缀，并打印加上前缀的元素
    * @param list 待遍历集合
    * @param profix 前缀字符
    */
  def appendList(list: List[Int], profix: String): Unit ={
    if (Nil == list) return   //如果一个list只有一个元素，那么它的head就是这个元素，它的tail就是Nil
    print(profix+list.head+";")
    appendList(list.tail, profix)
  }

  appendList(new5_list,"hadoop")

  /**
    * 创建一个可变的list
    */
  val listBuffer = ListBuffer[Int]()
  /**
    * 追加元素
    */
  listBuffer += 1
  listBuffer += (3,4,5)
  listBuffer ++= List(6,7,8)
  println("\n"+listBuffer)

  /**
    * 删除指定元素/集合元素
    */
  listBuffer -= 3
  println(listBuffer)
  listBuffer -= (5,6,7)
  println(listBuffer)

  /**
    * 将可变集合转换为不可变集合
    */
  var list2 = listBuffer.toList
  println(list2.getClass)

  /**
    * list 转数组
    */
  var arr = list.toArray
  println(arr.getClass)

  /**
    * list常用方法
    */
  println(list.reverse) // 反转排序
  println(list.contains(1)) // 判断是否包含该元素
  println((1::list).distinct) // 去除list集合中重复的元素
  println(list.isEmpty) // 判断该集合是否为空
  println(list.exists(_>5)) // 判断满足_>5表达式的元素是否存在
  println(list.filter(_>1)) // 过滤不满足_>1表达式的元素
  println(list.length)    // 集合长度
  println(list.max)       // 返回该集合最大元素
  println(list.min)       // 返回该集合最小元素
}
