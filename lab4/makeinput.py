import random
import sys
intFrom = int(sys.argv[1]) 
intTo = int(sys.argv[2])
total = int(sys.argv[3])
type= int(sys.argv[4])
List=[]
count = 0
if (type == 9): 
    test = open("unsorted.txt", "w")
    facit = open("funsorted.txt", "w")
    test.write("%s\n"%total)
    while (count < total):
        ran = random.randint(intFrom,intTo)
        test.write("%s\n"%str(ran))
        List.insert(count,ran)
        count = count + 1
if (type == 1):
    test = open("same.txt", "w")
    facit = open("fsame.txt", "w")
    test.write("%s\n"%total)
    ran = random.randint(intFrom, intTo)
    while(count < total):
        test.write("%s\n"%str(ran))
        List.insert(count,ran)
        count = count + 1
if (type == 3):
    test = open("mfront.txt", "w")
    facit = open("fmfront.txt", "w")
    test.write("%s\n"%total)
    while (count < total):
        ran = random.randint(intFrom,intTo)
        List.insert(count,ran)
        count = count + 1
    List.sort()
    listtemp = List
    beginning = List.pop(0)
    print(List)
    y = 0
    while(List[y] != ''):
        test.write("%s\n"%List[y])
        y = y + 1
    test.write("%s\n"%beginning)
    List = listtemp
    facit.write("%s\n"%beginning)
if (type == 2):
    test = open("incHill.txt", "w")
    facit = open("fincHill.txt", "w")
    listtemp = []
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
    y = 0
    while(y < total):
        test.write("%s\n"%List[y])
        y = y + 1
    
if (type == 6):
    test = open("midmiss.txt", "w")
    facit = open("fmidmiss.txt", "w")
    test.write("%s\n"%total)

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
        test.write("%s\n"%list[count]
        count = count + 1











List.sort()
x = 0
while(x < total):
    facit.write("%s\n"%List[x])
    x = x + 1
