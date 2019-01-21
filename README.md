<b>ตัวอย่างระบบ BooK Store using Java Spring Boost Rest Api<b>
  
สิ่งที่นำมาใช้ในระบบ
  - H2 database in memory 
  - Swagger
  - JUnit Test
  - log4j
  - jdbc
  - Basic authentication
  
Login to the database เพื่อดูตัวอย่างข้อมูล
เปิด browser, enter http://localhost:8080/h2-console

Enter the following for 
JDBC URL: jdbc:h2:mem:testdb <br>
User Name: sa <br>
Pasword: <leave this empty> <br>

สามารถทดสอบ Unit Test โดยการ Right Click Project > Run as > JUnit Test

สามารถเข้าไปดู Swagger เปิด browser, enter http://localhost:8080/swagger-ui.html

สามารถ download ไฟล์ BookStore.postman_collection.json เพื่อ import เข้า Postman เพื่อทดลองระบบ

ข้อมูลสำหรับ Basic authentication
username=admin1
password=secret1

