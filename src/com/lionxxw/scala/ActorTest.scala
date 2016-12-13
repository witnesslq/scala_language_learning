package com.lionxxw.scala

import scala.actors.Actor
/**
  * @description TODO
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/11 16:30
  * @version 1.0.0
  */
object ActorTest extends App{
  var arr = Array("xx","yy","zz")
  arr.foreach(x => print(x +"\t"))

  def sum(nums: Int*): Int = {
    var result = 0
    nums.foreach(num => result += num)
    result
  }

  print("\nresult="+sum(1,2,3))
}
