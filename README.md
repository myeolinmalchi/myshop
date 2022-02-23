# Service

- e-commerce

## Tech Stack
### server-side
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/></a>
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=Thymeleaf&logoColor=white"/></a>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/></a>
### client-side
<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=flat-square&logo=Bootstrap&logoColor=white"/></a>


## Features

### User
  - Account CRUD : 사용자 회원가입/탈퇴, 정보조회/수정
    - Multiple Addresses : 사용자별 배송지 정보 다중 저장
    - Address CRUD : 배송지 정보 추가/삭제/조회/수정
  - Validation
    - 공백 및 문자 양식 검사(client-side)
    - 아이디/이메일 중복 검사(server-side)

### Product
  - Product CRUD : 상품 추가/삭제/조회/수정
  - Hierarchical Category : Recursive CTE를 통해 구현
  - Review CRUD : 리뷰 작성/삭제/조회/수정
    - Rating : 상품별 리뷰 수 및 평균 평점 
  - QnA CRUD : 문의 작성/삭제/조회/수정
  - Options
    - 상품별 옵션, 옵션별 세부 항목
    - 세부 항목별 재고 관리(for Seller)

### Cart
  - Cart CRUD : 장바구니 담기/삭제/조회/수량조절
    - Cart Detail : 장바구니에 담긴 상품의 세부 옵션

### Order
  - Order CRUD : 주문 정보 추가/삭제/조회/수정
    -  Ordered Product : 한 주문에 포함된 상품 정보
      -  Ordered Product Options : 주문한 상품의 세부 옵션
