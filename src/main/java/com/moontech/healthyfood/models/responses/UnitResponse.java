package com.moontech.healthyfood.models.responses;

import java.io.Serializable;
import lombok.Data;

/**
 * Respuesta de la API de units.
 *
 * @author Felipe Monzón
 * @enterprise moontech
 * @since 23 jul., 2022
 */
@Data
public class UnitResponse implements Serializable {
  /** Identificador de la unidad. */
  private Long id;
  /** Nombre de la unidad. */
  private String name;
  /** Abreviación de la unidad. */
  private String abbreviation;
  /** Status de la unidad. */
  private boolean status;
}
