/*
 * Copyright (C) 2014 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.properties.core;

import java.util.ArrayList;
import java.util.List;

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
public interface SimpleProperties {
    
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

}
