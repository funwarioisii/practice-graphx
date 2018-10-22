import org.scalatest._


class TestGraphing extends FlatSpec with DiagrammedAssertions{
  val graphing = Graphing


  "getGraphData" should "グラフからほしいデータを取得できる" in {
    val mess = graphing.getGraphData(310L, 320L)

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
}
