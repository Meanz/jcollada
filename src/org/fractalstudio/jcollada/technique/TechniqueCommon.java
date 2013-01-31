/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fractalstudio.jcollada.technique;

/**
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
