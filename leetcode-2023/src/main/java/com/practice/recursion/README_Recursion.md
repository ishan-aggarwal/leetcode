* Recursion

**Parameterized Recursion**
When we don't want our recursive function to return anything
and want to perform the computation as part of recursive function call itself
For example,
sum of first N natural numbers
f(n, sum)
-> f(n - 1, n + sum), n >= 1
-> print(sum), n < 1

**Functional Recursion**
When we want our recursive function to return some result.
Let's say we want to calculate the sum of first n natural numbers
f(n)    
-> n + f(n-1) when n > 0
-> n when n = 0

**Tail Recursion**
Where we have the recursive function call as the last statement in function.
It also reduces the chances of stack overflow error

**Back-tracking**
If we have some statements written after the function call then those statements would get executed at the last of
recursion. It means when the function call gets returned after doing its work.
This is nothing but backtracking

**All Kind of Patterns in Recursion | Print All | Print one | Count**
Print All: Parameter wise.
Print One: return T|F and avoid further recursion calls if you get True.
Count: return 1|0 and add all f()'s and return the total.
