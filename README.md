Lib-Properties
===

Lib-Properties is a library for `easy` loading [properties] in a [JavaFX] &amp; 
[Maven] desktop application.

Current `version` is `0.2.0` (07.2015).



Content
---

* [Examples](#Examples)
    - [How to register a resource bundle](#HowToRegisterAResourceBundle)
    - [How to access a value from the resource bundle](#HowToAccessAValueFromTheResourceBundle)
* [Api](#Api)
    - [de.pro.lib.properties.api.PropertiesFacade](#PropertiesFacade)
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

### How to register a resource bundle<a name="HowToRegisterAResourceBundle" />

```java
public interface IApplicationConfiguration {
    ...
    public static final String DBW__RESOURCE_BUNDLE = "/de/pro/dbw/application/DreamBetterWorlds.properties"; // NOI18N
}

public class DreamBetterWorlds extends Application implements IApplicationConfiguration, IPreferencesConfiguration {
    @Override
    public void init() throws Exception {
        PropertiesFacade.INSTANCE.register(DBW__RESOURCE_BUNDLE);
        ...
    }

    ...
}
```


### How to access a value from the resource bundle<a name="HowToAccessAValueFromTheResourceBundle" />

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
        return PropertiesFacade.INSTANCE.getProperty(DBW__RESOURCE_BUNDLE, propertyKey);
    }
    ...
}
```



Api<a name="Api" />
---

### de.pro.lib.properties.api.PropertiesFacade<a name="PropertiesFacade" />

```java
/**
 * The facade {@link de.pro.lib.properties.api.PropertiesFacade} provides access
 * to the properties methods during the Interface 
 * {@link de.pro.lib.properties.api.ILibProperties}.
 *
 * @author PRo
 * @see de.pro.lib.properties.api.ILibProperties
 */
public enum PropertiesFacade implements ILibProperties
```


```java
/**
 * Searches for the property with the specified key in this property list.<br />
 * If the key is not found in this property list, the default property list,
 * and its defaults, recursively, are then checked. The method returns
 * {@code null} if the property is not found.
 * 
 * @param pathWithBundle The properties where value is stored.
 * @param key The property key.
 * @return The value in this property list with the specified key value.
 */
public String getProperty(String pathWithBundle, String key);
```


```java
/**
 * Searches for the property with the specified key in this property list.<br />
 * If the key is not found in this property list, the default property list,
 * and its defaults, recursively, are then checked. The method returns the
 * default value argument if the property is not found.
 * 
 * @param pathWithBundle The properties where value is stored.
 * @param key The property key.
 * @param defaultValue If the key-value pair not stored in the properties
 * then the <code>defaultValue</code> will be returned.
 * @return The value in this property list with the specified key value.
 */
public String getProperty(String pathWithBundle, String key, String defaultValue);
```


```java
/**
 * Allowed access to the <code>System</code> properties. Gets the system property 
 * indicated by the specified key.
 * <p>
 * First, if there is a security manager, its <code>checkPropertyAccess</code> 
 * method is called with the key as its argument. This may result in a SecurityException.
 * <p>
 * If there is no current set of system properties, a set of system properties 
 * is first created and initialized in the same manner as for the 
 * <code>getProperties</code> method.
 * 
 * @param key The name of the system property.
 * @return The string value of the system property, or <code>null</code> if 
 * there is no property with that key.
 * @throws SecurityException  if a security manager exists and its 
 * <code>checkPropertyAccess</code> method doesn't allow access to the 
 * specified system property.
 * @throws NullPointerException If <code>key</code> is <code>null</code>.
 * @throws IllegalArgumentException If <code>key</code> is empty.
 * @see #setSystemProperty(java.lang.String, java.lang.String)
 */
public String getSystemProperty(String key) throws SecurityException, NullPointerException, IllegalArgumentException;
```


```java
/**
 * Allowed access to the <code>System</code> properties. Checks if the system 
 * property value equals the parameter value.
 * <p>
 * First, if there is a security manager, its <code>checkPropertyAccess</code> 
 * method is called with the key as its argument. This may result in a SecurityException.
 * <p>
 * If there is no current set of system properties, a set of system properties 
 * is first created and initialized in the same manner as for the 
 * <code>getProperties</code> method.
 * 
 * @param key The name of the system property.
 * @param value The value which should checked against the value from the 
 * system.
 * @return If the value from the key equals the parameter value.
 * @throws SecurityException  if a security manager exists and its 
 * <code>checkPropertyAccess</code> method doesn't allow access to the 
 * specified system property.
 * @throws NullPointerException If <code>key</code> is <code>null</code>.
 * @throws IllegalArgumentException If <code>key</code> is empty.
 * @see #getSystemProperty(java.lang.String)
 * @see #setSystemProperty(java.lang.String, java.lang.String)
 */
public Boolean isSystemProperty(String key, String value) throws SecurityException, NullPointerException, IllegalArgumentException;
```


```java
/**
 * Register with this method your <code>.properties</code> file.<br />
 * The parameter <code>pathWithBundle</code> have the format:<br />
 * <code>/your/package/path/to/your/FileToLoad.properties</code><br /><br />
 * 
 * The file should be in the <code>src/main/resources</code> folder with the 
 * previous named packaged structure in the specific maven module.
 * 
 * @param pathWithBundle The properties which should be register. If the 
 * properties always register nothing happen.
 */
public void register(String pathWithBundle);
```


```java
/**
 * Register the given {@link java.util.List} as <code>System</code> properties.
 * Every entry in the {@link java.util.List} will splitted with the regex to 
 * a <code>System</code> property pair (key, value).
 * 
 * @param regex The delimiting regular expression.
 * @param unnamed The {@link java.util.List} which will splitted.
 * @throws SecurityException If a security manager exists and its 
 * <code>checkPropertyAccess</code> method doesn't allow access to the 
 * specified system property.
 * @throws NullPointerException If <code>key</code> or <code>value</code> 
 * is <code>null</code>.
 * @throws IllegalArgumentException If <code>key</code> is empty.
 */
public void registerSystemProperties(String regex, List<String> unnamed) throws SecurityException, NullPointerException, IllegalArgumentException;
```


```java
/**
 * Allowed access to the <code>System</code> properties. Sets the system property 
 * indicated by the specified key.
 * <p>
 * First, if a security manager exists, its <code>SecurityManager.checkPermission</code> 
 * method is called with a <code>PropertyPermission(key, "write")</code>
 * permission. This may result in a SecurityException being thrown. If no 
 * exception is thrown, the specified property is set to the given value.
 * 
 * @param key The name of the system property.
 * @param value The value of the system property.
 * @throws SecurityException  if a security manager exists and its 
 * <code>checkPropertyAccess</code> method doesn't allow access to the 
 * specified system property.
 * @throws NullPointerException If <code>key</code> or <code>value</code> 
 * is <code>null</code>.
 * @throws IllegalArgumentException If <code>key</code> is empty.
 * @see #getSystemProperty(java.lang.String)
 */
public void setSystemProperty(String key, String value) throws SecurityException, NullPointerException, IllegalArgumentException;
```



Download<a name="Download" />
---

Current `version` is `0.2.0`. Main points in this release are:
* With this release `PropertiesFacade` is now an `enum singleton facade`.
* So instead `PropertiesFacade.getDefault()` now `PropertiesFacade.INSTANCE.getPreferences()` 
  is to use.

Download:
* [Release v0.2.0 (07.2015)]

An overview about all existings releases can be found here:
* [Overview from all releases in Lib-Properties]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Properties-0.2.0.jar](#Installation).
* The library [Lib-Logger-0.2.0.jar](#Installation).
  * Included is the [log4j-api-2.3.jar].
  * Included is the [log4j-core-2.3.jar].



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



[//]: # (Links)
[Eclipse]:https://www.eclipse.org/
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-preferences/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://www.oracle.com/technetwork/java/javase/downloads/index.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Properties]:https://github.com/Naoghuman/lib-properties
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[log4j-api-2.3.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.3.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Properties]:https://github.com/Naoghuman/lib-properties/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties
[Release v0.2.0 (07.2015)]:https://github.com/Naoghuman/lib-properties/releases/tag/v0.2.0


