import random
import sys
intFrom = int(sys.argv[1]) 
intTo = int(sys.argv[2])
total = int(sys.argv[3])
List=[]
count = 0
test = open("1.txt", "w")
facit = open("f1.txt", "w")
test.write("%s\n"%total)
ran = random.randint(intFrom, intTo)
while(count < total):
    test.write("%s\n"%str(ran))
    List.insert(count,ran)
    count = count + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1

test = open("2.txt", "w")
facit = open("f2.txt", "w")
listtemp = []
List = []
test.write("%s\n"%total)
count = 0
while (count < ((total/2)+(total % 2))):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
count = 0
while (count < (total/2)):
    ran = random.randint(intFrom,intTo)
    listtemp.insert(count,ran)
    count = count + 1        
List.sort()
listtemp.sort()
List = List + listtemp
y = 0
while(y < total):
    test.write("%s\n"%List[y])
    y = y + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1

test = open("3.txt", "w")
facit = open("f3.txt", "w")
List = []
test.write("%s\n"%total)
count = 0
while (count < total):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
List.sort()

beginning = List.pop(0)
List.append(beginning)
y = 0
while(y < total):
    test.write("%s\n"%List[y])
    y = y + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1

test = open("4.txt", "w")
facit = open("f4.txt", "w")

test.write("%s\n"%total)
y = 0
while(count < total):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
List.sort()
count = 0
while(count < total):
    test.write("%s\n"%List[count])
    count = count + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1

test = open("5.txt", "w")
facit = open("f5.txt", "w")
List = []
listtemp = []
count = 0
test.write("%s\n"%total)
while (count < ((total/2)+(total % 2))):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
count = 0
while (count < (total/2)):
    ran = random.randint(intFrom,intTo)
    listtemp.insert(count,ran)
    count = count + 1        
List.sort()
listtemp.sort()
List = List + listtemp
List.reverse()
y = 0
while(y < total):
    test.write("%s\n"%List[y])
    y = y + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1

test = open("6.txt", "w")
facit = open("f6.txt", "w")
List = []
test.write("%s\n"%total)
count = 0
while(count < total):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
List.sort()
mitten = total/2
mitten = List.pop(mitten)
List.append(mitten)
count = 0
while(count < total):
    test.write("%s\n"%List[count])
    count = count + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1

test = open("7.txt", "w")
facit = open("f7.txt", "w")

test.write("%s\n"%total)
y = 0
while(count < total):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
List.sort()
List.reverse()
count = 0
while(count < total):
    test.write("%s\n"%List[count])
    count = count + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1
    
test = open("8.txt", "w")
facit = open("f8.txt", "w")

listtemp = []
List = []
test.write("%s\n"%total)
count = 0
while (count < ((total/2)+(total % 2))):
    ran = random.randint(intFrom,intTo)
    List.insert(count,ran)
    count = count + 1
count = 0
while (count < (total/2)):
    ran = random.randint(intFrom,intTo)
    listtemp.insert(count,ran)
    count = count + 1        
List.sort()
listtemp.sort()
listtemp.reverse()
List = List + listtemp
y = 0
while(y < total):
    test.write("%s\n"%List[y])
    y = y + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1    
test = open("9.txt", "w")
facit = open("f9.txt", "w")
count = 0
List = []
test.write("%s\n"%total)
while (count < total):
    ran = random.randint(intFrom,intTo)
    test.write("%s\n"%str(ran))
    List.insert(count,ran)
    count = count + 1
List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1
