import test.projects

import scala.collection.mutable.ListBuffer

object test extends App{

  val projects = List("a", "b", "c", "d", "e", "f")
  var dependencies : List[(String, String)] = List()

  val depList = ("a" -> "d", "f" -> "b", "b" -> "d", "f" -> "a", "d" -> "c") :: dependencies


  val dep = Map("a" -> "d", "f" -> "b", "b" -> "d", "f" -> "a", "d" -> "c")

  var results = new ListBuffer[String]()

  def noDependencies(projects: List[String], dependencies: Map[String, String]): ListBuffer[String] = {


    var noDep = ListBuffer[String]()
    var count = 0

    for( proj <- projects) {
      for(dep <- dependencies) {
        if(dep._2 == proj || dep._1 == proj) {
          count += 1

        }
      }
      if(count == 0) {
        noDep.append(proj)
        print("Added " + proj)
      }
      count = 0
    }
    return noDep

  }

  def dependeciesCheck(projects: List[String], dependencies: Map[String, String], results: ListBuffer[String]): Unit = {
    for(proj <- projects ) {

      for(depen <- dep) {

        if(proj == depen._2) {



          if(results.contains(depen._1) && !results.contains(proj)) {
            results += proj
          }
        }
      }

      println(results)


    }

  }

  var noDep = noDependencies(projects, dep)

  for(x <- noDep) {
    results.append(x)
  }

  dependeciesCheck(projects, dep, results)

}
