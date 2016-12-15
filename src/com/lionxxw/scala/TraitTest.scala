package com.lionxxw.scala

import com.lionxxw.scala

/**
  * @description Scala Trait 练习,可作为接口来使用
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/15 11:14
  * @version 1.0.0
  */
object TraitTest extends App{
  /**
    * 1.trait可作为接口来使用
    * 2.trait可以定义抽象方法
    * 3.类可以使用extends关键字继承trait,在scala中没有implements
    * 4.类继承trait后,必须实现其中的抽象方法,实现时不需要使用override关键字
    * 5.scala不支持对类进行多继承,但是支持多重继承trait,使用with关键字即可
    */
  trait HelloTrait{
    def sayHello(name: String)
  }

  trait MakeFriendsTrait{
    def makeFriends(p: Person)
  }

  /**
    * trait 示例:作为接口
    * @param name
    */
  class Person(val name: String) extends HelloTrait with MakeFriendsTrait{
    def sayHello(name: String): Unit = println("hello " + name)

    def makeFriends(p: Person): Unit = println("my name "+ name+",your name "+p.name)
  }

  val person = new Person("admin")
  person.sayHello(person.name)

  // trait 示例:定义具体方法
  trait Logger{
    def log(msg: String) = println("log , " + msg)
  }

  class Person2(val name : String) extends Logger{
    def sayHello{
      println ("Hello , I'm " + name )
      log("sayHello is invoked")
    }
  }
  val person2 = new Person2("test")
  person2.sayHello

  /**
    * trait 示例:定义具体字段
    * 此时继承trait的类就自动获得trait中定义的field
    */
  trait Person3 {
    val eyeNum : Int = 2
  }

  class Student(val name : String) extends Person3{
    def sayHello = println("Hi , I'm " + name + " , I have " + eyeNum + "eyes. ")
  }

  /**
    * trait 示例:定义抽象字段
    */
  trait SayHello{
    val msg : String
    def sayHello(name: String) = println(msg + "," + name)
  }

  class Person4(val name : String) extends SayHello{
    val msg : String = "hello"

    def makeFriends(p: Person){
      sayHello(p.name)
      println("I m " + name + ", I want to make friends with you. ")
    }
  }
}