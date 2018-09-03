## JPA Hibernate Mappings
__Association mappings__ are one of the key features of JPA and Hibernate. They model the relationship between two database tables as attributes in your domain model. ... JPA and Hibernate support the same associations as you know from your relational database model.

* __One-to-One__
* __Many-to-One__
* __Many-to-Many__

#### 1. Dependencies in project ([pom.xml](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/pom.xml))
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### 2. Mapping One-to-One Relationship
Create 2 entities __User__ and __Token__ that having One-to-One relationship:
`User 1------1 Token`

Implement [__User__](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/src/main/java/com/darkness/entity/one2one/User.java) entity:
```java 
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "token_id")
    private Token token;

    public User(String email, Token token) {
        this.email = email;
        this.token = token;
    }
}
```

Implement [__Token__](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/src/main/java/com/darkness/entity/one2one/Token.java) entity:
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "token")
public class Token implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String token;

    @OneToOne(mappedBy = "token")
    private User user;

    public Token(String token) {
        this.token = token;
    }
}
```

#### 3. Mapping One-to-Many Relationship
Create 2 entities __Category__ and __Product__ that having One-to-Many relationship:
`Category 1------N Product`

Implement [__Category__](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/src/main/java/com/darkness/entity/many2one/Category.java) entity:
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany( mappedBy = "category",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    private Set<Product> products;

    public Category(String name) {
        this.name = name;
    }
}
```
Implement [__Product__](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/src/main/java/com/darkness/entity/many2one/Product.java) entity:
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
```

#### 4. Mapping Many-to-Many Relationship
Create 2 entities __Student__ and __Subject__ that having Many-to-Many relationship:
`Student N------N Subject`

Implement [__Student__](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/src/main/java/com/darkness/entity/many2many/Student.java) entity:
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
    private Set<Subject> subjects;

    public Student(String name) {
        this.name = name;
    }
}
```

Implement [__Subject__](https://github.com/nguyenvantra/spring-master/blob/master/springboot-jpa-hibernate-mapping/src/main/java/com/darkness/entity/many2many/Subject.java) entity:
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students;

    public Subject(String name) {
        this.name = name;
    }
}
```

