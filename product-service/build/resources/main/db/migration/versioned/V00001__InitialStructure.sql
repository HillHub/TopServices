CREATE TABLE dbo.Category
(
    id		                    INT IDENTITY PRIMARY KEY,
    name		                NVARCHAR(100),
    description                 NVARCHAR(1000),
    creationDate                DATETIME DEFAULT (GETDATE()),
    lastModified                DATETIME DEFAULT (GETDATE())
)
CREATE UNIQUE INDEX uix_category_id ON Category(id)

CREATE TABLE dbo.CategoryAssignment
(
    categoryId                  INT,
    productId                   INT
)

CREATE TABLE dbo.Product
(
    id		                    INT IDENTITY PRIMARY KEY,
    sku                         NVARCHAR(100),
    name		                NVARCHAR(100),
    creationDate                DATETIME DEFAULT (GETDATE()),
    lastModified                DATETIME DEFAULT (GETDATE()),
)
CREATE UNIQUE INDEX uix_product_id ON Product(id)
