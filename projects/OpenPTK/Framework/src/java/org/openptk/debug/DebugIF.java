/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *      Portions Copyright 2007-2009 Sun Microsystems, Inc.
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

package org.openptk.debug;

//===================================================================
public interface DebugIF
//===================================================================
{
   public static final String INDENT = "   ";
   public static final String INDENT_1 = INDENT;
   public static final String INDENT_2 = INDENT_1 + INDENT;
   public static final String INDENT_3 = INDENT_2 + INDENT;
   public static final String INDENT_4 = INDENT_3 + INDENT;
   public static final String INDENT_5 = INDENT_4 + INDENT;
   public static final String NULL  = "(not set)";
   public static final int NONE = 0;
   public static final int CONFIG = 1;
   public static final int FINE = 2;
   public static final int FINER = 3;
   public static final int FINEST = 4;


   /**
    * @param obj
    * @param callerId
    */
   public void logData(Object obj, String callerId);

   /**
    * @param obj
    * @param callerId
    * @return
    */
   public String getData(Object obj, String callerId);

   /**
    * @param obj
    * @param callerId
    * @param ident
    * @return
    */
   public String getData(Object obj, String callerId, String ident);
}
