/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * Copyright 2009 Sun Microsystems, Inc.  All Rights Reserved.
 * 
 * This file is available and licensed under the following license:
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer. 
 * 
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution. 
 * 
 * Neither the name of Sun Microsystems nor the names of its contributors may be
 * used to endorse or promote products derived from this software without specific
 * prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.openspml.v2.profiles.dsml;

import org.openspml.v2.util.xml.XmlBuffer;

import java.util.Map;


/**
 * A FilterItem that is a present element.
 *   This is where Java and the xsd disagree - the type in the
 *   xsd is about layout and not behavior.  We don't want Present
 *   object to be useful for variables declared as type AttributeDescription.
 * <p/>
 * <pre>
 * &lt;xsd:element name="present" type="AttributeDescription"/&gt;
 * </pre>
 */
public class Present extends NamedFilterItem {

    private static final String code_id = "$Id: Present.java,v 1.7 2006/06/29 22:31:46 kas Exp $";

    protected void toXML(XmlBuffer buffer) throws DSMLProfileException {
        buffer.addOpenStartTag("present");
        buffer.addAttribute("name", getName());
        buffer.closeEmptyElement();
    }

    public Present() {
    }

    public Present(String name) throws DSMLProfileException {
        super(name);
    }

    public boolean matches(Map attrs) throws DSMLProfileException {
        return attrs.containsKey(getName());
    }

    public void accept(FilterItemVisitor visitor) throws DSMLProfileException {
        visitor.visitPresent(this);
    }
}
