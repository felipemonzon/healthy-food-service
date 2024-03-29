package com.moontech.healthyfood.models.responses;

import java.io.Serializable;
import lombok.Data;

/**
 * Respuesta de la API de parámetros.
 *
 * @author Felipe Monzón
 * @enterprise moontech
 * @since 23 jul., 2022
 */
@Data
public class ParameterResponse implements Serializable {
  /** Identificador del parámetro. */
  private String id;
  /** Descripción del parámetro. */
  private String description;
  /** Valor del parámetro. */
  private String value;
  /** Status del parámetro. */
  private boolean status;
}
