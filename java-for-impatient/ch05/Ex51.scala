package com.progscala3.ex51

import point.*

package point:
  case class Point(protected val x: Double, protected val y: Double):
    def getX: Double = this.x
    def getY: Double = this.y
  object Point:
    def origin: Point = Point(0, 0)

  abstract class Shape(private var point: Point):

    def moveBy(dx: Double, dy: Double): Unit =
      point = Point(point.getX + dx, point.getY + dy)

    def getCenter(): Point

  class Circle(point: Point, val radius: Double) extends Shape(point):
    def getCenter(): Point = Point(
      Math.sqrt(point.getX * this.radius),
      Math.sqrt(point.getY * this.radius)
    )

@main def main(args: String*): Unit =
  val p = Point(120, 80);
  println(p);
  val circle = Circle(p, 20);
  circle.moveBy(1, 0);
  println(circle.getCenter());
