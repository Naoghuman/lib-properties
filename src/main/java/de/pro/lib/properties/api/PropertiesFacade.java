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

import de.pro.lib.properties.LibProperties;

/**
 * The facade {@link de.pro.lib.properties.api.PropertiesFacade} provides access
 * to the properties methods during the Interface 
 * {@link de.pro.lib.properties.api.ILibProperties}.
 *
 * @author PRo
 * @see de.pro.lib.properties.api.ILibProperties
 */
public enum PropertiesFacade {

    /**
     * Over the value <code>INSTANCE</code> the developer have access to the
     * singleton instance from the <code>PropertiesFacade</code>.
     */
    INSTANCE;
    
    private ILibProperties properties = null;
    
    private PropertiesFacade() {
        this.initialize();
    }
    
    private void initialize() {
        properties = new LibProperties();
    }

    /**
     * Over the {@link de.pro.lib.properties.api.ILibProperties} the developer 
     * have access to the properties methods.
     * 
     * @return a singleton instance from ILibProperties.
     */
    public ILibProperties getProperties() {
        return properties;
    }
    
}
