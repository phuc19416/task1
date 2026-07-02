# Bao cao qua trinh ap dung AI vao task API gia vang

## 1. Boi canh

Em dang thuc tap voi vai tro Java backend. Yeu cau cua anh huong dan la: khach hang can mot API tra so lieu gia vang cho website hien thi. Gia dinh rang da co mot nguon du lieu gia vang, nen muc tieu cua task la thiet ke API, code backend mau va trinh bay cach ap dung AI vao qua trinh lam viec.

## 2. Cach em su dung AI

Em su dung AI nhu mot tro ly ky thuat de day nhanh cac viec sau:

1. Phan tich yeu cau: AI giup xac dinh API can co endpoint nao, response gom truong nao, can xu ly loi gi.
2. Chon cong nghe: vi em lam Java backend, AI de xuat dung Spring Boot de phu hop voi cong viec thuc tap.
3. Sinh skeleton project: AI tao cau truc Controller, Service, DTO, Exception Handler va Test.
4. Viet code mau: AI tao API tra danh sach gia vang va API tra gia vang theo ma.
5. Viet test: AI tao test cho service va controller bang JUnit 5, MockMvc.
6. Viet tai lieu: AI tao README va bao cao ngan gon de giai thich cach chay, cach test va huong mo rong.

## 3. Thiet ke API

API gom cac endpoint:

```text
GET /health
GET /api/gold-prices
GET /api/gold-prices/{code}
```

Response gia vang gom:

- `code`: ma loai vang, vi du `SJC`, `DOJI`, `PNJ`
- `name`: ten loai vang
- `unit`: don vi tinh
- `buy`: gia mua vao
- `sell`: gia ban ra
- `spread`: chenh lech gia ban - gia mua
- `currency`: tien te
- `source`: nguon du lieu
- `updatedAt`: thoi diem cap nhat

## 4. Code da thuc hien

Project duoc viet bang Java Spring Boot:

- `GoldPriceController`: nhan request tu website.
- `GoldPriceService`: xu ly logic lay va chuan hoa gia vang.
- `GoldPriceResponse`: DTO tra ve cho client.
- `GlobalExceptionHandler`: chuan hoa response loi.
- `GoldPriceControllerTest`: test API layer.
- `GoldPriceServiceTest`: test logic service.

## 5. Ly do tach Controller - Service - DTO

Tach lop giup code de bao tri:

- Controller chi phu trach request/response.
- Service chua logic nghiep vu.
- DTO dinh nghia du lieu tra ra cho website.
- Exception Handler giup loi tra ve dong nhat.

Day la cach to chuc quen thuoc trong Java backend va phu hop khi sau nay thay mock data bang nguon du lieu that.

## 6. Huong mo rong khi co nguon du lieu that

Khi co nguon that, em se sua `GoldPriceService` de:

- Goi API ben thu ba bang `RestClient` hoac `WebClient`.
- Hoac doc gia vang tu database/cache.
- Them cache ngan han de website goi nhanh hon va giam tai cho nguon goc.
- Them scheduler neu can tu dong cap nhat gia theo chu ky.
- Them logging, monitoring, API key va rate limit khi dua len production.

## 7. Ket qua

Da co project Java Spring Boot mau cho API gia vang, co cau truc backend ro rang, co test va tai lieu. AI giup tang toc qua trinh lam skeleton, viet test va viet bao cao, con nguoi van can kiem tra yeu cau, quyet dinh kien truc va danh gia code truoc khi nop.
