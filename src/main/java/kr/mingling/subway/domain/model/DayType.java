package kr.mingling.subway.domain.model;

public enum DayType {
    WEEKDAY,
    WEEKEND_HOLIDAY;

    public static DayType parseDayType(String raw) {
        if (raw == null || raw.isBlank()) {
            return DayType.WEEKDAY;
        }

        String value = raw.replaceAll("\\s+", "");

        if (value.contains("평일")) {
            return DayType.WEEKDAY;
        }

        if (value.contains("주말") ||
            value.contains("토") ||
            value.contains("휴일") ||
            value.contains("공휴")) {
            return DayType.WEEKEND_HOLIDAY;
        }
        return DayType.WEEKDAY;
    }
}
