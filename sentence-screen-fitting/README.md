<h2>418. Sentence Screen Fitting</h2><h3>Medium</h3><hr><div><p>Given a&nbsp;<code>rows x cols</code> screen and a <code>sentence</code> represented as a list of strings, return <em>the number of&nbsp;times the given sentence can be fitted on the screen</em>.</p>

<p>The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive words in a line.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> sentence = ["hello","world"], rows = 2, cols = 8
<strong>Output:</strong> 1
<strong>Explanation:</strong>
hello---
world---
The character '-' signifies an empty space on the screen.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> sentence = ["a", "bcd", "e"], rows = 3, cols = 6
<strong>Output:</strong> 2
<strong>Explanation:</strong>
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> sentence = ["i","had","apple","pie"], rows = 4, cols = 5
<strong>Output:</strong> 1
<strong>Explanation:</strong>
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= sentence.length &lt;= 100</code></li>
	<li><code>1 &lt;= sentence[i].length &lt;= 10</code></li>
	<li><code>sentence[i]</code> consists of lowercase English letters.</li>
	<li><code>1 &lt;= rows, cols &lt;= 2 * 10<sup>4</sup></code></li>
</ul>
</div>