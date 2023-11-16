INSERT INTO Category(name, description)
VALUES('Startpage', 'Startpage productlisting');

INSERT INTO Product(sku, name)
VALUES('1337', 'Product 1337'),('1338', 'Product 1338');

INSERT INTO CategoryAssignment(categoryId, productId)
VALUES(1,1),(1,2);