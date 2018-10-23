import org.scalatest._


class TestGraphing extends FlatSpec with DiagrammedAssertions{
  private val graphing = Graphing


  "getGraphData" should "グラフからほしいデータを取得できる" in {
    val mess:String = graphing.getEdgeData(src = 310L, dst = 320L)._1

    assert(mess === "310_to_320")
  }

  "getCallableNodes" should "スタート地点の設定のためにノードを探せる" in {
    assert(graphing.getCallableNodes.contains(310L))
  }

  "graphCallableNodes" should "接続されてるノードが見られる" in {
    assert(graphing.getCallableNodes(310L).contains(320L))
    assert(graphing.getCallableNodes(310L).contains(340L))
    assert(!graphing.getCallableNodes(310L).contains(350L))  // 350にはつながってないはず
  }

  "updateProb" should "EdgeのProbを変えられる" in {
    graphing.updateProb(310L, 320L, 0.8F)
    assert(graphing.getEdgeData(src = 310L, dst = 320L)._2 === 0.8f)
  }

  "setup" should "NodeやEdgeを作れる" in {
    graphing.setup(
      node=Array(
        (310L,"3F1"),
        (320L,"3F2"),
        (330L,"3F3"),
        (340L,"3F4")
      ),
      edge=Array(
        (310L, 320L),
        (310L, 330L),
        (310L, 340L),
        (320L, 330L)
      )
    )
    println(graphing.getNodes.collect.toList.toString)

    assert(graphing.getCallableNodes.contains(310L))
    assert(graphing.getCallableNodes(310L).contains(320L))
    assert(!graphing.getCallableNodes(310L).contains(350L))  // 350にはつながってないはず

    graphing.updateProb(310L, 320L, 0.8F)
    assert(graphing.getEdgeData(src = 310L, dst = 320L)._2 === 0.8f)
  }
}
