package com.monovore.example.decline

import cats.implicits._
import com.monovore.decline._

object ListDir extends CommandApp(
  name = "ls",
  header = "List information about files.",
  main = {

    val color =
      Opts.optional[String]("color", metavar = "when", help = "colorize the output: 'always', 'auto', or 'never'")
        .withDefault("always")

    val humanReadable = Opts.flag("human-readable", "print human readable sizes")

    val directory = Opts.remainingArgs[String]("directory")

    (color |@| humanReadable |@| directory).map { (color, humanReadable, directory) =>

      println("Color: "  + color)
      println("Human readable: "  + humanReadable)
      println("Dir: " + directory)
    }
  }
)