# SpringBoot-Reactive-MongoDb
This is a spring boot reactive application with Rest calls to get data from mongodb.
App localhost
http://localhost:8088/
# Start the mongodb instance 
C:\Program Files\MongoDB\Server\6.0\bin -> cmd mongod
this starts the mongo instance in below port:
http://localhost:27017/
Open compass desktop and connect to the above port for checking documents and collection

# End Points
# 1. Insert list of products using flux.
POST: http://localhost:8088/products/list
Payload
[{
    "name": "mobile",
    "qty":"5",
    "price": 50000
},
{
    "name": "access",
    "qty":"10",
    "price": 20000
}
]

# 2. Insert single document
POST: http://localhost:8088/products

Payload
{
    "name": "access",
    "qty":"10",
    "price": 20000
}

# 3. Get list of products
GET: http://localhost:8088/products

# 4. Delete a single product
DETELE: http://localhost:8088/products/delete/{id}
