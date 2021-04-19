<h2>695. Max Area of Island</h2><h3>Medium</h3><hr><div><p>Given a non-empty 2D array <code>grid</code> of 0's and 1's, an <b>island</b> is a group of <code>1</code>'s (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.</p>

<p>Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)</p>

<p><b>Example 1:</b></p>

<pre>[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,<b>1</b>,0,<b>1</b>,0,0],
 [0,1,0,0,1,1,0,0,<b>1</b>,<b>1</b>,<b>1</b>,0,0],
 [0,0,0,0,0,0,0,0,0,0,<b>1</b>,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
</pre>
Given the above grid, return <code>6</code>. Note the answer is not 11, because the island must be connected 4-directionally.

<p><b>Example 2:</b></p>

<pre>[[0,0,0,0,0,0,0,0]]</pre>
Given the above grid, return <code>0</code>.

<p><b>Note:</b> The length of each dimension in the given <code>grid</code> does not exceed 50.</p>
</div>