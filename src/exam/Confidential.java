package exam;

//Given:

import java.io.*;

public class Confidential implements Serializable {

    private String data;
    @Serial
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("data", String.class)
    };
    @Serial
    private static final long serialVersionUID = 1L;

    public Confidential(String data) {
        this.data = data;
    }

    @Serial
    public Object writeReplace() throws ObjectStreamException { return null;}

    @Serial
    private void writeObject(ObjectOutputStream stream) throws IOException {}

}
   /* Which two secure serialization of the object instance?
        A) Implement only readResolve to replace the instance with a serial proxy and not writeReplace.
        B) Implement writeReplace and readResolve to replace the instance with a serial proxy and construct it back.
        C) Implement writeObject and use ObjectOutputStream.putField selectively.
        D) Make the class abstract.
        E) Implement only writeReplace to replace the instance with a serial proxy and not readResolve.

    Answer C and E

    */