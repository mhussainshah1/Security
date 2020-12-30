package io;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Employee implements Serializable {
    //White list

    @Serial
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class),
            new ObjectStreamField("ssn", String.class)
    };
    private static Map<String, Employee> pool = new ConcurrentHashMap<>();
    private String name;
    private String ssn;
    private /*transient*/ int age;//Black list - do not serialize

    // Constructors
    private Employee() {
    }

    public Employee(String name, String ssn, int age) {
        this.name = name;
        this.ssn = ssn;
        this.age = age;
    }

    //getters/setters
    //factory method
    public synchronized static Employee getEmployee(String name) {
        if (pool.get(name) == null) {
            var e = new Employee();
            e.name = name;
            pool.put(name, e);
        }
        return pool.get(name);
    }

    private static String encrypt(String input) {
        // Implementation omitted
        return input;
    }

    private static String decrypt(String input) {
        // Implementation omitted
        return input;
    }

    @Serial
    public Object writeReplace() throws ObjectStreamException {
        System.out.println("Write Replace");
        var e = pool.get(name);
        return e != null ? e : this;
    }

    @Serial
    private void writeObject(ObjectOutputStream s) throws Exception {
        System.out.println("Write Object");
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("name", name);
        fields.put("ssn", encrypt(ssn));
//        fields.put("age", age);
        s.writeFields();
    }

    @Serial
    private void readObject(ObjectInputStream s) throws Exception {
        System.out.println("Read Object");
        ObjectInputStream.GetField fields = s.readFields();
        this.name = (String) fields.get("name", null);
        this.ssn = decrypt((String) fields.get("ssn", null));
    }

    @Serial
    public synchronized Object readResolve() throws ObjectStreamException {
        System.out.println("Read Resolve");
        var existingEmployee = pool.get(name);
        if (pool.get(name) == null) {
            // New employee not in memory
            pool.put(name, this);
            return this;
        } else {// Existing user already in memory
            existingEmployee.name = this.name;
            existingEmployee.ssn = this.ssn;
            return existingEmployee;
        }
    }

    @Override
    public String toString() {
        return "[name=" + name + ", ssn=" + ssn + ", age=" + age + ']';
    }
}