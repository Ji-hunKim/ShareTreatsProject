package ProductExchangeService.ui;

import ProductExchangeService.domain.CodeAndStore;
import ProductExchangeService.service.ProductExchangeService;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServiceUI {
    private final CodeAndStore codeAndStore = new CodeAndStore();
    private final ProductExchangeService productExchangeService = new ProductExchangeService(codeAndStore);

    public void getStarted(){
        // 테스트용 기본값 넣기
        productExchangeService.init();
        boolean isServiceRunning = true;

        while(isServiceRunning){
            System.out.println("원하시는 서비스를 입력해주세요.");
            // 고객 요청 입력
            Scanner sc = new Scanner(System.in);
            String[] input = sc.nextLine().split(" ");
            String command = input[0];

            // 고객 요청별 분기처리
            switch (command.toLowerCase()) {
                // 1. 문의
                case "help":
                    // help 이외의 문자/숫자가 포함된 경우 에러 메시지
                    if (input.length != 1) productExchangeService.errorService(1);
                    // 아니라면 helpService
                    else {
                        productExchangeService.helpService();
                    }
                    break;
                // 2. 교환 확인
                case "check":
                    String codeStr = "";

                    for (int i = 1; i < input.length; i++) {
                        codeStr += input[i];
                    }
                    // 상품 코드 길이가 9가 아니라면 에러 메시지
                    if (codeStr.length() != 9) productExchangeService.errorService(2);
                        // 맞다면 계속
                    else {
                        boolean numCheck = true;
                        // 상품 코드에 숫자가 아닌 문자가 섞여있는지 확인
                        for (int i = 0; i < codeStr.length(); i++) {
                            if (!Character.isDigit(codeStr.charAt(i))) {
                                numCheck = false;
                            }
                        }
                        // 숫자만 있다면 checkService 실행
                        if (numCheck) {
                            productExchangeService.checkService(codeStr);
                        }
                        // 문자가 섞여있다면 에러 메시지
                        else {
                            productExchangeService.errorService(2);
                        }
                    }
                    break;
                // 3. 교환
                case "claim":
                    String productCodeStr = "";
                    String storeCodeStr = "";
                    String inputStr = "";

                    for (int i = 1; i < input.length; i++) {
                        inputStr += input[i];
                    }

                    // 상점코드 6자리 + 상품코드 9자리 총 15자리가 아니라면 에러메시지
                    if(inputStr.length()!= 15) productExchangeService.errorService(3);
                    else {
                        // 상점 코드 6자리
                        storeCodeStr = inputStr.substring(0,6);
                        //상품 코드 9자리
                        productCodeStr = inputStr.substring(6);


                        // [1] 상품코드 확인
                        // 상품 코드에 숫자가 아닌 문자가 섞여있는지 확인
                        for (int i = 0; i < productCodeStr.length(); i++) {
                            if (!Character.isDigit(productCodeStr.charAt(i))) {
                                productExchangeService.errorService(3);
                                return;
                            }
                        }

                        // [2] 상점코드 확인
                        // 상점 코드에 영어가 아닌 문자가 섞여있는지 확인
                        for (int i = 0; i < storeCodeStr.length(); i++) {
                            if (storeCodeStr.charAt(i) < 'A' || storeCodeStr.charAt(i) > 'z') {
                                productExchangeService.errorService(3);
                                return;
                            }
                        }
                        // 영어만 있다면 claimService 실행
                        productExchangeService.claimService(productCodeStr, storeCodeStr);
                    }
                    break;
                // 4. 프로그램 종료 코드
                case "0":
                    isServiceRunning = false;
                    break;
                // 5. 잘못된 입력 에러 메시지 콘솔에 알림
                default:
                    productExchangeService.errorService(1);
                    break;
            }
            System.out.println("");
        }
    }
}
