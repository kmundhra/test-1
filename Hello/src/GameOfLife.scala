import scala.collection.mutable.ListBuffer
import scala.io.StdIn._
import util.control.Breaks._
class universe(aliveCellsList:List[(Int,Int)]){
  private val grid = Array.ofDim[Boolean](5,5)
  def initialize(): Unit ={
    for(i <- 0 to 4){
      for(j <- 0 to 4){
        if (aliveCellsList.contains((i,j))) grid(i)(j)=true
        else grid(i)(j)=false
      }
    }
  }
  private def countAliveNeighbours(xCoordinate:Int, yCoordinate:Int): Int ={
    var count=0
    for(i <- xCoordinate-1 to xCoordinate+1){
      for(j <- yCoordinate-1 to yCoordinate+1){
        breakable {
          if (i < 0 || i >= this.grid.length || j < 0 || j >= this.grid(0).length) break
          if ((this.grid(i)(j) != true) || (i == xCoordinate && j == yCoordinate)) break
          count+=1
        }
      }
    }
    return count
  }
  def tickTransition(): universe ={
    val temp=new universe(List())
    for(i <- 0 to this.grid.length-1){
      for(j <- 0 to this.grid(0).length-1){
        val aliveCountOfNeighbours = this.countAliveNeighbours(i, j)
        if(aliveCountOfNeighbours < 2) temp.grid(i)(j)=false
        else if (aliveCountOfNeighbours > 3) temp.grid(i)(j) = false
        else if (aliveCountOfNeighbours == 3) temp.grid(i)(j) = true
        else temp.grid(i)(j) = this.grid(i)(j)
      }
    }
    return temp
  }
  def isAlive(xCoordinate:Int, yCoordinate:Int): Boolean ={
    if(grid(xCoordinate)(yCoordinate)==true) return true
    return false
  }
}
object GameOfLife {
  def main(args: Array[String]): Unit = {
    println("Enter the number of alive cells in the seed")
    var noOfLiveCells = readInt()
    println("Enter the cordinates of the alive cells one by one")
    var aliveCellsListBuffer = ListBuffer[(Int, Int)]()
    for (i <- 0 to noOfLiveCells - 1) {
      var i = readLine().split(" ").map(_.toInt)
      var t = (i(0), i(1))
      aliveCellsListBuffer += t
    }
    val aliveCellsList = aliveCellsListBuffer.toList
    var seed = new universe(aliveCellsList)
    seed.initialize()
    for(i<- 0 to 4){
      for(j<- 0 to 4){
        if(seed.isAlive(i,j)) print("X ")
        else print("- ")
      }
      println()
    }
    println()
    var nestGenAfterTick = new universe(List())
    nestGenAfterTick.initialize()
    nestGenAfterTick = seed.tickTransition()
    for(i<- 0 to 4){
      for(j<- 0 to 4){
        if(nestGenAfterTick.isAlive(i,j)) print("X ")
        else print("- ")
      }
      println()
    }
    //commit-2 ha-it
  }
}
