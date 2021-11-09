### OneOf

This validator is useful to perform a check that a provided string is in a list of string or sentence
Follwing an example 

```java
public class OneOfBean {

	@OneOf(options = {"Hello", "World", "Hey Joe!"})
	String value;

	public OneOfBean(String value) {

		this.value = value;
	}
}
```
As you can see the string ```value``` is annotated with ```@NOneOf``` indicating the list of word (or sentences) that should be equals to.

__Be aware that the checks are done case insensitive__

You can change the default message as in the following example:
```java
public class OneOfBeanV2 {

	@OneOf(options = {"Hello", "World", "Hey Joe!"}, message = "Are you sure?")
	String value;

	public OneOfBeanV2(String value) {

		this.value = value;
	}
}
```
