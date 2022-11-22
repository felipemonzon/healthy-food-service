package com.moontech.healthyfood.utilities;

import com.moontech.healthyfood.constants.ApiConstant;
import org.springframework.data.domain.Pageable;

/**
 * Clase de utilerías.
 *
 * @author Felipe Monzón
 * @since Dec 17, 2021
 */
public abstract class Utilities {
  /** Formato de salida de la respuesta de error. */
  public static final String ERROR_DATE_PATTER = "yyyy-MM-dd HH:mm:ss";
  /** Espacio en blanco. */
  public static final String WHITE_SPACE = " ";

  /**
   * Obtiene la pagina actual.
   *
   * @param pageable datos de paginación
   * @return pagina actual
   */
  public static int getCurrentPage(Pageable pageable) {
    int page = pageable.getPageNumber();
    if (pageable.getPageNumber() != ApiConstant.INT_ZERO_VALUE) {
      page -= ApiConstant.INT_ONE_VALUE;
    }
    return page;
  }

  /** Constructor privado. */
  private Utilities() {}
}