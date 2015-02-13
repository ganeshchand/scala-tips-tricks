package files

import java.io.File

/**
 * Created by ganeshchand on 2/12/15.
 */
object FilesAndDirectories {

  /**
   * function to return list of Files, ignores directories
   * @param dir
   * @return
   */
  def getListOfFiles(dir: String): List[File] = {
    val d = new File(dir)
    if(d.exists() && d.isDirectory){
      d.listFiles().filter(_.isFile).toList
    }else List[File]() // empty List
  }

  /**
   * function to get list of Files based on the given file extension
   * @param dir
   * @param extensions
   * @return
   */
  def getListOfFiles(dir: String, extensions: List[String]): List[File] = {
    val d = new File(dir)
    if(d.exists() && d.isDirectory){
      d.listFiles().filter(_.isFile).toList.filter(file => extensions.exists(file.getName.endsWith(_)))
    }else List[File]()

  }

  def main(args: Array[String]) {

    val oKFileExtensions = List("scala", "xml")
    val files = getListOfFiles("/Users/ganeshchand/temp/scala-scripts", oKFileExtensions)

    files.foreach(println)

  }

}
