//package com.datastructure;

// Hash Table : key에 data를 매핑할 수 있는 구조
// chaining 기법 사용.
/*
public class MyHash {
    public class Slot {
        String value;
        String key;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Slot[] hashTable;

    public MyHash(Integer size) {
        hashTable = new Slot[size];
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0) % hashTable.length);
    }

    public boolean saveData(String key, String value) {
        Integer address = hashFunc(key);
        if (hashTable[address] != null) {
            Slot findSlot = hashTable[address]; // head
            Slot prevSlot = hashTable[address];
            while(findSlot != null) {
                if(findSlot.key == key) return true;
                else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);
        if ( hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee","01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave","01055556666");
        System.out.println(mainObject.getData("DaveLee"));
        System.out.println(mainObject.getData("Dave"));
    }
}
*/
/*
// Linear probing
package com.datastructure;

// Hash Table : key에 data를 매핑할 수 있는 구조
public class MyHash {
    public class Slot {
        String value;
        String key;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Slot[] hashTable;

    public MyHash(Integer size) {
        hashTable = new Slot[size];
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0) % hashTable.length);
    }

    public boolean saveData(String key, String value) {
        Integer address = hashFunc(key);
        if(this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null) {
                    if(this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if(currAddress == this.hashTable.length) {
                            return false;
                        }
                    }
                }
                hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);
        if(this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) return this.hashTable[address].value;
            Integer currAddress = address + 1;
            while(this.hashTable[currAddress] != null) {
                if(this.hashTable[currAddress].key == key) {
                    return this.hashTable[address].value;
                } else {
                    currAddress++;
                    if(currAddress == this.hashTable.length) {
                        return null;
                    }
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee","01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave","01055556666");
        System.out.println(mainObject.getData("DaveLee"));
        System.out.println(mainObject.getData("fun-coding"));
    }
}
*/


package com.datastructure;
import java.util.HashMap;

public class MyHash {

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap();
        map1.put(1, "사과");
        map1.put(2, "바나나");
        map1.put(3, "포도");
        System.out.println(map1.get(2));
    }
}
