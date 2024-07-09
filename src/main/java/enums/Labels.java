package enums;

public enum Labels {
	
	log_in_text("Iniciar sesión"),
	search_bar_text("Buscar por producto, marca y más..."),
	apology_message("Lo sentimos, no encontramos nada para "),
	maybe_you_mean("¿Quizá quisiste decir?"),
	search_advise("Consejos de Búsqueda"),
	first_advise("Usa palabras más simples y revisa tu ortografía."),
	second_advise("Busca términos más genéricos (ej. \"blanco\" o \"algodón\""),
	first_help_information_part_one("Llama al "),
	first_help_information_part_two("(55) 5262 - 9999"),
	first_help_information_part_three(" desde el interior de la República y área metropolitana"),
	second_help_information("Comunícate desde tu celular al *7171"),
	category_button("Categorías")
	;
	String  label;
	Labels(String label) {
		this.label = label;
	}
	public String get() {
		return label;
	}
}