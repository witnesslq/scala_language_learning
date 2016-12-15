package com.lionxxw.scala

/**
  * @description 练习隐式转换
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/15 10:31
  * @version 1.0.0
  */

object ImplicitTest extends App{

  /**
    * 隐式转换函数,只要在编程的程序内引入,就会被scala自动使用.
    * scala会根据隐式转换函数的签名,在程序中使用到隐式转换函数接收的参数类型定义的对象时,
    * 会自动将其传入隐式转换函数,转换为另外一种类型的对象并返回.
    *
    * 隐式转换函数叫什么名字是无所谓的,因为是由scala进行调用.建议命名格式为"one2one"的形式
    *
    * 隐式转换函数与普通函数的区别:
    *   以implicit开头,而且最好要定义好函数返回类型
    * @param obj
    * @return
    */
  implicit def object2SpecialPerson(obj: Object): SpecialPerson ={
    if(obj.getClass == classOf[Older]){
      val older = obj.asInstanceOf[Older]

      val name = older.name

      new SpecialPerson(name)
    }else{
      new SpecialPerson("None")
    }
  }

  var ticketNumber = 0

  def buySpecialPerson(person: SpecialPerson)={
    if (!"None".equals(person.name)){
      println("特殊人群售票通道打开")
      ticketNumber +=1
      "T- " + ticketNumber
    }else{
      println("售票暂未开放")
    }
  }
  buySpecialPerson(new Older("older"))
  buySpecialPerson(new Student("student"))

  implicit def man2SuperMan(man: Man): SuperMan = {
    new SuperMan(man.name)
  }

  var man = new Man("lionxxw")
  man.emitLaser

  /**
    * 隐式参数,指的是在函数或者方法中,定义一个用implicit修饰的参数
    */
  implicit var pen = new SignPen  // 需先声明一个隐式变量
  def signForExam(name: String)(implicit signPen: SignPen): Unit ={
    pen.write(name+" sign on Exam")
  }

  signForExam("lionxxw")

}
class SpecialPerson(val name : String)

class Student(val name: String)

class Older(val name : String)

class Man(val name: String)

class SuperMan(val name: String){
  def emitLaser = println(name +" emit a laser")
}

/**
  * 签到笔
  */
class SignPen{
  def write(context: String) = println(context)
}