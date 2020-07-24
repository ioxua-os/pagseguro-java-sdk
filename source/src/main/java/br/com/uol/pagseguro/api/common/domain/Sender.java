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
package br.com.uol.pagseguro.api.common.domain;

import java.util.List;

/**
 * Interface for Sender. This class contains the buyer data.
 *
 * @author PagSeguro Internet Ltda.
 */
public interface Sender {

  /**
   * Get email of sender
   *
   * @return Email
   */
  String getEmail();

  /**
   * Get name of sender
   *
   * @return Name
   */
  String getName();

  /**
   * Get phone of sender
   *
   * @return Phone
   * @see Phone
   */
  Phone getPhone();

  /**
   * Get address of sender
   *
   * @return Address
   * @see Address
   */
  Address getAddress();

  /**
   * Get cpf of sender
   *
   * @return Cpf
   */
  String getCpf();

  /**
   * Get cpf of sender
   *
   * @return Cpf
   */
  String getCnpj();

  /**
   * Get hash of sender
   *
   * @return Hash
   */
  String getHash();

  /**
   * Get the IP of sender
   * @return Ip
   */
  String getIp();

  /**
   * Get documents of sender
   *
   * @return Documents
   * @see Document
   */
  List<? extends Document> getDocuments();
}
