/*
 * Copyright (C) 2014 PRo
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

package de.pro.lib.properties.api;

import java.util.List;

/**
 * The <code>Interface</code> for the class {@link de.pro.lib.properties.LibProperties}.<br />
 * Over the facade {@link de.pro.lib.properties.api.PropertiesFacade} you can 
 * access the methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.properties.LibProperties
 * @see de.pro.lib.properties.api.PropertiesFacade
 */
public interface ILibProperties {
    
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
    public void registerSystemProperties(String regex, List<String> unnamed) throws SecurityException, NullPointerException, IllegalArgumentException ;
    
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

}
