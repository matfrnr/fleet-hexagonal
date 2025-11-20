package org.ort.starwars.fleet.infrastructure.utils;

public class Parsing {

    /**
     * Extrait le chemin relatif d’une URL si celle-ci commence bien par la base_url
     * fournie
     */
    public static String getEndpoint(String baseUrl, String url) {
        if (url == null)
            return null;
        if (baseUrl != null && url.startsWith(baseUrl)) {
            return url.substring(baseUrl.length());
        }
        return url;
    }

    /**
     * Lit un numérique sans tenir compte d’un séparateur de millier "," "." ou
     * l'espace
     */
    public static int getInt(String value, int fallback) {
        if (value == null)
            return fallback;
        try {
            String clean = value.replaceAll("[\\s,\\.]", "");
            return Integer.parseInt(clean);
        } catch (Exception e) {
            return fallback;
        }
    }

    /**
     * Extrait les quantités encodées dans un intervalle de la forme xxx-yyy
     */
    public static int[] getRange(String value, int fallback, String sep) {
        int[] range = new int[2];
        if (value == null) {
            range[0] = fallback;
            range[1] = fallback;
            return range;
        }
        String[] parts = value.split(sep);
        range[0] = getInt(parts[0], fallback);
        range[1] = parts.length > 1 ? getInt(parts[1], fallback) : fallback;
        return range;
    }

    public static int[] getRange(String value, int fallback) {
        return getRange(value, fallback, "-");
    }

    public static int[] getRange(String value) {
        return getRange(value, -1, "-");
    }
}
