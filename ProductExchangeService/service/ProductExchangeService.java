package ProductExchangeService.service;

import ProductExchangeService.domain.CodeAndStore;

public class ProductExchangeService {

    private final CodeAndStore codeAndStore;

    public ProductExchangeService(CodeAndStore codeAndStore) {
        this.codeAndStore = codeAndStore;
    }

    public void init() {
        codeAndStore.save(123456789, "asdSdF");
        codeAndStore.save(235324523, "asdSdF");
        codeAndStore.save(473456453, "asdSdF");
        codeAndStore.save(679877890, "KJhdfa");
        codeAndStore.save(167865755, "KJhdfa");
        codeAndStore.save(315235435, "KJhdfa");
        codeAndStore.save(543034253, "KJhdfa");
        codeAndStore.save(345333311, "BCehie");
        codeAndStore.save(546454134, "BCehie");
        codeAndStore.save(982349503, "BCehie");
        codeAndStore.save(468923544, "BCehie");
        codeAndStore.save(546874594, "dfshdf");
        codeAndStore.save(547698457, "dfshdf");
        codeAndStore.save(348238922, "dfshdf");
        codeAndStore.save(919012328, "dfshdf");
        codeAndStore.save(382643233, "Sdjwii");
        codeAndStore.save(763873823, "Sdjwii");
        codeAndStore.save(696392323, "Sdjwii");
        codeAndStore.save(129898237, "Sdjwii");
        codeAndStore.save(879000020, "Sdjwii");
    }

    public void helpService(){
        System.out.println("-----이용 안내----");
        System.out.println("1. 교환 서비스 가능 여부 확인을 원하시면 CHECK [상품코드]을 입력해주시기 바랍니다.");
        System.out.println("2. 교환 서비스 이용을 원하시면 CLAIM [상점코드] [상품코드]을 입력해주시기 바랍니다.");
        System.out.println("---------------");
    }

    public void checkService(String codeStr){
        boolean result = codeAndStore.isCodeInMap(codeStr);
        if(!result) errorService(4);
        else successService(1);
    }

    public void claimService(String codeStr, String storeStr){
        boolean result = codeAndStore.isCodeInMap(codeStr);
        if(!result) {
            errorService(4);
            return;
        }
        result = codeAndStore.removeCode(codeStr, storeStr);
        if(!result){
            errorService(5);
        }else{
            successService(2);
        }

    }
    public void errorService(int errorCode){
        if(errorCode == 1){
            System.out.println("[오류] : 잘못된 명령어 입력입니다.");
        }else if(errorCode == 2){
            System.out.println("[오류] : 잘못된 상품 코드 입력입니다.");
        }else if(errorCode == 3){
            System.out.println("[오류] : 잘못된 상품 코드 혹은 상점 코드 입력입니다.");
        }else if(errorCode == 4){
            System.out.println("[오류] : 상품 코드가 존재하지 않습니다.");
        }else if(errorCode == 5){
            System.out.println("[오류] : 상품 코드와 상점 코드가 일치하지 않습니다.");
        }
    }

    public void successService(int successCode){
        if(successCode == 1){
            System.out.println("[성공] : 교환이 가능합니다.");
        }else if(successCode == 2){
            System.out.println("[성공] : 교환이 처리되었습니다.");
        }
    }
}
