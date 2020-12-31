package review;

import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class AnimalCheckup {
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class)
    };
    private String name;
    private int age;

    private void writeObject(ObjectOutputStream stream) throws Exception {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("name", name);
        stream.writeFields();
    }
// readObject method omitted
}