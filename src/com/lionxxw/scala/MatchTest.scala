package com.lionxxw.scala

import java.io.{FileNotFoundException, IOException}


/**
  * @description scala模式匹配学习
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/14 10:13
  * @version 1.0.0
  */

object MatchTest extends App{
  /**
    * 练习:模式匹配-->值
    * 根据卡的级别输出对应的信息,不区分大小写
    * @param grade  卡片级别
    * @param isRMB 是否为人民玩家
    */
    def cardGrade(grade: String, isRMB: Boolean): Unit ={
      grade.toUpperCase() match {
        case "SSR" if isRMB => println("土豪你值得拥有,去制裁那帮渣渣")   // 可加if守卫,进行双重过滤
        case "SSR" => println("成功脱非入欧")
        case "SR" if isRMB => println("土豪别生气,SR也是很牛逼的.快去刷军火,还是可以虐死那帮渣渣")
        case "SR" => println("个别SR类SSR值得入手,如:鸟姐")
        case "R" if isRMB => println("土豪只有御魂好.都说是可以玩套路的,用R卡虐SSR是不是更有成就感")
        case "R" => println("土豪斗技套路搭配,非洲人象征")
        case "N" if isRMB => println("土豪如果连抽500不出SSR.我们会送月见黑头像框,这可是极品象征,别人没有就你有,才显出您的尊贵")
        case "N" => println("狗粮")
        case _arg if isRMB => println("土豪,你好像输入错误了!!!你的输入:"+_arg)
        case _arg => println("瞅瞅你输入的啥?"+_arg)   //可以将模式匹配的默认情况下划线,替换为一个变量名,此时模式匹配语法就会将要匹配的值赋值给这个变量
        //case _  => println("对不起.没有找到你的卡片")    // 类似于java switch中default
      }
    }

  cardGrade("sr", true)
  cardGrade("xx", false)
  cardGrade("sb", true)

  /**
    * 练习:模式匹配-->类型
    * 针对不同异常进行不同的输出
    * @param e
    */
  def processException(e: Exception): Unit ={
    e match {
      case e1: IllegalArgumentException => println("参数异常是:"+e1)
      case e2: FileNotFoundException => println("文件没有找到异常是:"+e2)
      case e3: IOException => println("io 异常:"+e3)
      case _: Exception => println("不可知异常")
    }
  }

  processException(new IndexOutOfBoundsException())

  /**
    * scala 模式匹配-->Array
    * @param arr
    */
  def greeting(arr: Array[String]): Unit ={
    arr match {
      case Array("Leo") => println("hi, Leo!")
      case Array("Leo",_*) => println("Hi, Leo, Are they your friends?")
      case Array(arg0, arg1, arg2) => println("we are your friends, "+ arg0 + ", " + arg1 + ", " + arg2)
      case _ => println("unknown!")
    }
  }

  greeting(Array("Leo"))
  greeting(Array("Leo", "mark", "fimi"))
  greeting(Array("xxx", "mark", "fimi"))
  greeting(Array("xxx", "mark", "fimi","sb"))


  /**
    * scala 模式匹配-->List
    * @param list
    */
  def greeting(list: List[String]): Unit ={
    list match{
      case "Leo"::Nil =>  println("hi, Leo!")
      case "Leo"::tail => println("Hi, Leo, Are they your friends?")
      case arg0::arg1::arg2::Nil => println("we are your friends, "+ arg0 + ", " + arg1 + ", " + arg2)
      case _ => println("unknown!")
    }
  }
  greeting(List("Leo"))
  greeting(List("Leo", "mark", "fimi"))
  greeting(List("xxx", "mark", "fimi"))
  greeting(List("xxx", "mark", "fimi","sb"))

  /**
    * scala 模式匹配-->Tuple
    * @param tuple
    */
  def match_tuple(tuple: Any): Unit ={
    tuple match {
      case ("Leo") =>  println("hi, Leo!")
      case ("Leo",_) => println("Hi, Leo, Are they your friends?")  // 该条件tuple只匹配以Leo开头2个元素的tuple
      case (arg0,arg1,arg2) => println("we are your friends, "+ arg0 + ", " + arg1 + ", " + arg2)
      case _ => println("unknown!")
    }
  }

  match_tuple(("Leo"))
  match_tuple(("Leo", "mark"))
  match_tuple(("xxx", "mark", "fimi"))
  match_tuple(("xxx", "mark", "fimi","sb"))

  /**
    * 模式匹配-->case class
    * @param person
    */
  def judgeIdentify(person: Person2): Unit ={
    person match {
      case Teacher(name , subject) => println(name + "," + subject)
      case Student2(name, classroom) => println(name + "," + classroom)
      case _ => println("============================")
    }
  }

  var p1 = Teacher("beifeng","Scala")
  var p2 = Student2("zhangsan", "1#101")
  judgeIdentify(p1)

}

class Person2
case class Teacher(name: String , subject: String) extends Person2
case class Student2(name: String , classroom: String) extends Person2
