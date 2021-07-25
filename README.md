# Welcome to Shoe Shopper

An application that demonstrates Spring's basic authentication/authorization capabilities. This app creates products that can be sent to a shopping cart (standard shopping cart flow). Only the ADMIN side will expose an ADD button to put items in the database. The shopping cart will uniquely store each user's cart until they are ready to checkout or clear their contents. This project has been tested from the ground up with a focus on jpa unit tests to create the structure of the databases and integration tests to wire up the application to front end templates.

## The following technologies are demonstrated in this app

- Spring Data JPA
- Spring Security
- Thymeleaf Layouts
- Thymeleaf Security Extras
- TDD
- Photo Uploads

## Instructions for use

Navigate to `localhost:8080/` and the login info will be either `admin` , `admin` or `user` , `user`. Logging in as `admin` will allow access to an `add` button to add more products to the database.

### ToDos

- Slider of images for each product
- Quantity/Totals using BigDecimal
- Shoe size selectors 
