package com.moontech.healthyfood.services;

import com.moontech.healthyfood.models.requests.OfficeRequest;
import com.moontech.healthyfood.models.responses.OfficeResponse;
import java.util.List;

/**
 * Reglas de negocio del módulo de sucursales.
 *
 * @author Felipe Monzón
 * @enterprise moontech
 * @since 17 jul., 2022
 */
public interface OfficeService {
  /**
   * Consulta todas las sucursales.
   *
   * @return lista de sucursales
   */
  List<OfficeResponse> retrieve();

  /**
   * Guarda los datos de una sucursal.
   *
   * @param request datos de la sucursal
   */
  void create(OfficeRequest request);

  /**
   * Actualiza los datos de una sucursal.
   *
   * @param id identificador de la sucursal
   * @param request datos de la sucursal
   */
  void update(Long id, OfficeRequest request);

  /**
   * Consulta una sucursal por: *
   *
   * <ul>
   *   <li>Nombre
   *   <li>Teléfono
   *   <li>Dirección
   * </ul>
   *
   * @param search identificador de la sucursal
   * @return lista de sucursales encontrada {@link OfficeResponse}
   */
  List<OfficeResponse> findBy(String search);

  /**
   * Consulta el nombre de la sucursal.
   *
   * @param idOffice identificador de la sucursal
   * @return nombre de la sucursal
   */
  String getOfficeName(final Long idOffice);
}
