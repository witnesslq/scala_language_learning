package com.lionxxw.scala

/**
  * @description scala 函数学习
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/14 14:24
  * @version 1.0.0
  */

object FunTest extends App{
  def sayHello(name: String): Unit ={
    println("hello "+ name)
  }

  /**
    * 函数可以直接赋值给变量
    * 注意:函数赋值给变量时,必须在函数后面加上空格和下划线" _"
    */
  var reg = sayHello _
  reg("wx")

  /**
    * 匿名函数
    * 语法:(参数名: 参数类型) => 函数体
    */
  var reg2 = (name: String) => println("Hi! " + name)
  reg2("lionxxw")

  /**
    * 高阶函数
    * 定义: 接受其他函数作为参数的函数,被称为高阶函数
    */
  def sayHi(func: (String) => Unit,name:String): Unit ={
    func(name)
  }
  sayHi(sayHello, "wangx")
  sayHi((name: String) => println("go "+ name), "Leo")

  /**
    * 高阶函数可以自动推断出参数类型,而不需要写明类型,而且对于只有一个参数的函数,还可以省去其小括号
    */
  sayHi(name => println("come on " + name), "mark")

  /**
    * 如果仅有的一个参数在右侧的函数体内只使用一次,则还可以将接受参数省略,并且将参数用_来替代
    * @param func
    * @return
    */
  def triple(func: (Int) => Int)={
    func(3)
  }
  println(triple(3 * _))

  /**
    * map:对传入的每个元素都进行映射,返回一个处理后的元素
    */
  for (c <- Array(1,2,3,4,5).map(2 * _)) print(c + "\t")
  println()

  /**
    * foreach:对传入的每个元素都进行处理,但是没有返回值
    */
  (1 to 9).map("*" * _).foreach(println _)

  /**
    * filter:对传入的每个元素都进行条件判断,如果对元素返回true,则保留该元素,否则过滤掉该元素
    */
  println((1 to 20).filter(_ % 2 == 0))

  /**
    * reduceLeft:从左侧元素开始,进行reduce操作,即先对元素1和元素2进行处理,然后结果与元素3处理,依次类推
    */
  println((1 to 9).reduceLeft(_ * _)) // 相当于1*2*3...*9
}