# document: https://docs.google.com/document/d/1dXIbWKEuxLxPf8PKsyHrrJcPruH9KWlxe5Mc0oMNhqc/edit?usp=sharing
# Gold Price API - Java Backend

Day la API mau tra so lieu gia vang cho website hien thi. Project duoc viet theo huong Java backend voi Spring Boot.

Trong task nay, du lieu gia vang duoc seed san vao H2 in-memory database bang `src/main/resources/data.sql`. Khi co nguon that, co the thay phan seed/demo bang logic goi API ben thu ba, doc database that hoac doc cache.

## Cong nghe

- Java 21
- Spring Boot 3
- Maven
- Spring Data JPA
- H2 Database
- JUnit 5
- MockMvc

## Cau truc project

```text
src/main/java/com/example/goldprice
  GoldPriceApiApplication.java
  controller/GoldPriceController.java
  dto/*.java
  exception/*.java
  model/GoldPrice.java
  repository/GoldPriceRepository.java
  service/GoldPriceService.java
src/main/resources
  application.properties
  data.sql

src/test/java/com/example/goldprice
  controller/GoldPriceControllerTest.java
  service/GoldPriceServiceTest.java
```

## Chay project

Can cai Maven hoac mo project bang IDE co ho tro Maven.

```powershell
mvn spring-boot:run
```

Mac dinh API chay tai:

```text
http://localhost:8080
```

## Endpoint

### Kiem tra service

```http
GET /health
```

### Lay danh sach gia vang

```http
GET /api/gold-prices?date=2026-07-02
```

Response mau:

```json
{
  "name": "Vang mieng SJC",
  "brand": "SJC",
  "buyPrice": 80000000,
  "sellPrice": 82000000,
  "currency": "VND",
  "weightUnit": "luong",
  "updatedAt": "2026-07-02T00:00:00"
}
```

### Lay gia vang theo thuong hieu

```http
GET /api/gold-prices/SJC?date=2026-07-02
```

Neu khong tim thay du lieu theo ngay hoac thuong hieu, API tra ve HTTP `404`.

## Du lieu demo

Database demo co 15 ban ghi trong ngay `2026-07-02`, tu `00:00:00` den `14:00:00`. Phut va giay duoc mac dinh la `00` de website map theo truc gio de hon.

## Test

```powershell
mvn test
```

Luu y: may hien tai co Java 21 nhung chua co lenh `mvn` trong PATH, nen can cai Maven truoc khi chay bang terminal.

## Huong mo rong

- Thay mock data bang API nguon gia vang that.
- Them cache ngan han bang Redis/Caffeine de giam so lan goi nguon goc.
- Them scheduler de tu dong cap nhat gia.
- Them API key neu endpoint khong public.
- Them logging, monitoring va rate limit khi dua len production.
