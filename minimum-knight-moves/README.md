<h2>1197. Minimum Knight Moves</h2><h3>Medium</h3><hr><div><p>In an <strong>infinite</strong> chess board with coordinates from <code>-infinity</code>&nbsp;to <code>+infinity</code>, you have a <strong>knight</strong> at square&nbsp;<code>[0, 0]</code>.</p>

<p>A&nbsp;knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.</p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/knight.png" style="height: 200px; width: 200px;"></p>

<p>Return the&nbsp;minimum number of steps needed to move the knight to the square <code>[x, y]</code>.&nbsp; It is guaranteed the answer exists.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2, y = 1
<strong>Output:</strong> 1
<strong>Explanation: </strong>[0, 0] → [2, 1]
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> x = 5, y = 5
<strong>Output:</strong> 4
<strong>Explanation: </strong>[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>|x| + |y| &lt;= 300</code></li>
</ul>
</div>