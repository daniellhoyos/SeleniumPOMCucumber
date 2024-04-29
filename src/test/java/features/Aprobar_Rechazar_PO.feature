@Aprobar_Rechazar_PO
Feature: Aprobar Rechazar PO
	@PAF001-01
  Scenario: Aprobar y rechazar PO
  	Given ingreso a MXT con username "<Username>" y password "<Password>"
    When busco un barcode "<Barcode>" desde el buscador de barcode
    And el barcode "<Barcode>" de tipo PO se encuentra en MTX
    And edito el precio de la unidad del PO "<Barcode>"
		Then realizo authorization override sobre el PO "<Barcode>" con username "<Username>" y password "<Password>"
		And realizo unauthorize order sobre el PO "<Barcode>" con username "<Username>" y password "<Password>"
		
    Examples: 
      | Username | Password | Barcode    |
      | LOAD_CDN | password | P1058680 	 |
      | LOAD_CDN | password | P1058678	 |

