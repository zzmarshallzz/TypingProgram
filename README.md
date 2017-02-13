# TypingProgram

This is a typing program I created that has 3 classes (AppStart, GUI and WordList)

Stuff used:
Interfaces (KeyListener)
Arrays
ArrayLists
if...else if...
(Nested) if...else if...
methods
(Nested) methods
constructor initializing and kicking off the method to execute the logic.
Casting/Converting Long to String datatype.


It took me a couple of hours to figure out how to sync things when entering key strokes when prompted.  

Issue:
Sometimes the application would give a message that you did not type the correct letter, when in fact you did.
Solution:
Add counters to use as to compare values.


Issue:
When completing the next to last word, it would immediately say you completed typing all the words and would not let you attempt the last word.
Solution:
In the checkFinish() AND checkNoNewNumbers() methods, made sure i was specific in my arguments in the "if" statements.




Things I am unsure about:
Creating random counter variables, maybe a better way to do it.
Not using enough methods.
Too many nest if else statements.

Bugs:
Cannot start a new session
After entering first letter of the word, it says you typed incorrectly even though it may be correct.
