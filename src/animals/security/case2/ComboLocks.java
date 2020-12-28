package animals.security.case2;

import java.util.HashMap;
import java.util.Map;

public class ComboLocks {
    //limiting accessibility
    private Map<String, String> combos;

    public ComboLocks() {
        combos = new HashMap<>();
        combos.put("grasshopper", "123456");
    }

    public boolean isComboValid(String animal, String combo) {
        var correctCombo = combos.get(animal);
        return combo.equals(correctCombo);
    }
}
