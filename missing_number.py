import random

list_size = random.randint(1,15)
num_list = [i for i in range(list_size)]
num_list.remove(0) # Removing 0
try:
    index_to_remove = random.randint(0, len(num_list)-1)
    num_list.pop(index_to_remove)
except ValueError:
    num_list = [1]
print(num_list) # This is the list with the random number removed

def missing_number_finder():
    if len(num_list) == 0:
        print("The missing number is 1")
        num_list.insert(0, 1)
    else:
        try:
            for i in num_list:
                try:
                    if i + 1 == num_list[num_list.index(i)+1]:
                        continue
                    else:
                        print(f"The missing number is {i+1}")
                        num_list.insert(num_list[i-1], i+1)
                        break
                except IndexError:
                    print(f"The missing number is {num_list[-1]+1}")
                    num_list.append(num_list[-1]+1)
                    break
                except ValueError:
                    print("The missing number is 1")
                    num_list.insert(0, 1)
                    break
        except ValueError:
            print("The missing number is 1")
            num_list.insert(0, 1)
    print(num_list) # Original list with number added back in

missing_number_finder()
