
# Superqueens puzzle

Consider a modified chess piece that can move like a queen, but also like a knight. We will call such a piece a “superqueen” (it is also known as an “amazon”). This leads to a new “superqueens” puzzle. We formulate the puzzle as a constraint optimization problem: each row and each column can have at most one superqueen (that’s a hard constraint), and we try to minimize the number of pairs of superqueens that attack each other (either diagonally or with a knight’s move). 

## Sample Input

```
Please enter the size of the board (n >= 4): 4
```

## Sample output
```
A* Search
Initial Board:
3       3       3       1
_       _       _       Q

_       _       _       _

Q       Q       Q       _

_       _       _       _

Final Board:
3       1       4       2
_       Q       _       _

_       _       _       Q

Q       _       _       _

_       _       Q       _

No. of conflicts: 4
```
