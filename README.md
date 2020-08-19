# 7. Hafta

- https://www.themoviedb.org/
  Üye olun ve api key alın

- Ana sayfa --> /
  Arama kutusu (metin girilecek, ara butonuna basıldığında bu api kullanılarak arama yapılacak)

- Arama sayfası --> /search?q=URLENCODEDQUERY&page=4
  Arama kutusu (aranan metin)
  Sonuçlar listelenecek
  Sonuçların altında pagination
  Her bir sonucun yanında veritabanına ekle butonu olacak, eğer zaten veritabanında ise bu buton gözükmeyecek.
  Eğer film veritabanındaysa "ayrıntıları gör" isminde bir buton olacak

- Film detay --> /movie/1
  Filmin detayları gösterilecek
  Aşağıda, 1'den 10'a kadar filme puan verme butonları olacak

- Unirest, GSON, PostgreSQL
- Herokuya yüklenecek
- Not defteri açıp, heroku adresini yazın


# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

