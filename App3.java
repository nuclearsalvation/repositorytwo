import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;

public class App3{
    public static void main(String[] args) {
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        HashMap<Integer,String> intKey = new HashMap<>();
        intKey.put(1, "name");
        intKey.put(2, "memory");
        intKey.put(3, "ram");
        intKey.put(4, "color");
        HashSet<Notebook> noteSet = new HashSet<>();
        Notebook note1 = new Notebook();
        note1.name = "First notebook";
        note1.color = "blue";
        Notebook note2 = new Notebook();
        note2.name = "Another notebook";
        note1.memory = 500;
        note2.memory = 600;
        note2.color = "yellow";
        note1.ram = 4;
        note2.ram = 8;
        Notebook note3 = new Notebook();
        note3.memory = 750;
        note3.name = "Just another notebook";
        note3.color = "white";
        note3.ram = 16;
        Notebook note4 = new Notebook();
        note4.name = "Last notebook";
        note4.memory = 2000;
        note4.ram = 64;
        note4.color = "black";
        noteSet.add(note1);
        noteSet.add(note2);
        noteSet.add(note3);
        noteSet.add(note4);
        HashSet<Notebook> noteSet2 = new HashSet<>();
        noteSet2 = noteSet;
        while(flag){
            System.out.println("Введите цифру, соответствующую критерию");
            System.out.println("0 -- выйти из программы");
            System.out.println("1 -- поиск по названию");
            System.out.println("2 -- поиск по объёму жёсткого диска");
            System.out.println("3 -- поиск по объёму оперативной памяти");
            System.out.println("4 -- поиск по цвету");
            System.out.println("5 -- вывести проходящие по условиям");
            Integer num = in.nextInt();
            if (num == 0){
                flag = false;
            }
            else{
                if (num == 1){
                    System.out.println("Введите название");
                    String str = in2.nextLine();
                    noteSet2 = bookSearchString(noteSet2, "name", str);
                }
                else{
                    if (num == 5){
                        for(Notebook bk: noteSet2){
                            System.out.println(bk.toString());
                        }
                    }
                    else{
                        if(num == 2){
                            System.out.println("Введите минимальное значение");
                            Integer min = in2.nextInt();
                            noteSet2 = bookSearchInt(noteSet2, "memory", min);
                        }
                        else{
                            if(num == 3){
                                System.out.println("Введите минимальное значение");
                                Integer min = in2.nextInt();
                                noteSet2 = bookSearchInt(noteSet2, "ram", min);
                            }
                            else{
                                if(num == 4){
                                    System.err.println("Введите цвет");
                                    String str = in2.nextLine();
                                    noteSet2 = bookSearchString(noteSet2, "color", str);
                                }
                            }
                        }
                    }
                }
            }

        }
        in.close();
        in2.close();
        
    }
    public static HashSet<Notebook> bookSearchInt(HashSet<Notebook> hashSet, Object field, Integer parameter){
        HashSet<Notebook> hashSetReturned = new HashSet<>();
        for(Notebook bk: hashSet){
            Integer param = (Integer) parameter;
            Integer num = (Integer) bk.toMap().get(field);
            if (num >= param){
                hashSetReturned.add(bk);
            }
        }
        return hashSetReturned;
    }
    public static HashSet<Notebook> bookSearchString(HashSet<Notebook> hashSet, Object field, String parameter){
        HashSet<Notebook> hashSetReturned = new HashSet<>();
        for(Notebook bk: hashSet){
            String param = (String) parameter;
            String str = (String) bk.toMap().get(field);
            if (str.equals(param)){
                hashSetReturned.add(bk);
            }
        }
        return hashSetReturned;
    }
}

class Notebook{
    public Integer id = 0;
    public String name = new String();
    public Integer memory = 0;
    public Integer ram = 0;
    public String color = new String();
    public HashMap<String, Object> toMap(){
        HashMap<String, Object> returnedMap = new HashMap<>();
        returnedMap.put("name", name);
        returnedMap.put("memory", memory);
        returnedMap.put("ram", ram);
        returnedMap.put("color", color);
        return returnedMap;
    }
    public String toString(){
        String string = name + " " + memory.toString() + " " + ram.toString() + " " + color;
        return string;
    }
    public boolean equals(Object o){
        Notebook bk = (Notebook) o;
        if (this.name.equals(bk.name) && this.id.equals(bk.id) && this.ram.equals(bk.ram) && this.color.equals(bk.color) && this.memory.equals(bk.memory)){
            return true;
        } 
        else{
            return false;
        }
    }
    public int hashCode(){
        return this.id;
    }
}