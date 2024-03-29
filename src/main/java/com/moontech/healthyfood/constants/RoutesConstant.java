package com.moontech.healthyfood.constants;

/**
 * Constantes de rutas
 *
 * @author Felipe Monzón
 * @since Jan 20. 2022
 */
public abstract class RoutesConstant {
  /** Ruta base para usuarios. */
  public static final String USERS_BASE_PATH = "${api.uri.domain.users}";
  /** Ruta base para sucursales. */
  public static final String OFFICE_BASE_PATH = "${api.uri.domain.offices}";
  /** Ruta base para proveedores. */
  public static final String SUPPLIER_BASE_PATH = "${api.uri.domain.supplier}";
  /** Ruta base para parámetros. */
  public static final String PARAMETER_BASE_PATH = "${api.uri.domain.parameters}";
  /** Ruta base para unidades. */
  public static final String UNITS_BASE_PATH = "${api.uri.domain.units}";
  /** Ruta base para perfiles. */
  public static final String PROFILE_BASE_PATH = "${api.uri.domain.profiles}";
  /** Ruta base para citas. */
  public static final String APPOINTMENT_BASE_PATH = "${api.uri.domain.appointments}";
  /** Ruta base para clientes. */
  public static final String CUSTOMER_BASE_PATH = "${api.uri.domain.customers}";
  /** Ruta base para las citas de los clientes. */
  public static final String CUSTOMER_APPOINTMENTS_PATH = "${api.uri.data.customer.appointments}";
  /** Ruta para búsqueda datos. */
  public static final String SEARCH_PATH = "${api.uri.data.search}";
  /** Ruta para modificar datos. */
  public static final String DATA_MODIFIED_PATH = "${api.uri.data.modified}";
  /** Ruta para cargar datos iniciales a páginas. */
  public static final String INITIAL_DATA_PATH = "${api.uri.data.initial}";
  /** Ruta para actualizar los datos del perfil del usuario.. */
  public static final String USER_PROFILE_DATA_PATH = "${api.uri.data.profile}";

  /** Constructor de la class. */
  private RoutesConstant() {}
}
