Lab 2
JOSE RAMON ROMERO CHAVEZ
A01700318


            COMPILATION:
            $ javac *.class


            EXECUTION:
            $ java Jardin


INSTRUCTIONS:

After doing this lab you should understand the problems that might arise from
working with several threads, in particular race conditions, and how to avoid them.

Mexico City’s botanical garden is open to the public.
Any person can go in through one of two doors.
  East door and West door.

Management wishes to know how many people are inside the botanical garden at
any given time.  Consider that people can go in and out through either door
at any given time. At the end of the day we expect the people to leave the garden
and we must compare the number of people leaving with the number of people that
entered the garden to check for oddities.

Create a program that represents each door with a thread and provide an accurate
count of the people inside the garden in real time. Use simulation to test the
number of people that go in and out of the garden.

The program should have more than one thread and they should all work on the
same object.

Your threads should receive the number of people that will going in through each door during the day.
The people should stay an number of random milliseconds in the garden and the leave through either door.

Implement the necessary outputs so we know:
how many people are in the garden at any given time,
through which door the come in through which door they go out and
how many are left when the garden closes (this last one should be 0)
