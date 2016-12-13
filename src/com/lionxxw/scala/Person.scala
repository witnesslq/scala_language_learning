package com.lionxxw.scala

/**
  * @description TODO
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/11 11:44
  * @version 1.0.0
  */
class Person(val name: String, val  age: Int) { // 属性用val,外部才可访问
  println("before ........")

  var gender: String = _
  def this(name: String, age: Int, gender: String)={
    this(name, age)
    this.gender = gender
  }

  println("my name is "+name+", i am "+age + " years old"+",sex is "+ gender)

  println("after ........")
}
object Person extends App{
  var person = new Person("wx", 26, "male")

  println(person.name)
  println(person.age)
  println(person.gender)
}
