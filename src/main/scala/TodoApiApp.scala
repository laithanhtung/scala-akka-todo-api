// src/main/scala/TodoApiApp.scala

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import model.Todo
import route.TodoRoutes
import scala.io.StdIn
import scala.util.{Success, Failure}
import scala.concurrent.Await
import scala.concurrent.duration._

object TodoApiApp extends App {
  implicit val system: ActorSystem = ActorSystem("TodoApi")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  // Dữ liệu tạm thời
  val todos = scala.collection.mutable.Map(
    1 -> Todo(1, "Học Scala", true)
  )

  // Tạo route
  val routes = new TodoRoutes(todos).route

  // Khởi động server + xử lý lỗi
  val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(routes)

  bindingFuture.onComplete {
    case Success(binding) =>
      println("Server đang chạy tại http://0.0.0.0:8080/api/todos")
      println("Nhấn Enter để dừng server...")
      StdIn.readLine()

      println("Đang dừng server...")
      Await.ready(binding.unbind(), 3.seconds)
      println("Server đã dừng.")
      system.terminate()

    case Failure(exception) =>
      println(s"❌ Không thể khởi động server: ${exception.getMessage}")
      exception.printStackTrace()
      system.terminate()
      sys.exit(1)
  }
}