class Sample {
  var b=0;
}
object Sample1 {
  def main(args: Array[String]) {
    var test = new Sample()
    var a = new Array[Int](3)
    a(0) = 1
    a(1) = 2
    a(0) = 2
    println(a(0))
    test.b=2
    println(test.b)
  }
}

