package ProductExchangeService.domain;

import java.util.HashMap;

public class CodeAndStore {
    // code store map
    private final HashMap<Integer, String> csMap = new HashMap<>();

    public void save(Integer code, String store){
        csMap.put(code, store);
    }

    public boolean isCodeInMap(String code){
        return csMap.containsKey(Integer.parseInt(code));
    }

    public boolean removeCode(String productCode, String storeCode){
        if(!csMap.get(Integer.parseInt(productCode)).equals(storeCode)) return false;
        else{
            csMap.remove(Integer.parseInt(productCode));
            return true;
        }
    }
}
