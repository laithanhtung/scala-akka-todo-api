// project/plugins.sbt

// Thêm resolver chính thức
resolvers += "sbt-plugin-releases" at "https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases"

// ✅ Dùng phiên bản hợp lệ và mới nhất
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.1")