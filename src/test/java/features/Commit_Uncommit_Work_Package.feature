@Commit_Uncommit_Work_Package
Feature: Commit Uncommit Work Package
	@PAF002-01
  Scenario: Hacer commit en un work package
  	Given ingreso a MXT con username "<Username>" y password "<Password>"
    When busco un barcode "<Barcode>" desde el buscador de barcode
    And el barcode "<Barcode>" de tipo WorkPackage se encuentra en MTX
    Then realizo commit sobre el WorkPackage "<Barcode>" con username "<Username>" y password "<Password>"

    Examples: 
      | Username     | Password  | Barcode     |
      | MROStress014 | L@t@m2026 | T00QECR4 	 |
      | MROStress014 | L@t@m2026 | T00QECR6	   |
  @PAF002-01  
	Scenario: Hacer uncommit en un work package
		Given ingreso a MXT con username "<Username>" y password "<Password>"
    When busco un barcode "<Barcode>" de tipo "<TipoBarcode>" desde el buscador de barcode
    And el barcode "<Barcode>" de tipo "<TipoBarcode>" se encuentra en MTX
	  Then realizo uncommit sobre el WorkPackage "<Barcode>" con username "<Username>" y password "<Password>"

    Examples: 
      | Username     | Password  | Barcode     |
      | MROStress014 | L@t@m2026 | T00QECR4 	 |
      | MROStress014 | L@t@m2026 | T00QECR6	   |
