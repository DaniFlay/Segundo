import time
#Ejercicio 1
for n in range(8):
    print (n)

#Ejercicio2
for n in range(1,13):
    print(n)

#Ejercicio3
time.sleep(1)
for n in range(33):
    print(n)
time.sleep(1)
for n in range(33):
    print(n)
time.sleep(1)
for n in range(33):
    print(n)
    
#Ejercicio4
for n in reversed(range(1,11)):
    print(n)
    time.sleep(1)
print("¡Despegue!")

#Ejercicio5
for x in range(0,3):
    for y in range(0,3):
        print("*",end=" ")
    print("")