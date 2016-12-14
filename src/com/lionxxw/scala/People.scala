package com.lionxxw.scala

/**
  * @description scala类的定义
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/13 16:13
  * @version 1.0.0
  */

class People {
  var name: String = "" // var会生成getter/setter方法
  val age: Int = 10     // val只会生成getter方法

  /**
    * 定义方法
    * @return string
    */
  def eat():String={
    name + " eating..."
  }

  /**
    * 无参的方法定义可以省略()
    * @return
    */
  def drink:String={
    name + "drinking..."
  }

  /**
    * 无返回值方法
    * @param item
    */
  def watchTv(item: String){
    println(name + "is watching TV of " + item)
  }
}

/**
  * object,相当于class的单个实例,通常在里面放一些静态的field或者method
  */
object SimpleObjectDemo{
  def main(args: Array[String]): Unit = {
    val people = new People();
    people.name = "lion"
    println("people name is "+ people.name + ", age is " + people.age)

    /**
      * 调用class类中无参的方法
      */
    println("people invoke eat method" + people.eat())
    println("people invoke eat method" + people.eat)  // 无参时可以不用带()
    println("people invoke drink method" + people.drink)  // 无参时可以不用带()

    /**
      * 调用class类中有参的方法
      */
    people.watchTv("go go go")
  }
}