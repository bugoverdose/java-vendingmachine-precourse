# 자판기 미션

### 구현할 기능 목록

- [x] 자판기가 보유하고 있는 금액을 사용자로부터 입력받는다.
- [x] 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
- [x] 자판기가 보유하고 동전을 출력한다.

- [x] 상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다.
  - 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.
  
- [x] 사용자로부터 투입할 금액을 입력받는다. 
  - 투입 금액으로는 동전을 생성하지 않는다.

- [x] 사용자는 투입한 금액으로 상품을 구매할 수 있다.

- [x] 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
  - 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
  - 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
  - 반환되지 않은 금액은 자판기에 남는다.
  - 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
  - 잔돈은 반환된 동전만 출력한다.

### 유효성 검증 및 예외 처리

- 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.

- 자판기 보유 금액 및 투입 금액 입력시 예외 처리
  - [x] 예외 발생시 에러 메시지를 출력 후 다시 입력을 받는다.
  - [x] 숫자를 입력하지 않으면 예외로 간주한다.
  - [x] 음수를 입력한 경우 예외로 간주한다.
  - [x] 1원 단위에 값이 입력된 경우 예외로 간주한다.

- 자판기 상품 정보 입력시 예외 처리
  - [x] 예외 발생시 에러 메시지를 출력 후 다시 입력을 받는다.
  - 입력한 정보가 형식에 부합하지 않으면 예외로 간주한다.
    - [x] 개별 상품 정보 양끝에 대괄호([])가 있지 않으면 예외로 간주한다.
    - [x] 대괄호([]) 사이에 쉼표로 구분되는 3가지 정보가 있지 않으면 예외로 간주한다.
    - [ ] 세미콜론(;)이 개별 정보들 사이 이외의 위치하면 예외로 간주한다.
  - [x] 이미 등록된 상품명을 중복 등록하려는 경우 예외로 간주한다.
  - [x] 가격과 수량으로 숫자를 입력하지 않으면 예외로 간주한다.
  - [x] 가격과 수량으로 음수를 입력한 경우 예외로 간주한다.
  - [x] 가격에 1원 단위에 값이 입력된 경우 예외로 간주한다.
  - [x] 가격이 100원부터 시작하지 않으면 예외로 간주한다.

- 구매시 예외 처리
  - [x] 예외 발생시 에러 메시지를 출력 후 다시 입력을 받는다.
  - [x] 등록되지 않은 상품명을 입력한 경우 예외로 간주한다.
  - [x] 해당 상품을 남은 투입 금액으로 구매할 수 없는 경우 예외로 간주한다.
  - [x] 해당 상품의 재고가 소진된 경우 예외로 간주한다.
