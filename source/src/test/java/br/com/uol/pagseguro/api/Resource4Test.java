/*
 * 2007-2016 [PagSeguro Internet Ltda.]
 *
 * NOTICE OF LICENSE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright: 2007-2016 PagSeguro Internet Ltda.
 * Licence: http://www.apache.org/licenses/LICENSE-2.0
 */

package br.com.uol.pagseguro.api;

import br.com.uol.pagseguro.api.credential.Credential;
import br.com.uol.pagseguro.api.http.HttpClient;
import br.com.uol.pagseguro.api.utils.logging.Log;
import br.com.uol.pagseguro.api.utils.logging.LoggerFactory;
import org.junit.Before;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


/**
 * @author PagSeguro Internet Ltda.
 */
@PrepareForTest({LoggerFactory.class})
public class Resource4Test extends BaseTestClassWithPowerMockFix {

  @Mock
  protected HttpClient httpClient;

  @Mock
  protected LoggerFactory loggerFactory;

  @Mock
  protected Log logger;

  protected PagSeguro pagSeguro;

  @Before
  public void setUpResource() throws Exception {
    PowerMockito.mockStatic(LoggerFactory.class);
    when(LoggerFactory.getLogger(anyString())).thenReturn(logger);
    when(LoggerFactory.getLogger(any(Class.class))).thenReturn(logger);

    pagSeguro = PagSeguro.instance(loggerFactory, httpClient, Credential.sellerCredential("email", "token"),
        PagSeguroEnv.SANDBOX);
  }
}
