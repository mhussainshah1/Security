package animals.security.case1;

import java.util.HashMap;
import java.util.Map;

public class ComboLocks {
    public Map<String, String> combos;

    public ComboLocks() {
        combos = new HashMap<>();
        combos.put("grasshopper", "123456");
    }

}
