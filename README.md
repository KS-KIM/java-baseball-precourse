# 숫자 야구 게임

우아한 테크코스 1주차 미션 '숫자 야구게임' 구현

## 기능 목록

- 프로그램은 크게 *랜덤 수 생성*, *숫자 추론*, *프로그램 종료* 단계로 구성된다.

### 프로그램 시작

- 프로그램이 시작되면 컴퓨터는 임의의 숫자를 만들어낸다.
    - 야구 숫자는 중복되지 않는 1~9 사이의 세 자리 숫자로 구성된다.
    
### 게임 진행(반복)

- 사용자로부터 세 자리 수를 입력받는다.
    - **예외**: 각 숫자가 1보다 작거나 9보다 큰 경우
    - **예외**: 세 자리 수가 아닌 경우
    - **예외**: 세 자리 수 중에 중복되는 수가 하나라도 있는 경우    
- 만들어진 임의의 수와 사용자 수를 비교하여 스트라이크와 볼의 수를 계산 후 출력한다.
- 잘못된 입력이 들어왔거나, 종료 조건을 만족하지 못하면 프로그램을 반복한다.

### 프로그램 종료

- 3 스트라이크를 달성한 경우 안내 문구를 출력하고 프로그램을 종료한다.