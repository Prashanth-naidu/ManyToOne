create table if not exists customer (
  customerid INT PRIMARY KEY AUTO_INCREMENT,
  customername varchar(255),
  mobilenumber varchar(255)
);

create table if not exists product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    price INT,
    customerid INT,
    FOREIGN KEY (customerid) REFERENCES customer(customerid)
);

