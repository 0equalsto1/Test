package string;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

public class VersionComparassion {

    public static void main(String[] args) {
        String s1 = "1.2.4";
        String s2 = "1.2.3";
        String appAppVersion = "application-8.4.0";
        appAppVersion = appAppVersion.substring(appAppVersion.indexOf('-') + 1);
        System.out.println(appAppVersion);

        /*
         * System.out.println(System.currentTimeMillis());
         * System.out.println(isValidVersion(null, null));
         * System.out.println(System.currentTimeMillis());
         */
    }

    public static boolean isValidVersion(String ver1, String ver2) {
        DefaultArtifactVersion v1 = new DefaultArtifactVersion(ver1);
        DefaultArtifactVersion v2 = new DefaultArtifactVersion(ver2);

        return v1.compareTo(v2) >= 0;
    }

    public static int VersionCompare(String v1, String v2) {
        int v1Len = StringUtils.countMatches(v1, ".");
        int v2Len = StringUtils.countMatches(v2, ".");

        if (v1Len != v2Len) {
            int count = Math.abs(v1Len - v2Len);
            if (v1Len > v2Len)
                for (int i = 1; i <= count; i++)
                    v2 += ".0";
            else
                for (int i = 1; i <= count; i++)
                    v1 += ".0";
        }

        if (v1.equals(v2))
            return 0;

        String[] v1Str = StringUtils.split(v1, ".");
        String[] v2Str = StringUtils.split(v2, ".");
        for (int i = 0; i < v1Str.length; i++) {
            String str1 = "", str2 = "";
            for (char c : v1Str[i].toCharArray()) {
                if (Character.isLetter(c)) {
                    int u = c - 'a' + 1;
                    if (u < 10)
                        str1 += String.valueOf("0" + u);
                    else
                        str1 += String.valueOf(u);
                } else
                    str1 += String.valueOf(c);
            }
            for (char c : v2Str[i].toCharArray()) {
                if (Character.isLetter(c)) {
                    int u = c - 'a' + 1;
                    if (u < 10)
                        str2 += String.valueOf("0" + u);
                    else
                        str2 += String.valueOf(u);
                } else
                    str2 += String.valueOf(c);
            }
            v1Str[i] = "1" + str1;
            v2Str[i] = "1" + str2;

            int num1 = Integer.parseInt(v1Str[i]);
            int num2 = Integer.parseInt(v2Str[i]);

            if (num1 != num2) {
                if (num1 > num2)
                    return 1;
                else
                    return -1;
            }
        }
        return -1;
    }

}
