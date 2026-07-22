package com.progscala3.practiceinterface

trait IntSequence:
  def hasNext: Boolean = true
  def next: Int;

package calculate:
  def getAverage(seq: IntSequence, count: Int): Double =
    var counter = 0
    var sum: Double = 0
    while seq.hasNext && counter < count do
      sum += seq.next
      counter += 1
    sum / counter

package otherClasses:
  class SquareSequence(var number: Int = 0) extends IntSequence:
    override def next: Int =
      number += 1
      number * number

  class DigitSequence(var number: Int) extends IntSequence:
    override def hasNext: Boolean = number != 0
    override def next: Int =
      val result = number % 10
      number /= 10
      result

@main def main(args: String*): Unit =
  import otherClasses.*
  import calculate.*

  val intSeq = SquareSequence()
  println(getAverage(intSeq, 100))
  //
  val digSeq = new DigitSequence(1978);
  val digAvg = getAverage(digSeq, 100);
  println(digAvg);
