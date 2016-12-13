package com.lionxxw.scala

/**
  * @description Set集合学习
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/13 15:46
  * @version 1.0.0
  */

object SetTest extends App{
  /**
    * 创建一个set集合,默认也是不可变的
    * 特点:无序不重复
    */
  var set = Set(1,2,3,4,1)
  println(set)

  /**
    * +   单个/多个元素如:(5,6)
    * ++  集合
    * -
    * --
    * 操作都会创建一个新的set
    */
  println(set+5)
  println(set+(5,6))
  println(set++List(5,6))
  println(set-1)
  println(set-2)
  println(set-(2,3))
  println(set-- List(2,3))

  println("------------↓可变长Set集合↓------------")
  /**
    * 创建可变长Set集合
    */
  var setBuff = scala.collection.mutable.Set(1,2,2,3,3,4)
  println(setBuff)

  /**
    * + 返回一个新的Set集合
    */
  var set_new = setBuff + 6
  println(setBuff)
  println(set_new)

  /**
    * += 在原集合的基础上添加
    */
  setBuff += 5
  println(setBuff)

  /**
    * -= 删除指定元素
    */
  setBuff -= 1
  println(setBuff)

  /**
    * ++= 在原集合基础上添加一个集合的元素
    */
  setBuff ++= List(1,5,9)
  println(setBuff)

  println(setBuff.contains(1))
}