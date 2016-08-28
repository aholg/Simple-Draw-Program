# Simple-Draw-Program

Junit framework used to aid in testing everything else is built with standard java library. Decided to go for a more conventional implementation of
the flood fill algorithm to allow larger values. This probably means a speed trade off compared to a recursive solution but it was required to avoid stackoverflow
error with larger values.


Commands:

C w h         Create a new canvas of width w and height h.
L x1 y1 x2 y2 Create a new line from (x1,y1) to (x2,y2). Currently only
              horizontal or vertical lines are supported. Horizontal and vertical lines
              will be drawn using the 'x' character.
R x1 y1 x2 y2 Create a new rectangle, whose upper left corner is (x1,y1) and
              lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
              using the 'x' character.
B x y c       Fill the entire area connected to (x,y) with "colour" c. The
              behaviour of this is the same as that of the "bucket fill" tool in paint
              programs.
Q             Quit the program.

