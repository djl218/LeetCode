<h2>417. Pacific Atlantic Water Flow</h2><h3>Medium</h3><hr><div><p>You are given an <code>m x n</code> integer matrix <code>heights</code> representing the height of each unit cell in a continent. The <strong>Pacific ocean</strong> touches the continent's left and top edges, and the A<strong>tlantic ocean</strong> touches the continent's right and bottom edges.</p>

<p>Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent one with an equal or lower height.</p>

<p>Return <em>a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/26/ocean-grid.jpg" style="width: 573px; height: 573px;">
<pre><strong>Input:</strong> heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
<strong>Output:</strong> [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> heights = [[2,1],[1,2]]
<strong>Output:</strong> [[0,0],[0,1],[1,0],[1,1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == heights.length</code></li>
	<li><code>n == heights[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>1 &lt;= heights[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>
</div>