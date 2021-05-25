package com.example.salutations

import cats.implicits._

case class Greeting(salutation: String) {
  def greetName(name: String): String = salutation |+| " " |+| name
}
