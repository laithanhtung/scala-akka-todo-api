package json

// src/main/scala/json/TodoJsonProtocol.scala
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import model.Todo

trait TodoJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val todoFormat = jsonFormat3(Todo)
}