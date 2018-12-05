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

import com.github.naoghuman.lib.properties.internal.DefaultSimpleProperties;
import com.github.naoghuman.lib.properties.internal.DefaultSimplePropertiesValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
public final class PropertiesFacade implements SimpleProperties {
    
    private static final Optional<PropertiesFacade> instance = Optional.of(new PropertiesFacade());

    /**
     * Returns a singleton instance from the {@code Class} {@code PropertiesFacade}.
     * 
     * @return a singleton instance from the {@code Class} {@code PropertiesFacade}.
     */
    public static final PropertiesFacade getDefault() {
        return instance.get();
    }
    
    private SimpleProperties properties = null;
    
    private PropertiesFacade() {
        this.initialize();
    }
    
    private void initialize() {
        properties = new DefaultSimpleProperties();
    }

    @Override
    public String getProperty(final String pathWithBundle, final String key) {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(pathWithBundle);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        
        return properties.getProperty(pathWithBundle, key);
    }

    @Override
    public String getProperty(final String pathWithBundle, final String key, final String defaultValue) {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(pathWithBundle);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(defaultValue);
        
        return properties.getProperty(pathWithBundle, key, defaultValue);
    }

    @Override
    public String getSystemProperty(final String key) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        
        return properties.getSystemProperty(key);
    }

    @Override
    public Boolean isSystemProperty(final String key, final String value) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(value);
        
        return properties.isSystemProperty(key, value);
    }

    @Override
    public void register(final String pathWithBundle) {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(pathWithBundle);
        
        properties.register(pathWithBundle);
    }

    @Override
    public void register(final ArrayList<String> pathWithBundles) {
        DefaultSimplePropertiesValidator.requireNonNull(pathWithBundles);
        
        properties.register(pathWithBundles);
    }

    @Override
    public void registerSystemProperties(final String regex, final List<String> unnamed) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(regex);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(unnamed);
        
        properties.registerSystemProperties(regex, unnamed);
    }

    @Override
    public void setSystemProperty(final String key, final String value) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(value);
        
        properties.setSystemProperty(key, value);
    }
    
}
