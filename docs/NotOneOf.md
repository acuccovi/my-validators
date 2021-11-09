### NotOneOf

This validator is useful to perform a check that a provided string is not in a list of string or sentence Follwing an
example

```java
public class NotOneOfBean {

    @NotOneOf(options = {"Hello", "World", "Hey Joe!"})
    String value;

    public NotOneOfBean(String value) {

        this.value = value;
    }
}
```

As you can see the string ```value``` is annotated with ```@NotOneOf``` indicating the list of word (or sentences) that
should not be equals to.

You can change the default message as in the following example:

```java
public class NotOneOfBeanV2 {

    @NotOneOf(options = {"Hello", "World", "Hey Joe!"}, message = "Are you sure?")
    String value;

    public NotOneOfBeanV2(String value) {

        this.value = value;
    }
}
```

There is also an option to ignore the case of the provided string. With this option set to false (the default) the check
will fail if the provided string is not in the correct case

```java
public class NotOneOfBeanV2 {

    @NotOneOf(options = {"Hello", "World", "Hey Joe!"}, ignoreCase = true)
    String value;

    public OneOfBeanV2(String value) {

        this.value = value;
    }
}
```
