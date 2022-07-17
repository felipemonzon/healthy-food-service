/*
 * Copyright (c) 2021 Sano PAk
 *
 * Licensed under the GNU General Public License, Version 3 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.gnu.org/licenses/gpl-3.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.moontech.library.exceptions.custom;

/**
 * Excepción de negocio.
 *
 * @author Felipe Monzón
 * @since Dec 18, 2021
 */
public class BusinessException extends RuntimeException {
  /** Serial. */
  private static final long serialVersionUID = -6450278167900735942L;
  /** Código de error. */
  private int code;

  /** Constructor de la clase. */
  public BusinessException() {
    super();
  }

  /**
   * Constructor de la clase.
   *
   * @param message mensaje de error
   */
  public BusinessException(String message) {
    super(message);
  }

  /**
   * Constructor de la clase.
   *
   * @param code código de error
   * @param message mensaje de error
   */
  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  /**
   * Obtiene el código de error
   *
   * @return código de error
   */
  public int getCode() {
    return code;
  }
}
