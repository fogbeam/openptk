/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *      Portions Copyright 2012 Project OpenPTK
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
package org.openptk.jaxrs;

import javax.servlet.ServletContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.openptk.api.Opcode;
import org.openptk.representation.RepresentationType;
import org.openptk.structure.BasicStructure;
import org.openptk.structure.StructureIF;

/**
 *
 * @author Scott Fehrman
 */

//===================================================================
public class DecidersResource extends Resource
//===================================================================
{

   private String CLASS_NAME = this.getClass().getSimpleName();


   /**
    * @param ctx
    * @param uri
    */
   //----------------------------------------------------------------
   public DecidersResource(@Context ServletContext ctx, @Context UriInfo uri)
   //----------------------------------------------------------------
   {
      super(ctx, uri);

      _struct = new BasicStructure(StructureIF.NAME_REQUEST);

      return;
   }


   /**
    * @param ctx
    * @param uri
    * @param struct
    */
   //----------------------------------------------------------------
   public DecidersResource(ServletContext ctx, UriInfo uri, StructureIF struct)
   //----------------------------------------------------------------
   {
      super(ctx, uri);
      String METHOD_NAME = CLASS_NAME + ":DecidersResource(): ";
      String msg = null;

      if (struct == null)
      {
         msg = METHOD_NAME + "Structure is null.";
         throw new WebApplicationException(new Exception(msg), Response.Status.INTERNAL_SERVER_ERROR);
      }

      _type = RepresentationType.DECIDER;
      _struct = struct;

      return;
   }

   /**
    * @param deciderId
    * @return
    */
   @Path("/{" + StructureIF.NAME_DECIDERID + "}")
   //----------------------------------------------------------------
   public DeciderResource getDeciderResource(@PathParam(StructureIF.NAME_DECIDERID) String deciderId)
   //----------------------------------------------------------------
   {
      DeciderResource resource = null;

      resource = new DeciderResource(_ctx, _uri, _struct);

      return resource;
   }

   /**
    * @param hdrs
    * @return
    */
   @GET
   @Produces(
   {
      MediaType.TEXT_PLAIN,
      MediaType.TEXT_HTML,
      MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML
   })
   //----------------------------------------------------------------
   public Response search(@Context HttpHeaders hdrs)
   //----------------------------------------------------------------
   {
      Response response = null;

      response = this.execute(Opcode.SEARCH, _type, hdrs);

      return response;
   }
}
