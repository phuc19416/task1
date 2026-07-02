# Gia lap workflow su dung AI cho task API gia vang

## 1. Nhan yeu cau tu anh huong dan

Yeu cau:

```text
Khach hang can 1 API tra so lieu gia vang cho 1 website hien thi.
Gia dinh du lieu gia vang da co tu mot nguon nao do.
Can ap dung AI vao qua trinh lam nhanh va hieu qua hon.
```

Vai tro cua em: Java Backend Intern.

Muc tieu khi dung AI:

- Hieu nhanh yeu cau.
- Chon thiet ke API phu hop.
- Tao skeleton Spring Boot nhanh.
- Viet code, test va tai lieu.
- Kiem tra lai ket qua truoc khi push GitHub.

## 2. Buoc 1 - Dung AI de phan tich yeu cau

Prompt gia lap:

```text
Toi dang thuc tap Java backend. Khach hang can API tra gia vang cho website.
Gia dinh da co nguon du lieu. Hay giup toi phan tich endpoint, response, loi can xu ly va cau truc project.
```

Ket qua AI goi y:

- Can API lay danh sach gia vang.
- Can API lay gia vang theo ma, vi du `SJC`, `DOJI`, `PNJ`.
- Can endpoint health check.
- Response nen co `buy`, `sell`, `spread`, `unit`, `currency`, `source`, `updatedAt`.
- Nen tach Controller, Service, DTO, Exception Handler.

Ket luan cua em:

```text
Chon Spring Boot vi phu hop vai tro Java backend va de demo API nhanh.
```

## 3. Buoc 2 - Dung AI de thiet ke API

Prompt gia lap:

```text
Hay thiet ke REST API cho gia vang bang Spring Boot.
Can co endpoint, HTTP method, response mau va error response.
```

Thiet ke chot:

```text
GET /health
GET /api/gold-prices
GET /api/gold-prices/{code}
```

Response mau:

```json
{
  "code": "SJC",
  "name": "Vang SJC",
  "unit": "VND/luong",
  "buy": 74800000,
  "sell": 77000000,
  "spread": 2200000,
  "currency": "VND",
  "source": "mock-gold-price-source",
  "updatedAt": "2026-07-02T07:58:32Z"
}
```

## 4. Buoc 3 - Dung AI de sinh skeleton project

Prompt gia lap:

```text
Tao project Spring Boot Java 21 gom Controller, Service, DTO, Exception Handler va test cho API gia vang.
Du lieu hien tai mock trong service, sau nay co the thay bang API that.
```

AI ho tro tao cac file:

```text
pom.xml
src/main/java/com/example/goldprice/GoldPriceApiApplication.java
src/main/java/com/example/goldprice/controller/GoldPriceController.java
src/main/java/com/example/goldprice/service/GoldPriceService.java
src/main/java/com/example/goldprice/dto/GoldPriceResponse.java
src/main/java/com/example/goldprice/dto/ErrorResponse.java
src/main/java/com/example/goldprice/exception/GlobalExceptionHandler.java
src/test/java/com/example/goldprice/controller/GoldPriceControllerTest.java
src/test/java/com/example/goldprice/service/GoldPriceServiceTest.java
```

Em kiem tra lai:

- Package name dung chuan Java.
- Controller khong xu ly qua nhieu logic.
- Service co the thay mock data bang nguon that.
- DTO khong expose thua du lieu noi bo.

## 5. Buoc 4 - Dung AI de viet test

Prompt gia lap:

```text
Viet test cho Spring Boot API:
- Lay danh sach gia vang tra ve 3 item
- Lay theo ma SJC/DOJI khong phan biet hoa thuong
- Ma khong ton tai tra ve 404
```

Test duoc tao:

- `GoldPriceServiceTest`
- `GoldPriceControllerTest`

Lenh chay:

```powershell
mvn test
```

Ket qua da chay:

```text
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 6. Buoc 5 - Dung AI de tao tai lieu

Prompt gia lap:

```text
Viet README cho project API gia vang Spring Boot, gom cach chay, endpoint, response mau, cach test va huong mo rong.
```

AI ho tro tao:

- `README.md`: huong dan cai dat, chay API, test endpoint.
- `BAO_CAO_AI.md`: bao cao qua trinh ap dung AI vao task.
- `WORKFLOW_AI.md`: workflow gia lap su dung AI.

## 7. Buoc 6 - Dung AI de kiem tra va push GitHub

Prompt gia lap:

```text
Kiem tra git status, them .gitignore, commit project va push len repo GitHub.
```

AI ho tro:

- Them `.gitignore` de bo qua `target/`.
- Commit source code.
- Push len GitHub.

Repo:

```text
https://github.com/phuc19416/task1.git
```

## 8. Loi ich khi dung AI trong task nay

AI giup tang toc:

- Phan tich yeu cau nhanh hon.
- Tao skeleton project nhanh hon.
- Viet test nhanh hon.
- Viet README va bao cao nhanh hon.
- Giam thoi gian tra cuu cu phap Spring Boot/JUnit.

Nhung em van can tu kiem soat:

- Chon kien truc phu hop.
- Doc va hieu code AI sinh ra.
- Chay test de xac nhan code dung.
- Kiem tra response co phu hop voi website hay khong.
- Dam bao khong push file build/thua len GitHub.

## 9. Tom tat workflow

```text
Nhan yeu cau
-> Hoi AI phan tich bai toan
-> Chot endpoint va response
-> Nho AI tao skeleton Spring Boot
-> Kiem tra va sua code
-> Nho AI viet test
-> Chay mvn test
-> Nho AI viet README/bao cao
-> Commit va push GitHub
```

## 10. Ket luan

Voi task nay, AI khong thay the lap trinh vien ma dong vai tro tro ly ky thuat. AI giup lam nhanh cac phan lap lai nhu skeleton, test va tai lieu. Em van phai hieu yeu cau, chon thiet ke backend, kiem tra code va dam bao san pham chay duoc truoc khi bao cao.
