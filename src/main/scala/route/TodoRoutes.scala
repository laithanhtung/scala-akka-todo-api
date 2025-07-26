package route

// src/main/scala/route/TodoRoutes.scala

import akka.http.scaladsl.server.Directives._
import model.Todo
import json.TodoJsonProtocol

class TodoRoutes(todos: scala.collection.mutable.Map[Int, Todo])
  extends TodoJsonProtocol {

  val route = pathPrefix("api" / "todos") {
    concat(
      pathEndOrSingleSlash {
        get {
          complete(todos.values.toList)
        }
      },
      path(IntNumber) { id =>
        get {
          complete(todos.get(id)) // ✅ Sửa tại đây
        }
      }
      // ... các route khác
    )
  }
}