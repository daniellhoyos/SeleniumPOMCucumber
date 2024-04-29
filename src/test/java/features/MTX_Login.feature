@MTX_Login
Feature: MTX login
	@PAF003-01
	Scenario: Validar numero de login exitoso
	  When ingreso a MXT con "<Username>" y "<Password>" "<n>" veces
	  Then valido el numero de login que fueron exitosos
	  
    Examples:
      | Username        | Password  | n |
      | MROStress014 		| L@t@m2025 | 2 |
      | MROStress002 		| L@t@m2025 | 2 |