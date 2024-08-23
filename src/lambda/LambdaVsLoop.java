package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import collection.arrays.LanguageData;

public class LambdaVsLoop {

	private static List<String> languages;
	private static int translationPage = 1;
	private static Map<String, String> modifiedLanguages;
	private static Map<String, String> regionalLanguages;
	private static Map<String, String> isoLanguages;
	private static List<String> preSelectedLanguage;
	private static Map<String, String> languageToPatterns;
	private static Map<String, String> patternsTolanguage;
	static {
		preSelectedLanguage = Arrays.asList("Hindi");
		languages = Arrays.asList("Hindi", "English", "Punjabi", "Telugu", "Tamil", "Bhojpuri", "Bengali", "Malayalam",
				"Kannada", "Marathi", "Gujarati", "Haryanvi", "Urdu", "Assamese", "Rajasthani", "Odia", "Others");
		regionalLanguages = new HashMap<String, String>() {
			{
				put("tamilnadu", "Tamil");
				put("telangana", "Telugu");
				put("punjab", "Punjabi");
				put("goa", "Marathi");
				put("maharashtra", "Marathi");
				put("tripura", "Bengali");
				put("westbengal", "Bengali");
				put("bhojpuri", "Bhojpuri");
				put("karnataka", "Kannada");
				put("kerala", "Malayalam");
				put("odisha", "Odia");
				put("assam", "Assamese");
				put("rajasthan", "Rajasthani");
				put("kashmir", "Urdu");
				put("haryana", "Haryanvi");
				put("gujarat", "Gujarati");
			}
		};

		modifiedLanguages = new HashMap<String, String>() {
			{
				put("Hindi", "हिन्दी");
				put("English", "English");
				put("Tamil", "தமிழ்");
				put("Telugu", "తెలుగు");
				put("Punjabi", "ਪੰਜਾਬੀ");
				put("Marathi", "मराठी");
				put("Bengali", "বাংলা");
				put("Bhojpuri", "भोजपुरी");
				put("Kannada", "ಕನ್ನಡ");
				put("Malayalam", "മലയാളം");
				put("Gujarati", "ગુજરાતી");
				put("Odia", "ଓଡ଼ିଆ");
				put("Assamese", "অসমীয়া");
				put("Rajasthani", "राजस्थानी");
				put("Urdu", "اردو");
				put("Haryanvi", "हरयाणवी");
				put("Others", "Others");
			}
		};
		isoLanguages = new HashMap<String, String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("hi", "Hindi");
				put("hindi", "Hindi");
				put("en", "English");
				put("english", "English");
				put("ta", "Tamil");
				put("tamil", "Tamil");
				put("te", "Telugu");
				put("telugu", "Telugu");
				put("pa", "Punjabi");
				put("punjabi", "Punjabi");
				put("mr", "Marathi");
				put("marathi", "Marathi");
				put("bn", "Bengali");
				put("bengali", "Bengali");
				put("bh", "Bhojpuri");
				put("bhojpuri", "Bhojpuri");
				put("kn", "Kannada");
				put("kannada", "Kannada");
				put("ml", "Malayalam");
				put("malayalam", "Malayalam");
				put("or", "Odia");
				put("odia", "Odia");
				put("as", "Assamese");
				put("assamese", "Assamese");
				put("rj", "Rajasthani");
				put("rajasthani", "Rajasthani");
				put("ur", "Urdu");
				put("urdu", "Urdu");
				put("gu", "Gujarati");
				put("gujarati", "Gujarati");
				put("haryanvi", "Haryanvi");
			}
		};
		languageToPatterns = new HashMap<String, String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("Hindi", "L1");
				put("Tamil", "L2");
				put("English", "L3");
				put("Bengali", "L4");
				put("Bhojpuri", "L5");
				put("Others", "L6");
				put("Telugu", "L7");
				put("Punjabi", "L8");
				put("Marathi", "L9");
				put("Kannada", "L10");
				put("Malayalam", "L11");
				put("Odia", "L12");
				put("Assamese", "L13");
				put("Rajasthani", "L14");
				put("Urdu", "L15");
				put("Gujarati", "L16");
				put("Haryanvi", "L17");
			}
		};
		patternsTolanguage = new HashMap<String, String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("1", "Hindi");
				put("2", "Tamil");
				put("3", "English");
				put("4", "Bengali");
				put("5", "Bhojpuri");
				put("6", "Others");
				put("7", "Telugu");
				put("8", "Punjabi");
				put("9", "Marathi");
				put("10", "Kannada");
				put("11", "Malayalam");
				put("12", "Odia");
				put("13", "Assamese");
				put("14", "Rajasthani");
				put("15", "Urdu");
				put("16", "Gujarati");
				put("17", "Haryanvi");
			}
		};
	}

	public static List<String> getLanguages() {
		return languages;

	}

	public static Map<String, String> getModifiedLanguages() {

		return modifiedLanguages;

	}

	public static List<String> getPrefferedLanguage(String[] userlanguages) {
		List<String> prefferedLanguages = null;
		List<String> asList = Arrays.asList(userlanguages);
		List<String> list = asList.stream().filter(languages::contains).collect(Collectors.toList());
		if (list.size() > 0) {
			if (list.size() == 1 && list.contains("Others")) {
				prefferedLanguages = new ArrayList<>(1);
				prefferedLanguages.add("Hindi");
			} else {
				prefferedLanguages = asList;
			}
		} else {
			prefferedLanguages = new ArrayList<String>(2);
			prefferedLanguages.add("Hindi");
			prefferedLanguages.add("English");
		}
		return prefferedLanguages;
	}

	private static void sortListWithLang(List<LanguageData> data, String lang) {
		if (lang.equals("English"))
			return;
		LanguageData languageData = new LanguageData();
		languageData.setLanguage(lang);
		int indexOf = data.indexOf(languageData);
		if (indexOf > 0) {
			LanguageData remove = data.remove(indexOf);
			data.add(0, remove);
		}

	}

	private static String getRegionLanguage(String regionLanguage) {
		String val = regionalLanguages.get(regionLanguage.toLowerCase());
		return val == null ? "Hindi" : val;

	}

	private static String getISOLang(String deviceLang) {
		return isoLanguages.get(deviceLang.toLowerCase());
	}

	public static List<String> getPreSelectedLanguage() {
		return preSelectedLanguage;
	}

	public static void setPreSelectedLanguage(List<LanguageData> data) {
		for (LanguageData languageData : data) {
			if (preSelectedLanguage.contains(languageData.getLanguage())) {
				languageData.setPre_selected(1);
			}
		}
	}

	public static void sortIsPreferred(List<LanguageData> data) {
		data.sort((LanguageData o1, LanguageData o2) -> o2.getIs_prefered() - o1.getIs_prefered());

	}

	public static int getTranslationPage() {
		return translationPage;
	}

	public static Map<String, String> getPatternsTolanguage() {
		return patternsTolanguage;
	}

	public static String[] getLanguageByPattern(String pattern) {
		String[] languagePatternArr = pattern.split("L");
		String[] modifiedArray = Arrays.copyOfRange(languagePatternArr, 1, languagePatternArr.length);
		String[] languageArr = new String[modifiedArray.length];
		if (modifiedArray.length == 0) {
			return languageArr;
		}
		int i = 0;
		for (String key : modifiedArray) {
			languageArr[i++] = patternsTolanguage.get(key);

		}
		return languageArr;
	}

	static List<String> l1 = Arrays.asList("Hindi", "English", "Punjabi", "Telugu", "Tamil", "Bhojpuri", "Bengali",
			"Malayalam", "Kannada", "Marathi", "Gujarati", "Haryanvi", "Urdu", "Assamese", "Rajasthani", "Odia", "Others");

	public static List<String> loop(String language) {
		String[] split = language.split(",");
		List<String> list = new ArrayList<>(split.length);
		for (String s : split) {
			list.add(StringUtils.capitalize(s));
		}
		return list;

	}

	public static List<String> lambda(String language) {

		return Arrays.stream(language.split(",")).map(StringUtils::capitalize).collect(Collectors.toList());

	}

	public static List<String> commonUsingLoop(List<String> l1, List<String> l2) {
		List<String> list = new ArrayList<>(l2.size());

		for (String e : l2) {
			if (!e.equals("Others") && l1.contains(e))
				list.add(e);
		}

		return list;

	}

	public static List<String> commonUsingLambda(List<String> l1, List<String> l2) {
		return l2.stream().filter(e -> !e.equals("Others") && l1.contains(e)).collect(Collectors.toList());

	}

	public static String[] getLanguageByPattern2(String pattern) {
		return Arrays.stream(pattern.split("L")).filter(StringUtils::isNotBlank).map(new HashMap<String, String>()::get)
				.toArray(String[]::new);
	}

	public static String getLanguageToPatternsLambda(String languages) {
		String pattern = "";
		pattern = Arrays.stream(languages.toLowerCase().split(",")).map(StringUtils::capitalize)
				.filter(languageToPatterns::containsKey).map(languageToPatterns::get).collect(Collectors.joining());
		return pattern;
	}

	public static String getLanguageToPatternsLoop(String languages) {
		StringBuilder sb = new StringBuilder();
		String[] split = languages.toLowerCase().split(",");
		for (String str : split) {
			String val = languageToPatterns.get(StringUtils.capitalize(str));
			if (StringUtils.isNotBlank(val))
				sb.append(val);
		}
		return sb.toString();
	}

	public static List<String> getCommonLangs(List<String> langs, List<String> languages) {
		List<String> list = new ArrayList<>(langs.size());

		for (String e : languages) {
			if (!e.equals("Others") && langs.contains(e))
				list.add(e);
		}

		return list;
	}

	public static void main(String[] args) {
		String lang = "Bhojpuri,Hindi,Haryanvi,English,Bengali,Urdu";
		List<String> l2 = Arrays.asList("Telugu", "Tamil", "Hindi", "English", "Punjabi");
		l2.remove(0);
		System.out.println(l2);
		System.out.println(System.currentTimeMillis());
//		  System.out.println(commonUsingLambda(l1, l2));
//		System.out.println(getCommonLangs(l2, languages));
		System.out.println(System.currentTimeMillis());

	}
}
