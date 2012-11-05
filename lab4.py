import os
import random
count = 0
Out = open("test.txt", "w")
x = 100000
Out.write("%s\n"%x)
while (count < x):
    Out.write("%s\n"%str(random.randint(0,1000000)))
    count = count + 1
