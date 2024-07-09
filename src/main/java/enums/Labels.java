package enums;

public enum Labels {
	
	log_in_text("Iniciar sesi�n"),
	search_bar_text("Buscar por producto, marca y m�s..."),
	apology_message("Lo sentimos, no encontramos nada para "),
	maybe_you_mean("�Quiz� quisiste decir?"),
	search_advise("Consejos de B�squeda"),
	first_advise("Usa palabras m�s simples y revisa tu ortograf�a."),
	second_advise("Busca t�rminos m�s gen�ricos (ej. \"blanco\" o \"algod�n\""),
	first_help_information_part_one("Llama al "),
	first_help_information_part_two("(55) 5262 - 9999"),
	first_help_information_part_three(" desde el interior de la Rep�blica y �rea metropolitana"),
	second_help_information("Comun�cate desde tu celular al *7171"),
	category_button("Categor�as")
	;
	String  label;
	Labels(String label) {
		this.label = label;
	}
	public String get() {
		return label;
	}
}