#author:Galo Sanchez
#language: en

Feature: Flujo de Compra

  @exitoso

  Scenario Outline: Comprar dos productos
    #Acceder al sitio web de pruebas
    Given que "Galo" accede al sitio web de prueba Saucedemo
    #Ingresar las credenciales e iniciar sesión
    When ingreso las credenciales e inicio sesión
    #Agrego los productos al carrito
    Then agrego dos productos al carrito
    #Verifico que el carrito tenga los productos correctos
    And valido que el carrito contiene los dos productos
    #Completo el formulario de compra
    When completo el formulario de compra con "<name>" "<lastname>" "<postal_code>"
    #Verifico el resumen de compra
    Then verifico el resumen de la compra
    #Y finalizo la compra
    And finalizo la compra

    Examples:
    | name | lastname | postal_code |
    | Galo   | Sanchez  | 12345         |
    | María  | Gómez    | 67890         |