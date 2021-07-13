<h2>1352. Product of the Last K Numbers</h2><h3>Medium</h3><hr><div><p>Implement the class <code>ProductOfNumbers</code>&nbsp;that supports two methods:</p>

<p>1.<code>&nbsp;add(int num)</code></p>

<ul>
	<li>Adds the number <code>num</code> to the back of the current list of numbers.</li>
</ul>

<p>2.<code> getProduct(int k)</code></p>

<ul>
	<li>Returns the product of the last <code>k</code> numbers in the current list.</li>
	<li>You can assume that always the current list has <strong>at least</strong> <code>k</code> numbers.</li>
</ul>

<p>At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.</p>

<p>&nbsp;</p>
<p><strong>Example:</strong></p>

<pre><strong>Input</strong>
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

<strong>Output</strong>
[null,null,null,null,null,null,20,40,0,null,32]

<strong>Explanation</strong>
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>There will be at most <code>40000</code>&nbsp;operations considering both <code>add</code> and <code>getProduct</code>.</li>
	<li><code>0 &lt;= num&nbsp;&lt;=&nbsp;100</code></li>
	<li><code>1 &lt;= k &lt;= 40000</code></li>
</ul>
</div>