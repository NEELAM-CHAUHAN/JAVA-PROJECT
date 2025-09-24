package edu.ccrm.util;

import edu.ccrm.domain.Course;
import java.util.Comparator;

public class CourseComparator {
    public static Comparator<Course> byCode() {
        return (c1, c2) -> c1.getCode().compareTo(c2.getCode());
    }
    public static Comparator<Course> byTitle() {
        return (c1, c2) -> c1.getTitle().compareTo(c2.getTitle());
    }
}
