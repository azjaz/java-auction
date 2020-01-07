package codeWars.samples;



public class TestCodeWars {
    public static void main(String[] args) {
       String s = "you-have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
        System.out.println(toCamelCase(s));
    }

    static String toCamelCase(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.equals("")) {
            return "";
        }
        String[] str = s.replaceAll("[_-]", " ").split(" ");
        for(String string : str) {
            sb.append(string.substring(0, 1).toUpperCase() + string.substring(1));
        }
        String s1 = sb.toString();
        if(Character.isUpperCase(s.charAt(0))) {
            return s1;
        }
        else {
            return s1.substring(0, 1).toLowerCase() + s1.substring(1);
        }
    }
}