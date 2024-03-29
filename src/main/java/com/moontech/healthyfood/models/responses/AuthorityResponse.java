package com.moontech.healthyfood.models.responses;

import java.io.Serializable;
import lombok.Data;

/**
 * Respuesta para roles.
 *
 * @author Felipe Monzón
 * @enterprise moontech
 * @since 17 nov., 2022
 */
@Data
public class AuthorityResponse implements Serializable {
  /** Identificador del perfil. */
  private long id;
  /** Descripción del perfil. */
  private String name;
  /** Valor del perfil. */
  private String value;
}
