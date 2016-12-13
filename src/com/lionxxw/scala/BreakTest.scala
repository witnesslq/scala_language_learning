package com.lionxxw.scala

import scala.util.control.Breaks

/**
  * @description 如何在scala中使用break
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/10 15:43
  * @version 1.0.0
  */

object BreakTest {
  def main(args: Array[String]): Unit = {
    val numList = List(1,2,3,4,5,6,7,8,9,10);

    val loop = new Breaks

    loop.breakable(
      for (i <- numList){
        println("value of " + i)
        if (i == 4){
          loop.break()
        }
      }
    )

    println("this over")
  }
}
