# ShareTreatsProject
* 해당 프로젝트는 ShareTreats 사전 과제입니다.<br><br>
 ---
## 세부구현시스템
   * **[구조](#구조)**
   * **[서비스](#서비스)**
   * **[예외처리](#예외처리)**

---
## 개발 환경

|    Java    | 
| :--------: | 
|     11     |  
---

## Tools
* Git
* IntelliJ

---
## 시연영상 (Video)
- [Link](https://www.youtube.com/watch?v=JS9s4Su1174)<br>
---

## 구조
- 객체 지향 프로그래밍<br>
<img width="273" alt="Screen Shot 2023-04-15 at 4 37 07 AM" src="https://user-images.githubusercontent.com/68188361/232139784-51365af2-78ce-47b7-b845-fc8931236aed.png">


|    repository   | service | ui | test|
| :--------: | :--------: | :--------: | :--------: | 
|     저장된 상품코드 및 상점코드 저장소     | help, check, claim, 성공/에러 메시지 담당 | 사용자 입력 및 분기처리 담당 | 테스트 실행 메인 메서드|

## 서비스
- help : 사용자 도움말 제공
- check : 저장된 상품코드와 입력 받은 상품코드 일치 여부 확인
- claim : 저장된 상품코드 - 상점코드 일치여부 확인 후 교환 처리 (상품코드 HashMap에서 제거)
- 에러/성공 메시지 : 입력/처리 이슈 발생시 메시지 콘솔에 출력

## 예외처리
- 명령어 예외처리 
- 숫자/영어 예외처리
- 글자수 예외처리 (상품코드 길이, 상점코드 길이 등)
