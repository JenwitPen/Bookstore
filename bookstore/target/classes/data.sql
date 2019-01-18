insert into book
values(1,'เล่นหุ้นมีกำไร ต้องใช้พลังดึงดูด (LAW OF ATTR ACTION FOR STOCK TRADERS)', 'สวัสดี มันดาลา (วิศิษฐ์ ศรีพิบูลย์)',120,true,GETDATE(),null,'admin',null,true);

insert into book
values(2,'แบบฝึกหัดวิเคราะห์หุ้น เล่ม 2 ', 'ดม ดอนชัย และคณะ',250,false,GETDATE(),null,'admin',null,true);

insert into book
values(3,'ตีแตก กลยุทธ์การเล่นหุ้นในภาวะวิกฤต ', 'นิเวศน์ เหมวชิรวรากร',170,false,GETDATE(),null,'admin',null,true);

insert into book
values(4,'คู่มือนักลงทุนหุ้นคุณค่า (THE VALUE INVESTORS )', 'RONALD W.CHAN /สมพงษ์ สุวรรณจิตกุล ',399,true,GETDATE(),null,'admin',null,true);

insert into book
values(5,'เฟ้นหุ้นทำกำไร ด้วยหัวใจ และกลยุทธ์ลงทุน ', 'นายแว่นลงทุน (คณิต นิมมาลัยรัตน์) ',275,false,GETDATE(),null,'admin',null,true);

insert into user (name,surname,date_of_birth,username,password,createdate,updatedate,createuser,updateuser,active)
values('john','doe',TO_DATE('15/01/1985', 'DD/MM/YYYY'),'john.doe','thisismysecret',GETDATE(),null,'admin',null,true);

insert into user (name,surname,date_of_birth,username,password,createdate,updatedate,createuser,updateuser,active)
values('jenwit','penjamrat',TO_DATE('11/03/1990', 'DD/MM/YYYY'),'bang681517','074681517',GETDATE(),null,'admin',null,true);

insert into `order` (bookid,userid,createdate,updatedate,createuser,updateuser,active)
values(1,1,GETDATE(),null,'admin',null,true);

insert into `order` (bookid,userid,createdate,updatedate,createuser,updateuser,active)
values(4,1,GETDATE(),null,'admin',null,true);



 