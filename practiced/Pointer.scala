package com.progscala3.pointer

case class Point(x: Double, y: Double):
  def translate(xVal: Int, yVal: Int): Point = Point(x + xVal, y + yVal)

  def scale(value: Double): Point = Point(x * value, y * value)

class PointCl(x: Double, y: Double):
  def translate(xVal: Int, yVal: Int): PointCl = PointCl(x + xVal, y + yVal)
  def scale(value: Double): PointCl = PointCl(x * value, y * value)
  override def toString: String = s"PointCl(x=$x,y=$y)"

object PointCl:
  def apply(x: Double, y: Double): PointCl = new PointCl(x, y)

@main def main(args: String*): Unit =
  val p = Point(3, 4);
  println(p);
  val pt = Point(3, 4).translate(1, 3).scale(0.5)
  println(pt);
  println(PointCl(3, 4).translate(1, 3).scale(0.5))
