Lib-Properties
===

Lib-Properties is a library for `easy` loading [properties] files in a [JavaFX] 
&amp; [Maven] desktop application.

_Image:_ [UML] Lib-Properties  
![UML-diagram_Lib-Properties_v0.5.0_2017-07-17_21-17.png][UML-diagram_Lib-Properties_v0.5.0_2017-07-17_21-17]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

Current `version` is `0.5.1` (01.02.2018 / MM.dd.yyyy).



Content
---

* [Examples](#Examples)
    - [How to register a resource bundle](#HoToReAReBu)
    - [How to access a value from the resource bundle](#HoToAcAVaFrThReBu)
* [Api](#Api)
    - [com.github.naoghuman.lib.properties.core.PropertiesFacade](#PropertiesFacade)
    - [com.github.naoghuman.lib.properties.core.SimpleProperties](#PropertiesFacade)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---

### How to register a resource bundle<a name="HoToReAReBu" />

```java
public interface IApplicationConfiguration {
    ...
    public static final String DBW__RESOURCE_BUNDLE = "/de/pro/dbw/application/DreamBetterWorlds.properties"; // NOI18N
}

public class DreamBetterWorlds extends Application implements IApplicationConfiguration, IPreferencesConfiguration {
    @Override
    public void init() throws Exception {
        PropertiesFacade.getDefault().register(DBW__RESOURCE_BUNDLE);
        ...
    }

    ...
}
```


### How to access a value from the resource bundle<a name="HoToAcAVaFrThReBu" />

```java

public class DreamBetterWorlds extends Application implements IApplicationConfiguration, IPreferencesConfiguration {
    private static final String KEY__APPLICATION__TITLE = "application.title"; // NOI18N
    ...

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(this.getProperty(KEY__APPLICATION__TITLE));
        ...
    }

    private String getProperty(String propertyKey) {
        return PropertiesFacade.getDefault().getProperty(DBW__RESOURCE_BUNDLE, propertyKey);
    }
    ...
}
```



Api<a name="Api" />
---

### com.github.naoghuman.lib.properties.core.PropertiesFacade<a name="PropertiesFacade" />

```java
/**
 * The facade {@link com.github.naoghuman.lib.properties.core.PropertiesFacade} 
 * provides access to the methods from the {@code Interface} 
 * {@link com.github.naoghuman.lib.properties.core.SimpleProperties}.
 * <p>
 * The usage from the facade is preferred over the directly usage through instanziation
 * from the {@code Class} {@link com.github.naoghuman.lib.properties.internal.DefaultSimpleProperties}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.properties.core.SimpleProperties
 * @see    com.github.naoghuman.lib.properties.internal.DefaultSimpleProperties
 */
public final class PropertiesFacade implements SimpleProperties
```

```java
/**
 * Returns a singleton instance from the {@code Class} {@code PropertiesFacade}.
 * 
 * @return a singleton instance from the {@code Class} {@code PropertiesFacade}.
 */
public static final PropertiesFacade getDefault()
```


### com.github.naoghuman.lib.properties.core.SimpleProperties<a name="SimpleProperties" />

```java
/**
 * The {@code Interface} for the default {@code Implementation} 
 * {@link com.github.naoghuman.lib.properties.internal.DefaultSimpleProperties}.
 * <p>
 * Over the facade {@link com.github.naoghuman.lib.properties.core.PropertiesFacade} 
 * the developer can access to the methods from this {@code Interface}, which is the 
 * preferred way (and not the usage through instanziation from the {@code Class} 
 * {@code DefaultSimpleProperties}).
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.properties.core.PropertiesFacade
 * @see    com.github.naoghuman.lib.properties.internal.DefaultSimpleProperties
 */
public interface SimpleProperties
```

```java
/**
 * Searches for the property with the specified key in this property list.<br>
 * If the key is not found in this property list, the default property list,
 * and its defaults, recursively, are then checked. The method returns
 * {@code null} if the property is not found.
 * 
 * @param pathWithBundle The properties where value is stored.
 * @param key            The property key.
 * @return               The value in this property list with the specified 
 *                       key value.
 */
public String getProperty(final String pathWithBundle, final String key);
```

```java
/**
 * Searches for the property with the specified key in this property list.<br>
 * If the key is not found in this property list, the default property list,
 * and its defaults, recursively, are then checked. The method returns the
 * default value argument if the property is not found.
 * 
 * @param pathWithBundle The properties where value is stored.
 * @param key            The property key.
 * @param defaultValue   If the key-value pair not stored in the properties  
 *                       then the {@code defaultValue} will be returned.
 * @return               The value in this property list with the specified 
 *                       key value.
 */
public String getProperty(final String pathWithBundle, final String key, final String defaultValue);
```

```java
/**
 * Allowed access to the {@code System} properties. Gets the system property 
 * indicated by the specified key.
 * <p>
 * First, if there is a security manager, its {@code checkPropertyAccess} method 
 * is called with the key as its argument. This may result in a SecurityException.
 * <p>
 * If there is no current set of system properties, a set of system properties 
 * is first created and initialized in the same manner as for the {@code getProperties} 
 * method.
 * 
 * @param key The name of the system property.
 * @return    The string value of the system property, or {@code null} if 
 *            there is no property with that key.
 * @throws SecurityException If a security manager exists and its 
 *                           {@code checkPropertyAccess} method doesn't allow 
 *                           access to the specified system property.
 * @throws NullPointerException     If {@code key} is {@code null}.
 * @throws IllegalArgumentException If {@code key} is empty.
 * @see #setSystemProperty(java.lang.String, java.lang.String)
 */
public String getSystemProperty(final String key) throws SecurityException, NullPointerException, IllegalArgumentException;
```

```java
/**
 * Allowed access to the {@code System} properties. Checks if the system property 
 * value equals the parameter value.
 * <p>
 * First, if there is a security manager, its {@code checkPropertyAccess} method 
 * is called with the key as its argument. This may result in a SecurityException.
 * <p>
 * If there is no current set of system properties, a set of system properties 
 * is first created and initialized in the same manner as for the {@code getProperties} 
 * method.
 * 
 * @param key   The name of the system property.
 * @param value The value which should checked against the value from the system.
 * @return      If the value from the key equals the parameter value.
 * @throws SecurityException  If a security manager exists and its 
 *         {@code checkPropertyAccess} method doesn't allow access to the 
 *         specified system property.
 * @throws NullPointerException     If {@code key}is {@code null}.
 * @throws IllegalArgumentException If {@code key} is empty.
 * @see #getSystemProperty(java.lang.String)
 * @see #setSystemProperty(java.lang.String, java.lang.String)
 */
public Boolean isSystemProperty(final String key, final String value) throws SecurityException, NullPointerException, IllegalArgumentException;
```

```java
/**
 * Register with this method your {@code .properties} file.<br>
 * The parameter {@code pathWithBundle} have the format:<br>
 * {@code /your/package/path/to/your/FileToLoad.properties}.
 * <p>
 * The file should be in the {@code src/main/resources} folder with the 
 * previous named packaged structure in the specific maven module.
 * 
 * @param pathWithBundle The properties which should be register. If the 
 *                       properties always register nothing happen.
 */
public void register(final String pathWithBundle);
```

```java
/**
 * Register with this method your {@code .properties} files.<br>
 * The parameter in {@code pathWithBundles} should have the format:<br>
 * {@code /your/package/path/to/your/FileToLoad.properties}.
 * <p>
 * The files should be in the {@code src/main/resources} folder with the 
 * previous named packaged structure in the specific maven module.
 * 
 * @param pathWithBundles The properties which should be register. If the 
 *                        properties always register nothing happen.
 */
public void register(final ArrayList<String> pathWithBundles);
```

```java
/**
 * Register the given {@link java.util.List} as {@code System}properties.
 * Every entry in the {@link java.util.List} will splitted with the regex to 
 * a {@code System} property pair (key, value).
 * 
 * @param regex   The delimiting regular expression.
 * @param unnamed The {@link java.util.List} which will splitted.
 * @throws SecurityException If a security manager exists and its 
 *         {@code checkPropertyAccess} method doesn't allow access to the 
 *         specified system property.
 * @throws NullPointerException     If {@code key}or {@code value} is {@code null}.
 * @throws IllegalArgumentException If {@code key}is empty.
 */
public void registerSystemProperties(final String regex, final List<String> unnamed) throws SecurityException, NullPointerException, IllegalArgumentException;
```

```java
/**
 * Allowed access to the {@code System} properties. Sets the system property 
 * indicated by the specified key.
 * <p>
 * First, if a security manager exists, its {@code SecurityManager.checkPermission}
 * method is called with a {@code PropertyPermission(key, "write")}
 * permission. This may result in a SecurityException being thrown. If no 
 * exception is thrown, the specified property is set to the given value.
 * 
 * @param key   The name of the system property.
 * @param value The value of the system property.
 * @throws SecurityException If a security manager exists and its 
 *         {@code checkPropertyAccess} method doesn't allow access to the 
 *         specified system property.
 * @throws NullPointerException     If {@code key} or {@code value}is {@code null}.
 * @throws IllegalArgumentException If {@code key} is empty.
 * @see #getSystemProperty(java.lang.String)
 */
public void setSystemProperty(final String key, final String value) throws SecurityException, NullPointerException, IllegalArgumentException;
```



Download<a name="Download" />
---

Current `version` is `0.5.1`. Main points in this release are:
* This is a minor update.
* Update dependencies and the documentation.

**Maven coordinates**  
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-properties</artifactId>
        <version>0.5.1</version>
    </dependency>
</dependencies>
```

Download:
* [Release v0.5.1 (01.02.2018 / MM.dd.yyyy)]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Properties]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [lib-properties-0.5.1.jar](#Installation).

In the library are following libraries registered as dependencies:
* The library [lib-logger-0.5.1.jar](#Installation).
  * Included in `Lib-Logger` is the library [log4j-api-2.8.2.jar].
  * Included is `Lib-Logger` is the library [log4j-core-2.8.2.jar].



Installation<a name="Installation" />
---

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download 
    the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Properties].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Documentation<a name="Documentation" />
---

* In section [Api](#Api) you can see the main point(s) to access the functionality 
  in this library.
* For additional information see the [JavaDoc] in the library itself.


Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Properties` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Properties` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[UML-diagram_Lib-Properties_v0.5.0_2017-07-17_21-17]:https://user-images.githubusercontent.com/8161815/28286098-5c85b802-6b37-11e7-8db0-47eed1156c43.png




[//]: # (Links)
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-preferences/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Properties]:https://github.com/Naoghuman/lib-properties
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.8.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Properties]:https://github.com/Naoghuman/lib-properties/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties
[Release v0.5.1 (01.02.2018 / MM.dd.yyyy)]:https://github.com/Naoghuman/lib-properties/releases/tag/v0.5.1
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language


