### EnumValue

This validator is useful to perform a check that a provided string is a valid enum
Follwing an example 

```java
public class EnumBean {

	@EnumValue(enumClass = TestEnum.class)
	final String enumVal;

	public EnumBean(String enumVal) {

		this.enumVal = enumVal;
	}
}
```
As you can see the string ```enumVal``` is annotated with ```@EnumValue``` indicating the enum class to be used for the validation.
You can change the default message as in the following example:
```java
public class EnumBeanV2 {

	@EnumValue(enumClass = TestEnum.class, message = "'{enumClass}' does not contains '${validatedValue}'")
	final String enumVal;

	public EnumBeanV2(String enumVal) {

		this.enumVal = enumVal;
	}
}
```

There is also an option to ignore the case of the provided string. Since normally the enum values are in uppercase, with this option set to false (the default) the check will fail if the provided string is not in the correct case
```java
public class EnumBeanV2 {

	@EnumValue(enumClass = TestEnum.class, ignoreCase = true)
	final String enumVal;

	public EnumBeanV2(String enumVal) {

		this.enumVal = enumVal;
	}
}
```
