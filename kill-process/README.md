<h2>582. Kill Process</h2><h3>Medium</h3><hr><div><p>You have <code>n</code> processes forming a rooted tree structure. You are given two integer arrays <code>pid</code> and <code>ppid</code>, where <code>pid[i]</code> is the ID of the <code>i<sup>th</sup></code> process and <code>ppid[i]</code> is the ID of the <code>i<sup>th</sup></code> process's parent process.</p>

<p>Each process has only <strong>one parent process</strong> but may have multiple children processes. Only one process has <code>ppid[i] = 0</code>, which means this process has <strong>no parent process</strong> (the root of the tree).</p>

<p>When a process is <strong>killed</strong>, all of its children processes will also be killed.</p>

<p>Given an integer <code>kill</code> representing the ID of a process you want to kill, return <em>a list of the IDs of the processes that will be killed. You may return the answer in <strong>any order</strong>.</em></p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/24/ptree.jpg" style="width: 207px; height: 302px;">
<pre><strong>Input:</strong> pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
<strong>Output:</strong> [5,10]
<strong>Explanation:</strong>&nbsp;The processes colored in red are the processes that should be killed.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> pid = [1], ppid = [0], kill = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == pid.length</code></li>
	<li><code>n == ppid.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= pid[i] &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= ppid[i] &lt;= 5 * 10<sup>4</sup></code></li>
	<li>Only one process has no parent.</li>
	<li>All the values of <code>pid</code> are <strong>unique</strong>.</li>
	<li><code>kill</code> is <strong>guaranteed</strong> to be in <code>pid</code>.</li>
</ul>
</div>