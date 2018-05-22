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
package org.openspml.v2.msg.spmlasync;

import org.openspml.v2.msg.OCEtoMarshallableAdapter;
import org.openspml.v2.msg.spml.ErrorCode;
import org.openspml.v2.msg.spml.Response;
import org.openspml.v2.msg.spml.StatusCode;
import org.openspml.v2.util.Spml2Exception;
import org.openspml.v2.util.xml.ArrayListWithType;
import org.openspml.v2.util.xml.ListWithType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <br>&lt;complexType name="StatusResponseType"&gt;
 * <br>&lt;complexContent&gt;
 * <br>&lt;extension base="spml:ResponseType"&gt;
 * <br>&lt;attribute name="asyncRequestID" type="xsd:string" use="optional"/&gt;
 * <br>&lt;/extension&gt;
 * <br>&lt;/complexContent&gt;
 * <br>&lt;/complexType&gt;
 *
 * @author kent.spaulding@sun.com
 *         <p/>
 *         Date: Feb 15, 2006
 */
public class StatusResponse extends BasicResponse {

    private static final String code_id = "$Id: StatusResponse.java,v 1.6 2006/08/30 18:02:59 kas Exp $";

    public StatusResponse() { ; }

    public StatusResponse(String[] errorMessages,
                          StatusCode status,
                          String requestId,
                          ErrorCode errorCode,
                          String asyncRequestID) {
        super(errorMessages,
              status,
              requestId,
              errorCode,
              asyncRequestID,
              false);
    }
    
    private ListWithType m_response = new ArrayListWithType(Response.class);

    public void addResponse(Response resp) throws Spml2Exception {
        if (resp != null) {
            m_response.add(resp);
//            this.addOpenContentElement(new OCEtoMarshallableAdapter(resp));
        }
    }

    public boolean removeResponse(Response resp) {
        return m_response.remove(resp);
    }

    public void clearResponses() {
        m_response.clear();
    }
    
    public List getRawResponses() {
        return m_response;
    }
    
    public List getResponses() {
		ArrayList responses = new ArrayList();
		
		Iterator rawResponseIterator = this.getRawResponses().iterator();
		
		try {
			for (; rawResponseIterator.hasNext(); ) {
				Object o = rawResponseIterator.next();
				if (o instanceof Response) {
					responses.add((Response)o);
				}
				else  if (o instanceof OCEtoMarshallableAdapter) {
					OCEtoMarshallableAdapter oc = 
						(OCEtoMarshallableAdapter)o;
					Object adaptedObject = oc.getAdaptedObject();
					if (adaptedObject instanceof Response) {
						responses.add((Response)adaptedObject);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return responses;
    }
    
    public Iterator responseIterator() {
    	//return m_response.iterator();
    	
		Iterator responseIterator = getResponses().iterator();    
		
		return responseIterator;
    	
    	//return this.getOpenContentElements(Response.class).iterator();
    }
    
    

}
