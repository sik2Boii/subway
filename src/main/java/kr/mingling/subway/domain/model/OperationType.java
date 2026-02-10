package kr.mingling.subway.domain.model;

public enum OperationType {
    GENERAL,
    EXPRESS,
    DIRECT;

    public static OperationType from(String raw) {
        if (raw == null) return GENERAL;

        if (raw.contains("직통")) return DIRECT;
        if (raw.contains("급행")) return EXPRESS;
        return GENERAL;
    }
}
