package kr.mingling.subway.graph;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DijkstraTest {

    @Test
    @DisplayName("연결된 역들을 순서대로 경로로 반환한다")
    public void success_basicPath() throws Exception {

        // given
        Graph graph = new Graph();
        graph.addEdge("합정", "당산", 180);
        graph.addEdge("당산", "영등포구청", 120);
        graph.addEdge("영등포구청", "문래", 60);

        // when
        PathResult result = Dijkstra.shortestPath(graph, "합정", "문래");

        // then
        assertThat(result.path()).containsExactly("합정", "당산", "영등포구청", "문래");
        assertThat(result.totalTimeSec()).isEqualTo(360);
    }
}