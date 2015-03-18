Lib-Properties
==============

A library for `easy` loading [properties] in a [JavaFX] &amp; [Maven] application.


Current `version` is `0.1.0` (03.2015).



Content
-------

* [Example](#Example)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Documentation](#Documentation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Example<a name="Example" />
-------

```java
/**
 * The facade {@link de.pro.lib.properties.api.PropertiesFacade} provides a 
 * singleton instance of the Interface {@link de.pro.lib.properties.api.IProperties}.
 *
 * @author PRo
 * @see de.pro.lib.properties.api.IProperties
 */
public final class PropertiesFacacde
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
PropertiesFacacde.getDefault().register(String pathWithBundle);
```

```java
/**
 * Searches for the property with the specified key in this property list.
 * If the key is not found in this property list, the default property list,
 * and its defaults, recursively, are then checked. The method returns
 * {@code null} if the property is not found.
 * 
 * @param pathWithBundle The properties where value is stored.
 * @param key The property key.
 * @return The value in this property list with the specified key value.
 */
PropertiesFacacde.getDefault().getProperty(String pathWithBundle, String key);
```

```java
/**
 * Searches for the property with the specified key in this property list.
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
PropertiesFacacde.getDefault().getProperty(String pathWithBundle, String key, String defaultValue);
```


Requirements<a name="Requirements" />
------------

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [Lib-Properties-0.1.0.jar](#Installation).
* The library [Lib-Logger-0.1.0.jar](#Installation).
  * Included is the [log4j-api-2.2.jar].
  * Included is the [log4j-core-2.2.jar].



Installation<a name="Installation" />
------------

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for development.
* Download or clone [Lib-Properties].
* Download or clone [Lib-Logger].
* Open the projects in your IDE and run them.



Documentation<a name="Documentation" />
-------------

Momentary only the [JavaDoc] in the library itself is available.



Contribution<a name="Contribution" />
------------

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
-------

The project `Lib-Properties` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
-----

The project `Lib-Properties` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
-------

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
[log4j-api-2.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[log4j-core-2.2.jar]:https://logging.apache.org/log4j/2.0/log4j-web/dependencies.html
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests
[properties]:http://en.wikipedia.org/wiki/.properties


