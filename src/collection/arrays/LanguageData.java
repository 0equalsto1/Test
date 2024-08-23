package collection.arrays;

public class LanguageData {
	private String language;
	private String translated;
	private String artwork;
	private String translation_artwork;
	private int is_prefered;
	private int translation_enabled;
	private int pre_selected;

	@Override
	public String toString() {
		return "LanguageData [language=" + language + ", translated=" + translated + ", artwork=" + artwork
				+ ", translation_artwork=" + translation_artwork + ", is_prefered=" + is_prefered
				+ ", translation_enabled=" + translation_enabled + ", pre_selected=" + pre_selected + "]";
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTranslated() {
		return translated;
	}

	public void setTranslated(String translated) {
		this.translated = translated;
	}

	public String getArtwork() {
		return artwork;
	}

	public void setArtwork(String artwork) {
		this.artwork = artwork;
	}

	public String getTranslation_artwork() {
		return translation_artwork;
	}

	public void setTranslation_artwork(String translation_artwork) {
		this.translation_artwork = translation_artwork;
	}

	public int getIs_prefered() {
		return is_prefered;
	}

	public void setIs_prefered(int is_prefered) {
		this.is_prefered = is_prefered;
	}

	public int getTranslation_enabled() {
		return translation_enabled;
	}

	public void setTranslation_enabled(int translation_enabled) {
		this.translation_enabled = translation_enabled;
	}

	public int getPre_selected() {
		return pre_selected;
	}

	public void setPre_selected(int pre_selected) {
		this.pre_selected = pre_selected;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguageData other = (LanguageData) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
