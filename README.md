# 자판기 미션

## 구현할 기능 목록

### 사용자 입력

- [x] 자판기가 보유하고 있는 금액을 사용자로부터 입력 받는다.
- [x] 상품명, 가격, 수량을 입력받아 구매 가능한 상품 정보를 추가한다.
  - 개별 상품 정보는 대괄호([])로 묶이고, 상품명, 가격, 수량 정보로 구성되며 각 정보는 쉼표로 구분된다.
  - 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.
- [x] 사용자로부터 상품 구매를 위한 투입 금액을 입력 받는다. 
  - 투입 금액으로는 동전을 별도로 생성하지 않는다.
- [x] 사용자로부터 구매할 상품들의 상품명을 입력 받는다.
  - [ ] 구매 가능한 상품이 완전히 없어질 때까지 반복하여 입력 받는다.

### 자판기 동작 원리

- [x] 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
- [x] 자판기가 보유한 동전을 출력한다.
- [ ] 사용자가 상품 구매시, 투입 금액을 감소시켜간다.
- [ ] 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
  - [ ] 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
  - [ ] 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
  - 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
  - 잔돈으로 반환된 동전만 출력하며, 반환되지 않은 금액은 자판기에 남는다.

### 유효성 검증 및 예외 처리 

사용자가 잘못된 값을 입력할 경우, [ERROR]로 시작하는 에러 메시지 출력 후 해당 부분의 입력을 다시 받는다.
- [ ] 자판기가 보유하고 있는 금액으로 숫자를 입력하지 않으면 예외로 간주한다.
- [ ] 자판기가 보유하고 있는 금액으로 음수를 입력된 경우 예외로 간주한다.
- [ ] 자판기가 보유하고 있는 금액으로 10원 미만의 수가 입력된 경우 예외로 간주한다.
- [ ] 상품 정보가 형식에 부합하지 않으면 예외로 간주한다. 
  - [ ] 개별 상품 정보가 대괄호([])로 감싸이지 않았으면 예외로 간주한다.
  - [ ] 개별 상품 정보가 쉼표 2개로 구분된 세부 정보 3가지로 구성되지 않는 경우 예외로 간주한다.
  - [ ] 개별 상품 정보가 쉼표 및 대괄호 사이에 입력된 값이 없는 경우 예외로 간주한다.
  - [ ] 이미 등록된 상품명이 중복으로 입력된 경우 예외로 간주한다.
  - [ ] 개별 상품 정보의 2번째와 3번째 입력값이 숫자가 아닌 경우 예외로 간주한다.
  - [ ] 개별 상품 정보의 2번째 입력값은 100원보다 작거나, 10원으로 나누어떨어지지 않는 경우 예외로 간주한다.
- [ ] 투입 금액으로 숫자를 입력하지 않으면 예외로 간주한다.
- [ ] 투입 금액으로 음수를 입력한 경우 예외로 간주한다.
- [ ] 구매할 상품명에 해당되는 상품 정보가 없는 경우 예외로 간주한다. 
- [ ] 구매하고자 하는 상품의 재고가 소진된 경우 예외로 간주한다.
