/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *      Portions Copyright 2010-2011 Project OpenPTK
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

package org.openptk.exception;

/**
 * Security Authorization related Exceptions.
 */

//===================================================================
public class AuthorizationException extends Exception
//===================================================================
{
   public static final long serialVersionUID = 200L;
   
   /**
    * Create a new AuthorizationException, use the provided message.
    * @param message a description of the exception
    */

   //----------------------------------------------------------------
   public AuthorizationException(String message)
   //----------------------------------------------------------------
   {
      super(message);
   }

   
   /**
    * Create a new AuthorizationException, use the provided Exception.
    * @param ex an existing Exception (Throwable)
    */
   
   //----------------------------------------------------------------
   public AuthorizationException(Throwable ex)
   //----------------------------------------------------------------
   {
      super(ex);
   }
   

}
