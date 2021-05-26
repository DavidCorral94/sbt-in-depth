package com.example

import cats.effect.{ ExitCode, IO, IOApp }
import com.typesafe.config.ConfigFactory
import com.example.salutations.Greeting

object HelloWorld extends IOApp {

  val config     = ConfigFactory.load() // load the configuration
  val salutation = config.getString("hellosbt.greeting.prefix") // read a config
  val greeter    = Greeting(salutation)

  override def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- IO.unit
      greeting = greeter.greetName("wooooorld")
      _ <- IO(println(greeting))
    } yield ExitCode.Success
}
