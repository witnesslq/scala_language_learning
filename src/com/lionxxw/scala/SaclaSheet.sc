val stu = Map("wx" -> 20, "gmh" -> 24, "gg" -> 18)

var stu2 = scala.collection.mutable.Map("wx" -> 20, "gmh" -> 24, "gg" -> 18)

stu("wx")

//stu("Wx")

stu.getOrElse("jack", 0)

stu2 += ("make" -> 22, "ss" -> 22)

stu2 -= ("ss")

for ((key,value) <- stu){
  println(key+"\t"+value)
}

for (key <- stu2.keySet){
  println(key)
}

for (value <- stu2.values){
  println(value)
}

