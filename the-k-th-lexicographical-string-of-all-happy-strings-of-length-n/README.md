[<h2>Click here for detailed solution</h2>](https://www.danielleskosky.com/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/)

<h2>1415. The k-th Lexicographical String of All Happy Strings of Length n</h2><h3>Medium</h3><hr><div><p>A <strong>happy string</strong> is a string that:</p>

<ul>
	<li>consists only of letters of the set <code>['a', 'b', 'c']</code>.</li>
	<li><code>s[i] != s[i + 1]</code>&nbsp;for all values of <code>i</code> from <code>1</code> to <code>s.length - 1</code> (string is 1-indexed).</li>
</ul>

<p>For example, strings <strong>"abc", "ac", "b"</strong> and <strong>"abcbabcbcb"</strong> are all happy strings and strings <strong>"aa", "baa"</strong> and&nbsp;<strong>"ababbc"</strong> are not happy strings.</p>

<p>Given two integers <code>n</code> and <code>k</code>, consider a list of all happy strings of length <code>n</code> sorted in lexicographical order.</p>

<p>Return <em>the kth string</em> of this list or return an <strong>empty string</strong>&nbsp;if there are less than <code>k</code> happy strings of length <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> n = 1, k = 3
<strong>Output:</strong> "c"
<strong>Explanation:</strong> The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1, k = 4
<strong>Output:</strong> ""
<strong>Explanation:</strong> There are only 3 happy strings of length 1.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> n = 3, k = 9
<strong>Output:</strong> "cab"
<strong>Explanation:</strong> There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> n = 2, k = 7
<strong>Output:</strong> ""
</pre>

<p><strong>Example 5:</strong></p>

<pre><strong>Input:</strong> n = 10, k = 100
<strong>Output:</strong> "abacbabacb"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10</code></li>
	<li><code>1 &lt;= k &lt;= 100</code></li>
</ul>

<div id="vidyowebrtcscreenshare_is_installed">&nbsp;</div></div>
