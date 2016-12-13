package com.lionxxw.scala

import scala.util.Sorting

/**
  * @description 数组基本操作练习
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/12 14:27
  * @version 1.0.0
  */

object ArrayTest extends App{
  var arr = Array(2,12,3,4,1,6)
  println("min="+arr.min)
  println("max="+arr.max)
  println("sum="+arr.sum)

  println("↓↓↓↓↓↓↓↓↓↓↓↓↓数组遍历↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
  for (i <- 0 until arr.length) print(arr(i)+"\t")

  Sorting.quickSort(arr)
  println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓排序后数组增强for循环遍历↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
  for (c <- arr) print(c + "\t")

  /**
    * Array 转换为 ArrayBuffer
    */
  var arrBuffer = arr.toBuffer
  println("\narrBuffer >>> "+arrBuffer)
  arrBuffer.trimEnd(2)
  println("trimEnd(2) >>> "+arrBuffer)
  arrBuffer += 10
  println("+=10 >>> "+arrBuffer)
  arrBuffer += (5,4,9)
  println("+= (5,4,9) >>> "+arrBuffer)
  arrBuffer ++= arr
  println("++= arr >>> "+arrBuffer)
  arrBuffer.insert(0, 3)
  println("insert(0, 3) >>> "+arrBuffer)
  arrBuffer.insert(5, 5,5,6)
  println("insert(5, 5,5,6) >>> "+arrBuffer)
  arrBuffer.remove(0)
  println("remove(1) >>> "+arrBuffer)
  arrBuffer.remove(0,3)
  println("remove(1,3) >>> "+arrBuffer)
}
