package com.lionxxw.scala

import scala.collection.immutable.SortedMap
import scala.collection.mutable.LinkedHashMap
import scala.collection.mutable.HashMap

/**
  * @description map练习
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/13 10:06
  * @version 1.0.0
  */
object MapTest extends App {
  /**
    * map的创建方式1
    * 默认创建的map是不可变的
    */
  var map = Map("jack" -> 1, "mack" -> 2, "sala" -> 3)
  println(map)

  /**
    * map的创建方式2
    */
  var map2 = Map(("jack", 1), ("mask", 2), ("tank", 3))
  println(map2)

  /**
    * 创建一个可变map
    */
  var hashMap = HashMap[String, Int]()
  println(hashMap)

  /**
    * map追加元素
    * map中元素是无序的
    */
  hashMap += ("test1" -> 1, ("jack", 1), ("lion", 2))
  println(hashMap)

  /**
    * map移除元素
    */
  hashMap -= ("lion")
  println(hashMap)

  /**
    * 不可变的集合使用+或-符号
    * 不可变集合类，永远不会改变。不过，你仍然可以模拟添加，移除或更新操作。但是这些操作将在每一种情况下都返回一个新的集合，同时使原来的集合不发生改变。
    */
  var new_map = map + ("test1" -> 1, ("jack", 1), ("lion", 2))
  println(new_map.getClass)
  var new_map2 = map - ("jack")
  println(new_map2.getClass)

  /**
    * 根据key获取map中value
    */
  println(map("jack"))
  println(hashMap("jack"))

  /**
    * 注意:如果没有该key,会抛出异常 println(hashMap("xxx"))
    * 通过以下2种方法:先校验该key是否存在,再返回value
    */
  var value = if (hashMap.contains("xxx")) hashMap("xxx")
  println(value)
  println(hashMap.getOrElse("xxx", {}))

  /**
    * map遍历
    */
  for ((key, value) <- map) print(key + ":" + value + "\t")
  println("\nmap key 遍历")
  for (key <- map.keySet) print(key + "\t")
  println("\nmap value 遍历")
  for (value <- map.values) print(value + "\t")

  /**
    * Scala默认的自动按照key进行排序，使用SortedMap函数进行操作
    */
  var sortMap = SortedMap[String, Int]("hadoop" -> 1, "spark" -> 2, "hive" -> 3, "hbase" -> 4)
  println("\n" + sortMap)

  /**
    * 使用LinkedHashMap帮助我们记录插入的元素顺序
    */
  var linkMap = LinkedHashMap[String, Int]("hadoop" -> 1, "spark" -> 2, "hive" -> 3, "hbase" -> 4)
  println(linkMap)

  /**
    * zip操作（拉链操作）
    * zip方法将两个集合结合在一起
    * -》注意：返回的都是一个Tuple元组队
    */
  var arr1 = Array("hadoop", "hive", "sqoop", "spark", "hbase")
  var arr2 = Array(1, 2, 3, 4, 5)
  for (tmp <- arr1.zip(arr2)) print(tmp + "\t")
  println("\n list 也可进行zip操作")
  var list1 = List("hadoop", "hive", "sqoop", "spark", "hbase")
  var list2 = List(1, 2, 3, 4, 5)
  for (tmp <- list1.zip(list2)) print(tmp + "\t")
  println("\n zipWithIndex 将元素和下标结合在一起")
  for(tmp <- list1.zipWithIndex) print(tmp + "\t")
}
