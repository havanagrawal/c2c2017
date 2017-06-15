# Session 9

## Table of Contents
1. [The Collections Framework - Part II](#cfw)
    1. [Maps!](#maps)
    3. [Problems](#cfwproblems)
2. [Graphs](#graphs)
    1. [Applications](#applications)
    2. [Classification](#classification)
    3. [Representation](#representation)
    4. [Terminology](#terminology)
    5. [Traversals and Algorithms](#traversals)
    6. [Problems](#problems)
    7. [An Extensive List of Graph Topics](#gfg-graphs)
3. [Assignments](#assignments)
    1. [HackerRank](#hackerrank)
    2. [Miscellaneous](#miscellaneous)

### <a name="cfw"></a>The Collections Framework - Part 2

### <a name="graphs"></a>Graphs
A graph is a set of finite set of vertices, along with edges that connect these vertices.

Graphs are a vast topic, with dozens of algorithms that can be performed on them.

#### <a name="applications"></a>Applications

1. Social Networks
2. Geographical Data (Google Maps, Air Navigation Routes)
3. Networking (Routers, Switches, Hubs)
4. Databases (Neo4J)
5. Web Scraping (PageRank)
6. Gaming (Path solving)

#### <a name="classification"></a>Classification

Graphs can be categorized on the basis of
1. Weightedness
    1. Unweighted - All edges have the same weight / unit weight.
    2. Weighted - Each edge can have a different weight.
2. Directedness
    1. Undirected - If u is reachable from v, then vice versa is also true.
    2. Directed - If u is reachable from v, then v may or may not be reachable from u, i.e. each edge has a direction.

#### <a name="representation"></a>Representation

Graphs can be represented either by means of

1. Adjacency Matrix - A 2D matrix that holds the weight from every ith vertex to every jth vertex. Infinity implies the vertices are not connected.  
```java
class Graph {
    int[][] adjacencyMatrix;

    public boolean isAdjacent(int u, int v) {
        return adjacencyMatrix[u][v] != Integer.MAX_VALUE;
    }

    ...
}
```

2. Adjacency Lists - Each Vertex maintains a list of its adjacent vertices  
```java
class Vertex {
    Set<Vertex> neighbors;

    public Set<Vertex> getAdjacentVertices() {
        return new HashSet<>(neighbors);
    }
}

class Graph {
    Set<Vertex> allVertices;

    public boolean isAdjacent(Vertex u, Vertex v) {
        return u.getAdjacentVertices().contains(v);
    }
}
```

#### <a name="terminology"></a>Terminology

1. Indegree - The number of vertices from which this vertex is reachable
2. Outdegree - The number of vertices reachable from this vertex

#### <a name="traversals"></a>Traversals

1. Breadth First Search

   This is typically used to find the shortest path from one node to another, or to search for a particular node.
   ```
   
   ```
