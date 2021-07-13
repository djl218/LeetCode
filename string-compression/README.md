<h2>443. String Compression</h2><h3>Medium</h3><hr><div><p>Given an array of characters <code>chars</code>, compress it using the following algorithm:</p>

<p>Begin with an empty string <code>s</code>. For each group of <strong>consecutive repeating characters</strong> in <code>chars</code>:</p>

<ul>
	<li>If the group's length is 1, append the character to&nbsp;<code>s</code>.</li>
	<li>Otherwise, append the character followed by the group's length.</li>
</ul>

<p>The compressed string&nbsp;<code>s</code> <strong>should not be returned separately</strong>, but instead be stored&nbsp;<strong>in the input character array&nbsp;<code>chars</code></strong>. Note that group lengths that are 10 or longer will be split into multiple characters in&nbsp;<code>chars</code>.</p>

<p>After you are done <b>modifying the input array</b>, return <em>the new length of the array</em>.</p>
You must write an algorithm that uses only constant extra space.
<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> chars = ["a","a","b","b","c","c","c"]
<strong>Output:</strong> Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
<strong>Explanation:</strong>&nbsp;The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> chars = ["a"]
<strong>Output:</strong> Return 1, and the first character of the input array should be: ["a"]
<strong>Explanation:</strong>&nbsp;The only group is "a", which remains uncompressed since it's a single character.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
<strong>Output:</strong> Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
<strong>Explanation:</strong>&nbsp;The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> chars = ["a","a","a","b","b","a","a"]
<strong>Output:</strong> Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
<strong>Explanation:</strong>&nbsp;The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= chars.length &lt;= 2000</code></li>
	<li><code>chars[i]</code> is a lower-case English letter, upper-case English letter, digit, or symbol.</li>
</ul>
</div>