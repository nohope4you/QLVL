Bao gồm 3 file:
1. qlvieclam : source Spring boot
2. vieclam1: source ReactJS
3. database.txt : File database text

Hướng dẫn sử dụng:
Bước 1: Copy câu lệnh SQL trong database.txt có sẵn vào MySQL để chạy tạo các bảng 
và schema

Bước 2: Mở NetBean sử dụng Server Tomcat và mở File qlvieclam 

Bước 3: Trong Other Sources chọn src/main/resources chọn default package chọn file
databases.properties và chỉnh lại các dòng cấu hình hibernate phù hợp như username, password
và connect url...

Bước 4: Chuột phải vào project vừa mở và chọn Clean and Build

Bước 5: Chuột phải chọn Run, khi Run sẽ hiển thị 1 form nhỏ để xác nhận server tomcat 
thì ấn OK

Bước 6: Mở Visual studio code và kéo file vieclam1 vào 

Bước 7: Mở terminal trên thanh công cụ dưới dạng cmd (Command Prompt)
và gõ lệnh ' npm install ' để cài đặt các gói node_modules

Bước 8: Gõ lệnh 'npm build'

Bước 9: Gõ lệnh yarn start để chạy ReactJS