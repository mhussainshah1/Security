package review;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public class Nineteen implements Serializable {

    @Serial
    public Object readResolve() throws ObjectStreamException {
        // return an object
        return new Object();
    }
}
