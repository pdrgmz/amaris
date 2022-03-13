
# Amaris - Prueba Técnica Java Inditex


Aplicación en  Spring Boot

Expone endpoint GET para la consulta de precios desde la tabla PRICES según los parámetros:
Fecha de consulta
Identificador de producto
Identificador de cadena
Se utiliza base de datos en memoria H2 con datos de ejemplo



| BRAND_ID | START_DATE | END_DATE |  PRICE_LIST |  PRODUCT_ID |  PRIORITY | PRICE | CURR | 
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|1|2020-06-14-00.00.00|2020-12-31-23.59.59|1|35455|0|35.50|EUR|
|1|2020-06-14-15.00.00|2020-06-14-18.30.00|2|35455|1|25.45|EUR|
|1|2020-06-15-00.00.00|2020-06-15-11.00.00|3|35455|1|30.50|EUR|
|1|2020-06-15-16.00.00|2020-12-31-23.59.59|4|35455|1|38.95|EUR|


Se ha desplegado en Heroku

- Swagger https://amaris-pdrgmz.herokuapp.com/swagger-ui.html



