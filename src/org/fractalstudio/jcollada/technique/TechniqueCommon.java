/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.technique;

/**
 * Copyright (C) 2013 Steffen Evensen
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * Specifies technique information that consuming applications can use if no
 * technique specific to the application is provided in the COLLADA document. In
 * other words, if an element has <technique> child elements for one or more
 * specific profiles, applications reading the COLLADA document should use the
 * technique most appropriate for the application. If none of the specific
 * <technique>s is appropriate, the application must use the element’s
 * <technique_common> instead, if one is specified. Each element’s
 * <technique_common> attributes and children are unique. Refer to each parent
 * element for details.
 *
 * @author Meanz
 */
public class TechniqueCommon {
    
    
    
    public TechniqueCommon() {
        
    }
    
}
