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
package br.com.uol.pagseguro.api.http;

import javax.xml.bind.JAXBException;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.exception.*;
import br.com.uol.pagseguro.api.utils.XMLUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Response of http request
 *
 * @author PagSeguro Internet Ltda.
 */
public class HttpResponse {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private final String responseAsString;

  private final int status;

  static {
    // In order to serialize/deserialize java.time.*
    OBJECT_MAPPER.registerModule(new JavaTimeModule());
  }

  /**
   * Constructor
   *
   * @param status           Status
   * @param responseAsString Response as string
   */
  public HttpResponse(int status, String responseAsString) {
    this.status = status;
    this.responseAsString = responseAsString;
  }

  /**
   * Get status
   *
   * @return Status
   */
  public int getStatus() {
    return status;
  }

  /**
   * Get status family
   *
   * @return Status family
   */
  public HttpStatusFamily getStatusFamily() {
    return HttpStatusFamily.fromStatus(status);
  }

  /**
   * Get response as string
   *
   * @return Response as string
   */
  public String asString() {
    return responseAsString;
  }

  /**
   * Parse JSON content
   *
   * @param targetClazz Class to be converted
   * @param <T>         Class converted
   * @return Response converted
   */
  public <T> T parseJSONContent(Class<T> targetClazz) {
    if (getStatusFamily() == HttpStatusFamily.SUCCESSFUL) {
      try {
        return OBJECT_MAPPER.readValue(asString(), targetClazz);
      } catch (JsonProcessingException e) {
        throw new PagSeguroLibException(e);
      }
    }

    throwJSONErrorFromContent();
    return null;
  }

  /**
   * Parse xml content
   *
   * @param pagSeguro   Pagseguro instance
   * @param targetClazz Class to be converted
   * @param <T>         Class converted
   * @return Response converted
   */
  public <T> T parseXMLContent(PagSeguro pagSeguro, Class<T> targetClazz) {
    if (getStatusFamily() == HttpStatusFamily.SUCCESSFUL) {
      try {
        return XMLUtils.unmarshal(pagSeguro, targetClazz, asString());
      } catch (JAXBException e) {
        throw new PagSeguroLibException(e);
      }
    }

    throwXMLErrorFromContent(pagSeguro);
    return null;
  }

  /**
   * Parse xml content when there's no body
   *
   * @param pagSeguro   Pagseguro instance
   * @param <T>         Class converted
   * @return Response converted
   */
  public <T> T parseXMLContentNoBody(PagSeguro pagSeguro) {
    if (getStatusFamily() == HttpStatusFamily.SUCCESSFUL) {
      return null;
    }

    throwXMLErrorFromContent(pagSeguro);
    return null;
  }

  private void throwXMLErrorFromContent(PagSeguro pagSeguro) {
    if (HttpStatusFamily.CLIENT_ERROR == getStatusFamily() && 400 == getStatus()) {
      try {
        throw new PagSeguroBadRequestException(this, XMLUtils.unmarshal(pagSeguro,
                ServerErrorsXML.class, asString()));
      } catch (JAXBException e) {
        throw new PagSeguroLibException(e);
      }
    }

    throwGenericHttpStatusExceptions();
  }

  private void throwJSONErrorFromContent() {
    if (HttpStatusFamily.CLIENT_ERROR == getStatusFamily() && 400 == getStatus()) {
      try {
        throw new PagSeguroBadRequestException(this,
                OBJECT_MAPPER.readValue(asString(), ServerErrorsJSON.class));
      } catch (JsonProcessingException e) {
        throw new PagSeguroLibException(e);
      }
    }

    throwGenericHttpStatusExceptions();
  }

  private void throwGenericHttpStatusExceptions() {
    switch (getStatusFamily()) {
      case CLIENT_ERROR:
        switch (getStatus()) {
          case 401:
            throw new PagSeguroUnauthorizedException(this);
          case 403:
            throw new PagSeguroForbiddenException(this);
        }
      case SERVER_ERROR:
        if (getStatus() == 503) {
          throw new PagSeguroServiceUnavailableException(this);
        }
      default:
        throw new PagSeguroInternalServerException(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof HttpResponse)) return false;

    HttpResponse response = (HttpResponse) o;

    if (status != response.status) return false;
    return responseAsString != null
           ? responseAsString.equals(response.responseAsString)
           : response.responseAsString == null;

  }

  @Override
  public String toString() {
    return "HttpResponse{" +
        "responseAsString='" + responseAsString + '\'' +
        ", status=" + status +
        '}';
  }
}
