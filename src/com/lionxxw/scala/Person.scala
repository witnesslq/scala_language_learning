package com.lionxxw.scala

/**
  * 1.主构造器直接跟在类名后面,主构造中的参数最后会被编译成字段/属性
  * 2.主构造器执行时,会执行类中的所有语句
  * 3.假设参数声明时不带val或var,那么相当于private[this],只能在内部使用
  *
  * @description class&object学习
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

  /**
    * 1.附属构造器名称为this
    * 2.每个附属构造器必须首先(第一行)调用已经存在的主构造器或者其他附属构造器
    * @param name
    * @param age
    * @param gender
    */
  def this(name: String, age: Int, gender: String)={
    this(name, age)   // 每个附属构造器必须首先(第一行)调用已经存在的主构造器或者其他附属构造器
    this.gender = gender
  }

  def sayHello = println("Hi " + name + ", I guess you are " + age + "years old, eyeNum = " + Person.eyeNum )

  println("my name is "+name+", i am "+age + " years old"+",sex is "+ gender)

  println("after ........")
}

/**
  * object是class的伴生对象,class是object的伴生类
  * 伴生类和伴生对象必须存放在一个.scala文件中
  * 伴生类和伴生对象,最大特点就是在于,互相可以访问private filed
  */
object Person{
  private val eyeNum = 2
  def getEyeNum = eyeNum

  /**
    * object中非常重要的一个特殊方法,就是apply方法
    * 通常在伴生对象中实现apply方法,并在其中实现构造伴生类的对象的功能.
    * 而创建伴生类的对象时,通常不会使用new Class的方式,而是使用Class()方式,隐式的调用伴生对象的apply方法,这样会让对象创建更加简洁
    * @param name
    * @param age
    * @return
    */
  def apply(name: String, age: Int) = new Person(name, age)

  def main(args: Array[String]): Unit = {
      val person = new Person("lion", 18)
      person.sayHello

      val person2 = Person("lionxxw", 27)// 隐式调用伴生对象的apply方法
      person2.sayHello
  }
}
