package com.progscala3.ex58

package colors:
  enum Color(val red: Boolean, val green: Boolean, val blue: Boolean):
    case Black extends Color(false, false, false)
    case White extends Color(true, true, true)
    case Red extends Color(true, false, false)
    case Green extends Color(false, true, false)
    case Blue extends Color(false, false, true)
    case Cyan extends Color(false, true, true)
    case Magenta extends Color(true, false, true)
    case Yellow extends Color(true, true, false)

    def getRed: Boolean = red
    def getGreen: Boolean = green
    def getBlue: Boolean = blue

@main def main(args: String*): Unit =
  import colors.*

  val c = Color.Red
  println(c.getRed)
