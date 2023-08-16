CREATE SCHEMA `qlvieclam` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
use qlvieclam;
create table Role (
id int auto_increment primary key,
nameRole nvarchar(50)
);
create table Education(
id int auto_increment primary key,
typeEducation nvarchar(50)
);
create table City(
id int auto_increment primary key,
nameCity nvarchar(50)
);
create table Major(
id int auto_increment primary key,
nameMajor nvarchar(50)
);
create table District(
id int auto_increment primary key,
nameDistrict nvarchar(50)
);
create table TypeJob(
id int auto_increment primary key,
nameType nvarchar(50)
);
create table User (
id int auto_increment primary key,
username nvarchar(50),
password nvarchar(50),
avatar varchar(200),
roleID int,
Foreign key (roleID) references Role(id)
);

create table Employer(
id int auto_increment primary key,
nameEmployer nvarchar(50),
nameCompany nvarchar(50),
AddressComapny nvarchar(50),
soDienThoai nvarchar(13),
avatar varchar(200),
userID int,
isApproved boolean,
foreign key (userID) references User(id)
);
create table EmployerReview(
id int auto_increment primary key,
cmt nvarchar(100),
rating double,
userID int,
EmployerID int,
foreign key (userID) references User(id),
foreign key (EmployerID) references Employer(id)
);
create table job(
id int auto_increment primary key,
avatarJob nvarchar(200),
nameJob nvarchar(50),
salary long,
SoLuongTuyenDung int,
KinhNghiem int,
Age int,
createdDate Date,
cityID int,
majorID int,
typeJobID int,
employerID int,
EducationID int,
districID int,
foreign key (cityID) references City(id),
foreign key (majorID) references Major(id),
foreign key (typeJobID) references TypeJob(id),
foreign key (employerID) references Employer(id),
foreign key (EducationID) references Education(id),
foreign key (districID) references District(id)
);
create table Application(
id int auto_increment primary key,
userID int,
jobID int,
fileCV varchar(200),
ho nvarchar(50),
ten nvarchar(50),
email nvarchar(50),
sdt nvarchar(50),
NgheNghiep nvarchar(50),
trinhDoHocVan nvarchar(50),
addressUser nvarchar(50),
NamKinhNghiem int,
Tuoi int,	
foreign key (userID) references User(id),
foreign key (jobID) references Job(id)
);
insert into Role(nameRole) value ("Ứng viên");
insert into Role(nameRole) value ("Admin");
insert into Role(nameRole) value ("Nhà tuyển dụng");

insert into City(nameCity) value ("TP.Hồ Chí Minh");
insert into City(nameCity) value ("TP.Hà Nội");
insert into City(nameCity) value ("TP.Đà Nẵng");

insert into District(nameDistrict) value ("Tân Bình");
insert into District(nameDistrict) value ("Tân Phú");
insert into District(nameDistrict) value ("Gò Vấp");

insert into Major(nameMajor) value ("IT");
insert into Major(nameMajor) value ("Kế toán");
insert into Major(nameMajor) value ("Marketing");
insert into Major(nameMajor) value ("Xây dựng");

insert into Education(typeEducation) value("Đại học");
insert into Education(typeEducation) value("Cao đẳng");insert into Education(typeEducation) value("Dưới bậc Đại học");

insert into TypeJob(nameType) value("Trực tiếp- Full time");
insert into TypeJob(nameType) value("Trực tiếp- Part time");
insert into TypeJob(nameType) value("Từ xa- Full time");
insert into TypeJob(nameType) value("Từ xa- Part time");

insert into User(username,password,avatar,roleID) value ("a","a","a",3);
insert into User(username,password,avatar,roleID) value ("adnin","a","a",2);
insert into User(username,password,avatar,roleID) value ("user","a","a",1);

insert into Employer(nameEmployer,nameCompany,AddressComapny,soDienThoai,avatar,userID
,isApproved) value ("a","a","aaa11","0933","dsad",1,1);