<h2>1509. Minimum Difference Between Largest and Smallest Value in Three Moves</h2><h3>Medium</h3><hr><div><p>Given an array <code>nums</code>, you are allowed to choose one element of <code>nums</code> and change it by any&nbsp;value in one move.</p>

<p>Return the minimum difference between the largest and smallest value of <code>nums</code>&nbsp;after perfoming at most 3 moves.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [5,3,2,4]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Change the array [5,3,2,4] to [<strong>2</strong>,<strong>2</strong>,2,<strong>2</strong>].
The difference between the maximum and minimum is 2-2 = 0.</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,0,10,14]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Change the array [1,5,0,10,14] to [1,<strong>1</strong>,0,<strong>1</strong>,<strong>1</strong>]. 
The difference between the maximum and minimum is 1-0 = 1.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [6,6,0,1,1,4,6]
<strong>Output:</strong> 2
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,6,14,15]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10^5</code></li>
	<li><code>-10^9 &lt;= nums[i] &lt;= 10^9</code></li>
</ul></div>