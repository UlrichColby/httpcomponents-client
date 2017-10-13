/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.http.impl.auth;

import org.apache.http.impl.auth.GGSSchemeBase.Option;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGGSSchemeBase {

    @Before
    public void restoreDefault()
    {
        GGSSchemeBase.setDefaultRequestDelegCreds(Option.DEFAULT);
    }

    @Test
    public void TestDefaultRequestDelegCredsValue()
    {
        Assert.assertEquals(Option.DEFAULT, GGSSchemeBase.getDefaultRequestDelegCreds());
        GGSSchemeBase.setDefaultRequestDelegCreds(Option.DISABLE);
        Assert.assertEquals(Option.DISABLE, GGSSchemeBase.getDefaultRequestDelegCreds());
        GGSSchemeBase.setDefaultRequestDelegCreds(Option.ENABLE);
        Assert.assertEquals(Option.ENABLE, GGSSchemeBase.getDefaultRequestDelegCreds());
    }

    @Test
    public void TestRequestDelegCredsValue()
    {
       GGSSchemeBase gssScheme = getSampleObject();
       Assert.assertEquals(Option.DEFAULT, gssScheme.getRequestDelegCreds());
       //Now change the default scheme
       GGSSchemeBase.setDefaultRequestDelegCreds(Option.ENABLE);
       gssScheme = getSampleObject();
       Assert.assertEquals(Option.ENABLE, gssScheme.getRequestDelegCreds());
       //Test other option
       GGSSchemeBase.setDefaultRequestDelegCreds(Option.DISABLE);
       gssScheme = getSampleObject();
       Assert.assertEquals(Option.DISABLE, gssScheme.getRequestDelegCreds());
    }

    private static GGSSchemeBase getSampleObject()
    {
        return new GGSSchemeBase() {

            @Override
            public String getSchemeName() {
                return null;
            }

            @Override
            public String getParameter(final String name) {
                return null;
            }

            @Override
            public String getRealm() {
                return null;
            }

            @Override
            public boolean isConnectionBased() {
                return false;
            }
        };
    }
}
