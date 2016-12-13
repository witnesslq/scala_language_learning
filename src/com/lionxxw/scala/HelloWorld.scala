package com.lionxxw.scala

/**
  * @description TODO
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/10 11:37
  * @version 1.0.0
  */

object HelloWorld {
  def main(args: Array[String]): Unit = {
      def printArgs(args: String*): Unit ={
        args.foreach(x => print(x + "\t"))
      }

      //printArgs("test1","test2","test3")

      def sum(nums: Int*)={
        var result = 0
        for (num <- nums){
          result += num
        }
        result
      }

      for (i <- 1 until 10; j <- 1 until 10){
        if (j == 9){
          println(i*j)
        }else{
          if (i > j){
            print(i*j + " ")
          }
        }
      }
  }
}
