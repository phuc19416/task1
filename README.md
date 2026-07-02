# Gold Price API - Java Backend

Day la API mau tra so lieu gia vang cho website hien thi. Project duoc viet theo huong Java backend voi Spring Boot.

Trong task nay, nguon du lieu gia vang duoc gia dinh la da co san, nen code dang mock data trong `GoldPriceService`. Khi co nguon that, chi can thay phan service bang logic goi API ben thu ba, doc database hoac doc cache.

## Cong nghe

- Java 21
- Spring Boot 3
- Maven
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
  service/GoldPriceService.java

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
GET /api/gold-prices
```

Response mau:

```json
[
  {
    "code": "SJC",
    "name": "Vang SJC",
    "unit": "VND/luong",
    "buy": 74800000,
    "sell": 77000000,
    "spread": 2200000,
    "currency": "VND",
    "source": "mock-gold-price-source",
    "updatedAt": "2026-07-02T05:00:00Z"
  }
]
```

### Lay gia vang theo ma

```http
GET /api/gold-prices/SJC
```

Neu khong tim thay ma vang, API tra ve HTTP `404`.

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
