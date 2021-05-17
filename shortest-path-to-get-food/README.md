<h2>1730. Shortest Path to Get Food</h2><h3>Medium</h3><hr><div><p>You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.</p>

<p>You are given an <code>m x n</code> character matrix, <code>grid</code>, of these different types of cells:</p>

<ul>
	<li><code>'*'</code> is your location. There is <strong>exactly one </strong><code>'*'</code> cell.</li>
	<li><code>'#'</code> is a food cell. There may be <strong>multiple</strong> food cells.</li>
	<li><code>'O'</code> is free space, and you can travel through these cells.</li>
	<li><code>'X'</code> is an obstacle, and you cannot travel through these cells.</li>
</ul>

<p>You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.</p>

<p>Return <em>the <strong>length</strong> of the shortest path for you to reach <strong>any</strong> food cell</em>. If there is no path for you to reach food, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/21/img1.jpg" style="width: 300px; height: 201px;">
<pre><strong>Input:</strong> grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> It takes 3 steps to reach the food.
</pre>

<p><strong>Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/21/img2.jpg" style="width: 300px; height: 241px;">
<pre><strong>Input:</strong> grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It is not possible to reach the food.
</pre>

<p><strong>Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/21/img3.jpg" style="width: 300px; height: 188px;">
<pre><strong>Input:</strong> grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> There can be multiple food cells. It only takes 6 steps to reach the bottom food.</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> grid = [["O","*"],["#","O"]]
<strong>Output:</strong> 2
</pre>

<p><strong>Example 5:</strong></p>

<pre><strong>Input:</strong> grid = [["X","*"],["#","X"]]
<strong>Output:</strong> -1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>grid[row][col]</code> is <code>'*'</code>, <code>'X'</code>, <code>'O'</code>, or <code>'#'</code>.</li>
	<li>The <code>grid</code> contains <strong>exactly one</strong> <code>'*'</code>.</li>
</ul>
</div>