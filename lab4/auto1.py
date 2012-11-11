import os
import time
def compare(x):
    Sorted = open("output.txt", "rw")
    Facit = open(x, "r")
    return (Sorted.read() == Facit.read())
#1 Alla samma
#2 Stigande backar
#3 Saknad front
#4 Stigande
#5 Fallande backar
#6 Saknad mitt
#7 Fallande
#8 Orgel
#9 Slumpvis
passed = 0
failed = 0
total = 0
x = time.time()
os.system("./sort1 < 1.txt > output.txt")
if (compare("f1.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 1.")
    failed = failed + 1
os.system("./sort1 < 2.txt > output.txt")
if (compare("f2.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 2.")
    failed = failed + 1
os.system("./sort1 < 3.txt > output.txt")
if (compare("f3.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 3.")
    failed = failed + 1
os.system("./sort1 < 4.txt > output.txt")
if (compare("f4.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 4.")
    failed = failed + 1
os.system("./sort1 < 5.txt > output.txt")
if (compare("f5.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 5.")
    failed = failed + 1
os.system("./sort1 < 6.txt > output.txt")
if (compare("f6.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 6.")
    failed = failed + 1
os.system("./sort1 < 7.txt > output.txt")
if (compare("f7.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 7.")
    failed = failed + 1
os.system("./sort1 < 8.txt > output.txt")
if (compare("f8.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 8.")
    failed = failed + 1
os.system("./sort1 < 9.txt > output.txt")
if (compare("f9.txt")):
    passed = passed + 1
else:
    print ("sort1 failed 9.")
    failed = failed + 1
print("sort1 time :",time.time()-x)
#######
x = time.time()
os.system("./sort2 < 1.txt > output.txt")
if (compare("f1.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 1.")
    failed = failed + 1
os.system("./sort2 < 2.txt > output.txt")
if (compare("f2.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 2.")
    failed = failed + 1
os.system("./sort2 < 3.txt > output.txt")
if (compare("f3.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 3.")
    failed = failed + 1
os.system("./sort2 < 4.txt > output.txt")
if (compare("f4.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 4.")
    failed = failed + 1
os.system("./sort2 < 5.txt > output.txt")
if (compare("f5.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 5.")
    failed = failed + 1
os.system("./sort2 < 6.txt > output.txt")
if (compare("f6.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 6.")
    failed = failed + 1
os.system("./sort2 < 7.txt > output.txt")
if (compare("f7.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 7.")
    failed = failed + 1
os.system("./sort2 < 8.txt > output.txt")
if (compare("f8.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 8.")
    failed = failed + 1
os.system("./sort2 < 9.txt > output.txt")
if (compare("f9.txt")):
    passed = passed + 1
else:
    print ("sort2 failed 9.")
    failed = failed + 1
print("sort2 time :",time.time()-x)
#######
x = time.time()
os.system("./sort3 < 1.txt > output.txt")
if (compare("f1.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 1.")
    failed = failed + 1
os.system("./sort3 < 2.txt > output.txt")
if (compare("f2.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 2.")
    failed = failed + 1
os.system("./sort3 < 3.txt > output.txt")
if (compare("f3.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 3.")
    failed = failed + 1
os.system("./sort3 < 4.txt > output.txt")
if (compare("f4.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 4.")
    failed = failed + 1
os.system("./sort3 < 5.txt > output.txt")
if (compare("f5.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 5.")
    failed = failed + 1
os.system("./sort3 < 6.txt > output.txt")
if (compare("f6.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 6.")
    failed = failed + 1
os.system("./sort3 < 7.txt > output.txt")
if (compare("f7.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 7.")
    failed = failed + 1
os.system("./sort3 < 8.txt > output.txt")
if (compare("f8.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 8.")
    failed = failed + 1
os.system("./sort3 < 9.txt > output.txt")
if (compare("f9.txt")):
    passed = passed + 1
else:
    print ("sort3 failed 9.")
    failed = failed + 1
print("sort3 time :",time.time()-x)
#######
x = time.time()
os.system("./sort4 < 1.txt > output.txt")
if (compare("f1.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 1.")
    failed = failed + 1
os.system("./sort4 < 2.txt > output.txt")
if (compare("f2.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 2.")
    failed = failed + 1
os.system("./sort4 < 3.txt > output.txt")
if (compare("f3.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 3.")
    failed = failed + 1
os.system("./sort4 < 4.txt > output.txt")
if (compare("f4.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 4.")
    failed = failed + 1
os.system("./sort4 < 5.txt > output.txt")
if (compare("f5.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 5.")
    failed = failed + 1
os.system("./sort4 < 6.txt > output.txt")
if (compare("f6.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 6.")
    failed = failed + 1
os.system("./sort4 < 7.txt > output.txt")
if (compare("f7.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 7.")
    failed = failed + 1
os.system("./sort4 < 8.txt > output.txt")
if (compare("f8.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 8.")
    failed = failed + 1
os.system("./sort4 < 9.txt > output.txt")
if (compare("f9.txt")):
    passed = passed + 1
else:
    print ("sort4 failed 9.")
    failed = failed + 1
print("sort4 time :",time.time()-x)
#######
x = time.time()
os.system("./sort5 < 1.txt > output.txt")
if (compare("f1.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 1.")
    failed = failed + 1
os.system("./sort5 < 2.txt > output.txt")
if (compare("f2.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 2.")
    failed = failed + 1
os.system("./sort5 < 3.txt > output.txt")
if (compare("f3.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 3.")
    failed = failed + 1
os.system("./sort5 < 4.txt > output.txt")
if (compare("f4.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 4.")
    failed = failed + 1
os.system("./sort5 < 5.txt > output.txt")
if (compare("f5.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 5.")
    failed = failed + 1
os.system("./sort5 < 6.txt > output.txt")
if (compare("f6.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 6.")
    failed = failed + 1
os.system("./sort5 < 7.txt > output.txt")
if (compare("f7.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 7.")
    failed = failed + 1
os.system("./sort5 < 8.txt > output.txt")
if (compare("f8.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 8.")
    failed = failed + 1
os.system("./sort5 < 9.txt > output.txt")
if (compare("f9.txt")):
    passed = passed + 1
else:
    print ("sort5 failed 9.")
    failed = failed + 1
print("sort5 time :",time.time()-x)
#######
x = time.time()
os.system("./sort2 < 1.txt > output.txt")
if (compare("f1.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 1.")
    failed = failed + 1
os.system("./sort6 < 2.txt > output.txt")
if (compare("f2.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 2.")
    failed = failed + 1
os.system("./sort6 < 3.txt > output.txt")
if (compare("f3.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 3.")
    failed = failed + 1
os.system("./sort6 < 4.txt > output.txt")
if (compare("f4.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 4.")
    failed = failed + 1
os.system("./sort6 < 5.txt > output.txt")
if (compare("f5.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 5.")
    failed = failed + 1
os.system("./sort6 < 6.txt > output.txt")
if (compare("f6.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 6.")
    failed = failed + 1
os.system("./sort6 < 7.txt > output.txt")
if (compare("f7.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 7.")
    failed = failed + 1
os.system("./sort6 < 8.txt > output.txt")
if (compare("f8.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 8.")
    failed = failed + 1
os.system("./sort6 < 9.txt > output.txt")
if (compare("f9.txt")):
    passed = passed + 1
else:
    print ("sort6 failed 9.")
    failed = failed + 1
print("sort6 time :",time.time()-x)

total = passed + failed

print("\n")
print("Total: %d"%total)
print("Passed: %d"%passed)
print("Failed: %d"%failed)
