@Registro_y_compra_en_Advantage_Online_Shopping
Feature: Registro y compra en Advantage Online Shopping
	@PAA006-01 @Regression
  Scenario: Dar de alta un usuario y realizar una compra
    Given que el usuario esta en la pagina de inicio
    When el usuario navega a la pagina de registro
    And el usuario introduce la informacion de registro requerida
    Then el usuario se crea exitosamente
    
    Given que el usuario ha sido registrado exitosamente
    When el usuario navega a la pagina de inicio de sesion
    And el usuario inicia sesion con las credenciales registradas
    Then el usuario debe ser llevado al perfil de su cuenta
    
    Given que el usuario ha iniciado sesion exitosamente
    When el usuario selecciona un elemento "SPEAKERS"
    And el usuario agrega el primer articulo al carrito de compras
    Then el carrito de compras debe mostrar el elemento agregado
    