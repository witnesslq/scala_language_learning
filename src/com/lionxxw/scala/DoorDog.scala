package com.lionxxw.scala

/**
  * @description 网吧门禁
  * @package com.lionxxw.scala
  * @project scala-project
  * @company www.baofoo.com
  * @author wangjian@baofoo.com
  * @date 2016/12/12 11:16
  * @version 1.0.0
  */

object DoorDog extends  App{
  var name = readLine("Please show your name!")
  println("welcome " + name)
  println("Please show your age!")
  var age = readInt();
  if (age > 18){
    printf("Hey %s, High up now, because of you have %d years old", name, age)
  }else{
    printf("Sorry, %s is only %d years old", name, age)
  }
}
