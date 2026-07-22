package com.progscala3.pointer

case class Point(x: Double, y: Double):
  def translate(xVal: Int, yVal: Int): Point = Point(x + xVal, y + yVal)

  def scale(value: Double): Point = Point(x * value, y * value)

@main def main(args: String*): Unit =
  val p = Point(3, 4);
  println(p);
  val pt = Point(3, 4).translate(1, 3).scale(0.5);
  println(pt);
