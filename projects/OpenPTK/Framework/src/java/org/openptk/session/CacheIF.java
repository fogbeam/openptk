/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *      Portions Copyright 2009-2010 Sun Microsystems, Inc.
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/openptk/resource/legal-notices/OpenPTK.LICENSE
 * or https://openptk.dev.java.net/OpenPTK.LICENSE.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the reference to
 * trunk/openptk/resource/legal-notices/OpenPTK.LICENSE. If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 */

/*
 * Project OpenPTK Founders: Scott Fehrman, Derrick Harcey, Terry Sigle
 */
package org.openptk.session;

import org.openptk.common.ComponentIF;

/**
 *
 * @author Scott Fehrman, Sun Microsystems, Inc.
 */

//===================================================================
public interface CacheIF extends ComponentIF
//===================================================================
{
   public long DEFAULT_TTL = 1000 * 60 * 2; // milliseconds (2 minutes)

   /**
    * @return
    */
   @Override
   public CacheIF copy();

   /**
    * @return
    */
   public boolean isExpired();

   /**
    * @param value
    */
   public void setValue(Object value);

   /**
    * @return
    */
   public Object getValue();

   /**
    * @return
    */
   public Long getCreated();

   /**
    * @return
    */
   public Long getUpdated();

   /**
    * @return
    */
   public Long getAccessed();
}
